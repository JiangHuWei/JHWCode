package com.jhw.controller.backstage;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.jhw.bo.RestaurantBo;
import com.jhw.bo.TableBo;
import com.jhw.bo.UserBo;
import com.jhw.controller.base.BaseController;
import com.jhw.pojo.MTableAttentPoJo;
import com.jhw.pojo.RestaurantPoJo;
import com.jhw.pojo.TablePoJo;
import com.jhw.pojo.UserPoJo;
import com.jhw.service.MTableAttentService;
import com.jhw.service.RestaurantService;
import com.jhw.service.TableService;
import com.jhw.service.UserService;
import com.jhw.util.timedate.TimeDateUtil;
import com.jhw.util.token.TokenUtil;
import com.jhw.vo.ResultVo;

/**
 * @ClassName TableManageController
 * @Description TODO(拼桌管理)
 * @author Administrator
 * @Date 2017年10月24日 下午6:42:53
 * @version 1.0.0
 */
@Controller
@RequestMapping("/table")
public class TableManageController extends BaseController {
    
    @Autowired
    private TableService tableService;
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private UserService userService;
    
    @Autowired
    private MTableAttentService tableAttentService;
    
    /** 初始加载拼桌管理页面  -1*/
    private final int INITIAL_LOAD = -1;
    /** 非初始加载,即点击了下一页按钮后  0*/
    private final int NOT_INITIAL_LOAD = 0;
    
    /**
     * @Description (TODO 拼桌分页)
     * @param request
     * @param token 
     * @param pageNum 当前页数
     * @param originalPage 原来的页数
     * @param isInitialLoad 是否是初始加载,-1：默认初始加载,返回table_list_paging.jsp ，0：非初始加载,返回table_list_item.jsp
     * @return
     */
    @RequestMapping(value="/tablepaging")
    @ResponseBody
    public ModelAndView tablePaging(HttpServletRequest request, String token,@RequestParam(value="pageNum",required=false,defaultValue="0")String pageNum,
            @RequestParam(value="originalPage", required=false, defaultValue="0")String originalPage,
            @RequestParam(value="isInitialLoad", required=false, defaultValue="-1")String isInitialLoad) {
        ResultVo<List<TablePoJo>> resultVo = new ResultVo<>();
        HttpSession session = request.getSession();
        ModelAndView modelAndView = new ModelAndView();
        // 验证令牌有效期
        if (!TokenUtil.doValidateTokenInfo(session, token)) {
            resultVo.setIsSuccess(HANDLE_FAILED);
            resultVo.setIsOverdue(HANDLE_FAILED);
            resultVo.setMessage("登录失效,请重新登录！");
            modelAndView.setViewName("/jsp/backstage/login");
            modelAndView.addObject("result",resultVo);
            return modelAndView;
        }
        Integer initialVal = -1;
        try {
            Integer intPageNum = new Integer(pageNum);
            Integer intOriginalPage = new Integer(originalPage);
            Integer startNum = intPageNum * (LIMIT-1);
            initialVal = new Integer(isInitialLoad);
            if (initialVal == INITIAL_LOAD) {
                modelAndView.setViewName("/jsp/backstage/tableinfo/table_list_paging");
            } else if (initialVal == NOT_INITIAL_LOAD) {
                modelAndView.setViewName("/jsp/backstage/tableinfo/table_list_item");
            } 
            List<TablePoJo> tables = tableService.selectAllTable(startNum, LIMIT);
            if (tables == null || tables.size() == 0) {
                resultVo.setIsSuccess(HANDLE_FAILED);
                resultVo.setIsOverdue(HANDLE_SUCCESS);
                if (initialVal == INITIAL_LOAD) {
                    resultVo.setMessage("没有任何拼桌");
                } else if (initialVal == NOT_INITIAL_LOAD) {
                    resultVo.setMessage("已经没有更多信息了");
                } 
                modelAndView.addObject("result",resultVo);
                modelAndView.addObject("tables",tables);
                return modelAndView;
            } 
            logger.info("拼桌数量："+tables.size());
            if (tables.size() == LIMIT) {   //有上一页或下一页/不是第一页或最后一页
                if (intOriginalPage - intPageNum > 0) {     //点击了上一页
                    resultVo.setWhetherLastPage(HAS_LAST_PAGE);
                }else {                                     //点了下一页
                    resultVo.setWhetherNextPage(HAS_NETX_PAGE);
                }
                tables.remove(LIMIT - 1);
            }else {
                if (intOriginalPage - intPageNum > 0) {     //点了上一页
                    resultVo.setWhetherLastPage(NO_LAST_PAGE);
                } else {                                    //点了下一页
                    resultVo.setWhetherNextPage(NO_NEXT_PAGE);
                }
            }
            resultVo.setIsSuccess(HANDLE_SUCCESS);
            resultVo.setIsOverdue(HANDLE_SUCCESS);
            resultVo.setMessage("success");
            resultVo.setPageNo(intPageNum);
            modelAndView.addObject("tables",tables);
            modelAndView.addObject("result", resultVo);
            return modelAndView;
        } catch (Exception e) {
            logger.info(e.getMessage());
            resultVo.setIsSuccess(HANDLE_FAILED);
            resultVo.setIsOverdue(HANDLE_SUCCESS);
            resultVo.setMessage("检索异常！");
            return modelAndView;
        }
    }
    
    /**
     * @Description (TODO 前往拼桌添加页面,返回普通用户（id+nickname）和餐厅)
     * @param request
     * @param token
     * @return
     */
    @RequestMapping("/toaddpage")
    @ResponseBody
    public ModelAndView toAddTablePage(HttpServletRequest request, String token){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        ResultVo<String> resultVo = new ResultVo<>();
        try {
            // 验证令牌有效期
            if (!TokenUtil.doValidateTokenInfo(session, token)) {
                resultVo.setIsSuccess(HANDLE_FAILED);
                resultVo.setIsOverdue(HANDLE_FAILED);
                resultVo.setMessage("登录失效,请重新登录！");
                modelAndView.setViewName("/jsp/backstage/login");
                modelAndView.addObject("result",resultVo);
                return modelAndView;
            }
            //1、检索用户信息
            List<UserBo> userPoJos = userService.getAllUserInfo(-1);
            if (userPoJos == null) {
                userPoJos = new ArrayList<>();
            }
            //2、检索餐厅信息
            List<RestaurantBo> restaurantBo = restaurantService.getAllRestaurant(-1);
            if (restaurantBo == null) {
                return null;
            }
            modelAndView.setViewName("/jsp/backstage/tableinfo/table_info_add");
            modelAndView.addObject("users", userPoJos);
            modelAndView.addObject("restaurants", restaurantBo);
        } catch (Exception e) {
            // TODO: handle exception
            logger.info(e.getMessage());
            e.printStackTrace();
        }
        return modelAndView;
    }
    
    /**
     * @Description (TODO 添加拼桌)
     * @param request
     * @param tablePoJo
     * @param token
     * @return
     */
    @RequestMapping("/add_table")
    @ResponseBody
    public ResultVo<TablePoJo> toAddTable(HttpServletRequest request, TablePoJo tablePoJo){
        ResultVo<TablePoJo> resultVo = new ResultVo<>();
        HttpSession session = request.getSession();
        try {
            if (!TokenUtil.doValidateTokenInfo(session, tablePoJo.getToken())) {
                resultVo.setIsSuccess(HANDLE_FAILED);
                resultVo.setIsOverdue(HANDLE_FAILED);
                resultVo.setMessage("登录失效,请重新登录！");
                resultVo.setUrlStr("/jsp/backstage/login");
                return resultVo;
            }
            if (tablePoJo == null ||tablePoJo.getInitiatorid() == null ||tablePoJo.getRestaurantid() == null) {
                resultVo.setIsSuccess(HANDLE_FAILED);
                resultVo.setIsOverdue(HANDLE_SUCCESS);
                resultVo.setMessage("参数错误！");
                return resultVo;
            }
            String[] valueArray = TokenUtil.analiseTokenValue((String)session.getAttribute(tablePoJo.getToken()));
            List<MTableAttentPoJo> records = tablePoJo.getUserAttentPoJo();
            
            //新建拼桌
            tablePoJo.setStatus(0);     //设置拼桌状态
            tablePoJo.setCreateDate(TimeDateUtil.formatCurrentDate());        //该记录创建时间
            tablePoJo.setCreateUserid(new Integer(valueArray[0]));
            if (records!=null && records.size()>0) {
                tablePoJo.setPeopleNumber(records.size());
            }
            boolean newTable = tableService.insertSelective(tablePoJo, records);
            if (newTable) {
                logger.info("添加拼桌ok");
                resultVo.setIsSuccess(HANDLE_SUCCESS);
                resultVo.setIsOverdue(HANDLE_SUCCESS);
                resultVo.setMessage("success");
                return resultVo;
            }else {
                logger.info("添加拼桌failed");
                
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            resultVo.setIsSuccess(HANDLE_FAILED);
            resultVo.setIsOverdue(HANDLE_SUCCESS);
            resultVo.setMessage("处理异常");
            return resultVo;
        }
        resultVo.setIsSuccess(HANDLE_FAILED);
        resultVo.setIsOverdue(HANDLE_SUCCESS);
        resultVo.setMessage("处理失败");
        return resultVo;
    }

    /**
     * @Description (TODO 查看拼桌详情)
     * @param request
     * @param token
     * @param tableId
     * @return
     */
    @RequestMapping("/table_detail")
    @ExceptionHandler
    @ResponseBody
    public ModelAndView toTableDetailPage(HttpServletRequest request,HttpServletResponse response,String token,String tableId) throws Exception{
        ResultVo<String> resultVo = new ResultVo<>();
        HttpSession session = request.getSession();
        ModelAndView modelAndView = new ModelAndView();
        try {
            if (!TokenUtil.doValidateTokenInfo(session, token)) {
                logger.error("TableManageController.toTableDetailPage 登录失效,请重新登录");
                resultVo.setIsSuccess(HANDLE_FAILED);
                resultVo.setIsOverdue(HANDLE_FAILED);
                modelAndView.addObject("message", "登录失效,请重新登录！");
                modelAndView.setViewName("/jsp/backstage/login");
                return modelAndView;
            }
            Integer ttid = new Integer(tableId);
            TablePoJo tablePoJo = tableService.selectByPrimaryKey(ttid);    //根据拼桌id获取拼桌详情
            if (tablePoJo == null) {
                resultVo.setIsSuccess(HANDLE_FAILED);
                resultVo.setIsOverdue(HANDLE_SUCCESS);
                resultVo.setMessage("未检索到拼桌信息");
                return writeExcInfo(response, JSONObject.toJSONString(resultVo));
            }
            UserPoJo userPoJo = userService.selectByPrimaryKey(new Integer(tablePoJo.getInitiatorid()));
            if (userPoJo == null) {
                resultVo.setIsSuccess(HANDLE_FAILED);
                resultVo.setIsOverdue(HANDLE_SUCCESS);
                resultVo.setMessage("未检索到拼桌发起人信息");
                return writeExcInfo(response, JSONObject.toJSONString(resultVo));
            }
            List<UserBo> users = userService.selectByTableId(tablePoJo.getTtid());
            if (users == null) {
                resultVo.setIsSuccess(HANDLE_FAILED);
                resultVo.setIsOverdue(HANDLE_SUCCESS);
                resultVo.setMessage("未检索到拼桌参与人信息");
                return writeExcInfo(response, JSONObject.toJSONString(resultVo));
            }
            modelAndView.addObject("isSuccess", HANDLE_SUCCESS);
            modelAndView.addObject("isOverdue", HANDLE_SUCCESS);
            modelAndView.addObject("result", tablePoJo);
            modelAndView.addObject("uesrInfo", userPoJo);
            modelAndView.addObject("attentUsers", users);
            modelAndView.setViewName("/jsp/backstage/tableinfo/table_info_detail");
            return modelAndView;
        } catch (Exception e) {
            logger.error("TableManageController.toTableDetailPage 处理异常: "+e.getMessage());
            resultVo.setIsSuccess(HANDLE_FAILED);
            resultVo.setIsOverdue(HANDLE_SUCCESS);
            resultVo.setMessage("检索异常");
            return writeExcInfo(response, JSONObject.toJSONString(resultVo));
        }
    }
    
    /**
     * @Description (TODO 根据拼桌表主键删除拼桌)
     * @param request
     * @param response
     * @param token
     * @param tableId
     * @return
     */
    @RequestMapping("/del_table")
    @ResponseBody
    public ModelAndView toDeleteTableByTableId(HttpServletRequest request,HttpServletResponse response,String token,String tableId){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        ResultVo<String> resultVo = new ResultVo<>();
        try {
            if (!TokenUtil.doValidateTokenInfo(session, token)) {
                logger.error("TableManageController.toDeleteTableByTableId 登录失效,请重新登录");
                resultVo.setIsSuccess(HANDLE_FAILED);
                resultVo.setIsOverdue(HANDLE_FAILED);
                modelAndView.addObject("message", "登录失效,请重新登录！");
                modelAndView.setViewName("/jsp/backstage/login");
                return modelAndView;
            }
            Integer tableIdVal = new Integer(tableId);
            if (tableIdVal == null || tableIdVal <= 0) {
                resultVo.setIsSuccess(HANDLE_FAILED);
                resultVo.setIsOverdue(HANDLE_SUCCESS);
                resultVo.setMessage("参数错误,请尝试刷新页面！");
                return writeExcInfo(response, JSONObject.toJSONString(resultVo));
            }
            int delResult = tableService.deleteByPrimaryKey(tableIdVal);
            if (delResult == HANDLE_SUCCESS) {
                resultVo.setIsSuccess(HANDLE_SUCCESS);
                resultVo.setIsOverdue(HANDLE_SUCCESS);
                resultVo.setMessage("success");
                modelAndView.setViewName("redirect:/table/tablepaging?token="+token);
                return modelAndView;
            }
                
        } catch (Exception e) {
            logger.error("TableManageController.toDeleteTableByTableId异常： "+e.getMessage());
            resultVo.setIsSuccess(HANDLE_FAILED);
            resultVo.setIsOverdue(HANDLE_SUCCESS);
            resultVo.setMessage("操作异常,请重试！");
            return writeExcInfo(response, JSONObject.toJSONString(resultVo));
        }
        return modelAndView;
    }
    
    /**
     * @Description (TODO 前往拼桌编辑页面)
     * @param request
     * @param response
     * @param token
     * @param tableId
     * @return
     */
    @RequestMapping("/to_editpage")
    @ResponseBody
    public ModelAndView toEditTablePage(HttpServletRequest request, HttpServletResponse response,String token,String tableId){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        ResultVo<String> resultVo = new ResultVo<>();
        try {
            if (!TokenUtil.doValidateTokenInfo(session, token)) {
                logger.error("TableManageController.toEditTablePage 登录失效,请重新登录");
                resultVo.setIsSuccess(HANDLE_FAILED);
                resultVo.setIsOverdue(HANDLE_FAILED);
                modelAndView.addObject("message", "登录失效,请重新登录！");
                modelAndView.setViewName("/jsp/backstage/login");
                return modelAndView;
            }
            Integer tableIdVal = new Integer(tableId);
            //拼桌详情
            TablePoJo tablePoJo = tableService.selectByPrimaryKey(tableIdVal);
            if (tablePoJo == null) {
                resultVo.setIsSuccess(HANDLE_FAILED);
                resultVo.setIsOverdue(HANDLE_SUCCESS);
                resultVo.setMessage("拼桌检索失败,请刷新重试！");
                return writeExcInfo(response, JSONObject.toJSONString(resultVo));
            }
            //1、检索用户信息
            List<UserBo> userBos = userService.getAllUserInfo(tablePoJo.getInitiatorid());
            if (userBos == null || userBos.size()==0) {
                resultVo.setIsSuccess(HANDLE_FAILED);
                resultVo.setIsOverdue(HANDLE_SUCCESS);
                resultVo.setMessage("用户信息检索失败,请刷新重试！");
                return writeExcInfo(response, JSONObject.toJSONString(resultVo));
            }
            //2、检索餐厅信息
            List<RestaurantBo> restaurantBo = restaurantService.getAllRestaurant(tablePoJo.getRestaurantid());
            if (restaurantBo == null) {
                resultVo.setIsSuccess(HANDLE_FAILED);
                resultVo.setIsOverdue(HANDLE_SUCCESS);
                resultVo.setMessage("餐厅检索失败,请刷新重试！");
                return writeExcInfo(response, JSONObject.toJSONString(resultVo));
            }
            //根据拼桌表主键检索参加拼桌用户
            List<UserBo> attentedUsers = userService.selectByTableId(new Integer(tableId));
            if (attentedUsers == null) {
                resultVo.setIsSuccess(HANDLE_FAILED);
                resultVo.setIsOverdue(HANDLE_SUCCESS);
                resultVo.setMessage("未检索到拼桌参与人信息");
                return writeExcInfo(response, JSONObject.toJSONString(resultVo));
            }
            modelAndView.setViewName("/jsp/backstage/tableinfo/table_info_edit");
            modelAndView.addObject("initiators", userBos);
            modelAndView.addObject("attentUsers", attentedUsers);
            modelAndView.addObject("restaurants", restaurantBo);
            modelAndView.addObject("table", tablePoJo);
            return modelAndView;
        } catch (Exception e) {
            logger.error("TableManageController.toEditTablePage异常： "+e.getMessage());
            resultVo.setIsSuccess(HANDLE_FAILED);
            resultVo.setIsOverdue(HANDLE_SUCCESS);
            resultVo.setMessage("操作异常,请重试！");
            return writeExcInfo(response, JSONObject.toJSONString(resultVo));
        }
    }
    
    /**
     * @Description (TODO 更新拼桌)
     * @param request
     * @param tablePoJo
     * @return
     */
    @RequestMapping("/update_table")
    @ResponseBody
    public ModelAndView doUpdateTable(HttpServletRequest request,HttpServletResponse response ,TableBo tableBo){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        ResultVo<String> resultVo = new ResultVo<>();
        try {
            if (!TokenUtil.doValidateTokenInfo(session, tableBo.getTokenStr())) {
                logger.error("TableManageController.toEditTablePage 登录失效,请重新登录");
                resultVo.setIsSuccess(HANDLE_FAILED);
                resultVo.setIsOverdue(HANDLE_FAILED);
                modelAndView.addObject("message", "登录失效,请重新登录！");
                modelAndView.setViewName("/jsp/backstage/login");
                return modelAndView;
            }
            TablePoJo tablePoJo = tableBo.getTablePoJo();
            if (tablePoJo == null) {
                resultVo.setIsSuccess(HANDLE_FAILED);
                resultVo.setIsOverdue(HANDLE_SUCCESS);
                resultVo.setMessage("参数异常");
                return writeExcInfo(response, JSONObject.toJSONString(resultVo));
            }
            //1、更新table表本身
            List<MTableAttentPoJo> attentPoJos = tablePoJo.getUserAttentPoJo();
            if (attentPoJos == null || attentPoJos.size() == 0) {
                resultVo.setIsSuccess(HANDLE_FAILED);
                resultVo.setIsOverdue(HANDLE_SUCCESS);
                resultVo.setMessage("必须至少有一人参加！");
                return writeExcInfo(response, JSONObject.toJSONString(resultVo));
            }
            tablePoJo.setAttentNumber(attentPoJos.size());      //设置参加拼桌人数
            
            int updateResult = tableService.updateByPrimaryKey(tablePoJo);
            if (updateResult == HANDLE_SUCCESS) {
                resultVo.setIsSuccess(HANDLE_SUCCESS);
                resultVo.setIsOverdue(HANDLE_SUCCESS);
                resultVo.setMessage("success");
                modelAndView.setViewName("redirect:/table/tablepaging?token="+tableBo.getTokenStr());
            } else {
                resultVo.setIsSuccess(HANDLE_FAILED);
                resultVo.setIsOverdue(HANDLE_SUCCESS);
                resultVo.setMessage("更新失败,请重试！");
                return writeExcInfo(response, JSONObject.toJSONString(resultVo));
            }
        } catch (Exception e) {
            logger.error("TableManageController.doUpdateTable异常： "+e.getMessage());
            resultVo.setIsSuccess(HANDLE_FAILED);
            resultVo.setIsOverdue(HANDLE_SUCCESS);
            resultVo.setMessage("操作异常,请重试！");
            e.printStackTrace();
            return writeExcInfo(response, JSONObject.toJSONString(resultVo));
        }
        return modelAndView;
    }
    
    
    
    
}
