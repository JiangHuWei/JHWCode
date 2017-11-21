package com.jhw.controller.backstage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jhw.bo.RoleBo;
import com.jhw.bo.UserBo;
import com.jhw.controller.base.BaseController;
import com.jhw.pojo.MUserRolePoJo;
import com.jhw.pojo.UserPoJo;
import com.jhw.service.UserRoleService;
import com.jhw.service.UserService;
import com.jhw.util.base64.Base64AndImageUtil;
import com.jhw.util.token.TokenUtil;
import com.jhw.vo.ResultVo;
import com.mangofactory.swagger.models.dto.Model;

/**
 * 
 * @ClassName UserListController
 * @Description TODO(用户资料管理)
 * @author Administrator
 * @Date 2017年10月12日 上午10:29:04
 * @version 1.0.0
 */
@Controller
@RequestMapping("/user_list")
public class UserListController extends BaseController {

    @Autowired
    private UserService mUserService;
    
    @Autowired
    private UserRoleService mUserRoleService;
    
    /**
     * @Description (TODO 自定义数据绑定，springmvc默认的bean中没有date、double等类型，所以需要自定义绑定)
     * @param binder
     */
    @InitBinder  
    public void initBinder(WebDataBinder binder) {  
        //绑定日期类型Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        dateFormat.setLenient(false);  
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));  
    }  
    
    /**
     * @Description (TODO 分页)
     * @param request
     * @param pageNum 当前页数
     * @param originalPage 原来的页数
     */
    @RequestMapping(value="/paging")
    @ResponseBody
    public ModelAndView pagingUserInfo(HttpServletRequest request, String pageNum, String originalPage){
        
        logger.info("=============================用户信息分页==============================");
        //还需加验证token令牌是否过期, 安全验证可以使用面向切面编程
        ModelAndView modelAndView = new ModelAndView();
        ResultVo<List<UserPoJo>> resultVo = new ResultVo<>();
//        //验证令牌有效期
//        if (!TokenUtil.doValidateTokenInfo(session, token)) {
//            resultVo.setIsSuccess(HANDLE_SUCCESS);
//            resultVo.setIsOverdue(HANDLE_FAILED);
//            resultVo.setMessage("登录失效,请重新登录！");
//            modelAndView.setViewName("/jsp/backstage/login.jsp");
//            modelAndView.addObject("result", resultVo);
//            return modelAndView;
//        }
        try {
            Integer intPageNum = new Integer(pageNum);
            Integer intOriginalPage = new Integer(originalPage);
            Integer startNum = intPageNum * (LIMIT-1);
            
            List<UserPoJo> userPoJos = mUserService.getAllValidUser(startNum, LIMIT);
            if (userPoJos==null || userPoJos.size() == 0) {
                resultVo.setIsSuccess(HANDLE_FAILED);
                resultVo.setMessage("未检索到任何用户资料");
            }else {
                if (userPoJos.size() == LIMIT) {
                    if (intOriginalPage - intPageNum > 0) {             //点击上一页操作
                        resultVo.setWhetherLastPage(HAS_LAST_PAGE);     //有上一页
                    }else {                                             //点击下一页
                        resultVo.setWhetherNextPage(HAS_NETX_PAGE);     //有下一页
                    }
                    userPoJos.remove(LIMIT-1);
                }else {
                    if (intOriginalPage - intPageNum > 0) {             //点击上一页操作
                        resultVo.setWhetherLastPage(NO_LAST_PAGE);      //没有上一页
                    }else {                                             //点击下一页
                        resultVo.setWhetherNextPage(NO_NEXT_PAGE);      //没有下一页
                    }
                }
                resultVo.setIsSuccess(HANDLE_SUCCESS);
                resultVo.setMessage("success");
                resultVo.setResultObj(userPoJos);
                resultVo.setPageNo(intPageNum);                         //设置当前页数
            }
        } catch (Exception e) {
            resultVo.setIsSuccess(HANDLE_FAILED);
            resultVo.setMessage("分页操作异常");
        }
        modelAndView.setViewName("/jsp/backstage/userinfo/user_list_paging");
        modelAndView.addObject("results", resultVo);
        return modelAndView;
    }
    
    /**
     * 
     * @Description (TODO 前往添加用户页面)
     * @param request 
     * @param token 授权令牌
     * @return
     */
    @RequestMapping(value="/to_add_user_page")
    @ResponseBody
    public ModelAndView toAddUserPage(HttpServletRequest request, String token){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        ResultVo<String> resultVo = new ResultVo<>();
        try {
            //验证令牌有效期
            if (!TokenUtil.doValidateTokenInfo(session, token)) {
                resultVo.setIsSuccess(HANDLE_SUCCESS);
                resultVo.setIsOverdue(HANDLE_FAILED);
                resultVo.setMessage("登录失效,请重新登录！");
                modelAndView.setViewName("/jsp/backstage/login");
                modelAndView.addObject("result", resultVo);
                return modelAndView;
            }
            resultVo.setIsSuccess(HANDLE_SUCCESS);
            resultVo.setIsOverdue(HANDLE_SUCCESS);
            resultVo.setMessage("即将进入添加用户页面！");
            modelAndView.setViewName("/jsp/backstage/userinfo/user_info_add");
            modelAndView.addObject("result", resultVo);
        } catch (Exception e) {
            resultVo.setIsSuccess(HANDLE_FAILED);
            resultVo.setMessage("处理异常！");
            modelAndView.addObject("result", resultVo);
            return modelAndView;
        }
        return modelAndView;
    }
    
    /**
     * @Description (TODO 添加用户)
     * @param request
     * @param userBo 
     * @return
     */
    @RequestMapping(value="/addUser")
    @ResponseBody
    public ModelAndView addUser(HttpServletRequest request, UserBo userBo){
        logger.info("添加用户信息");
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        ResultVo<String> resultVo = new ResultVo<>();
        try {
            if (userBo == null) {
                resultVo.setIsSuccess(HANDLE_FAILED);
                resultVo.setMessage("参数错误！");
//                modelAndView.setViewName("/jsp/backstage/login");
//                modelAndView.addObject("result", resultVo);
                return modelAndView;
            }
            //验证令牌有效期
            if (!TokenUtil.doValidateTokenInfo(session, userBo.getTokenStr())) {
                resultVo.setIsSuccess(HANDLE_SUCCESS);
                resultVo.setIsOverdue(HANDLE_FAILED);
                resultVo.setMessage("登录失效,请重新登录！");
//                modelAndView.setViewName("/jsp/backstage/login");
//                modelAndView.addObject("result", resultVo);
                return modelAndView;
            }
            
            UserPoJo tmUserPoJo = new UserPoJo();
            tmUserPoJo.setActualName(userBo.getUserPoJo().getActualName());
            tmUserPoJo.setNickname(userBo.getUserPoJo().getNickname());
            tmUserPoJo.setCreditValue(userBo.getUserPoJo().getCreditValue());
            tmUserPoJo.setPhone(userBo.getUserPoJo().getPhone());
            tmUserPoJo.setIdCardno(userBo.getUserPoJo().getIdCardno());
            tmUserPoJo.setAuthenticationCheck(userBo.getUserPoJo().getAuthenticationCheck());
            tmUserPoJo.setSchool(userBo.getUserPoJo().getSchool());
            tmUserPoJo.setSex(userBo.getUserPoJo().getSex());
            tmUserPoJo.setSmoke(userBo.getUserPoJo().getSmoke());
            tmUserPoJo.setDrink(userBo.getUserPoJo().getDrink());
            tmUserPoJo.setBirthday(userBo.getUserPoJo().getBirthday());
            tmUserPoJo.setAge(userBo.getUserPoJo().getAge());
            tmUserPoJo.setAboutMe(userBo.getUserPoJo().getAboutMe());
            tmUserPoJo.setPwd("");
            tmUserPoJo.setHeight(0);
            tmUserPoJo.setWork(29);
            tmUserPoJo.setDistrict(4);
            tmUserPoJo.setStatus(0);    //默认有效用户
            int result = mUserService.insert(tmUserPoJo);
            if (result > 0) {
                logger.info("新增成功: "+tmUserPoJo.getTuid());
                //上传头像
                if (userBo.getUserPoJo().getHeadimgUrl() != null && userBo.getUserPoJo().getHeadimgUrl().length() >= 0) {
                    String fileUploadPath = getHeadImgStorePath(tmUserPoJo.getTuid());        //获取上传路径
                    if (Base64AndImageUtil.generateImage(userBo.getUserPoJo().getHeadimgUrl(), fileUploadPath)) {
                        logger.info("文件上传成功");
                        //将头像路径存储到对应用户记录里
                        String hostPath = getHeadImgHostPath(TYPE_HEAD_IMG, tmUserPoJo.getTuid(), 1);
                        if (hostPath!=null && hostPath.length()>0) {
                            tmUserPoJo.setHeadimgUrl(hostPath);
                            if (mUserService.updateHeadImgByUserId(tmUserPoJo)>0) {
                                logger.info("头像路径更新成功");
                            }
                            
                        }
                    }
                }
                //给用户添加角色
                List<MUserRolePoJo> userRolePoJos = new ArrayList<>();
                MUserRolePoJo userRolePoJo1 = new MUserRolePoJo();
                userRolePoJo1.setUserid(tmUserPoJo.getTuid());
                userRolePoJo1.setRoleid(RoleBo.NORMAL_USER);
                userRolePoJo1.setCreateDate(new Date());
                userRolePoJo1.setUpdateDate(new Date());
                MUserRolePoJo userRolePoJo2 = new MUserRolePoJo();
                userRolePoJo2.setUserid(tmUserPoJo.getTuid());
                userRolePoJo2.setRoleid(RoleBo.VIRTUAL_USER);
                userRolePoJo2.setCreateDate(new Date());
                userRolePoJo2.setUpdateDate(new Date());
                userRolePoJos.add(userRolePoJo1);
                userRolePoJos.add(userRolePoJo2);
                //需要通过token取得系统登录人id和昵称
                // .....待续
                int insertRoleResult = mUserRoleService.insertRoleByUserId(userRolePoJos);
                if (insertRoleResult > 0) {
                    logger.info("用户角色授予成功");
                }
                resultVo.setIsSuccess(HANDLE_SUCCESS);
                resultVo.setIsOverdue(HANDLE_SUCCESS);
                resultVo.setMessage("Success");
                modelAndView.setViewName("/jsp/backstage/userinfo/user_info_add");
                modelAndView.addObject("result", resultVo);
                return modelAndView;
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
            resultVo.setIsSuccess(HANDLE_FAILED);
            resultVo.setMessage("处理异常！");
//            modelAndView.setViewName("/jsp/backstage/login");
//            modelAndView.addObject("result", resultVo);
            return modelAndView;
        }
        return modelAndView;
    }
    
    /**
     * 
     * @Description (TODO 根据用户id删除用户)
     * @param request 
     * @param userId 
     * @return
     */
    @RequestMapping(value="/deluser")
    @ResponseBody
    public ResultVo<String> doDeleteUserById(HttpServletRequest request,String token, int userId){
        ResultVo<String> resultVo = new ResultVo<>();
        HttpSession session = request.getSession();
        //验证令牌有效期
        if (!TokenUtil.doValidateTokenInfo(session, token)) {
            logger.info("令牌失效");
            resultVo.setIsSuccess(HANDLE_SUCCESS);
            resultVo.setIsOverdue(HANDLE_FAILED);
            resultVo.setMessage("登录失效,请重新登录！");
            return resultVo;
        }
        if (userId <= 0) {
            logger.info("参数错误");
            resultVo.setIsSuccess(HANDLE_FAILED);
            resultVo.setIsOverdue(HANDLE_FAILED);
            resultVo.setMessage("参数错误！");
            return resultVo;
        }
        int result = mUserService.deleteByPrimaryKey(userId);
        if (result > 0) {
            logger.info("删除"+userId+"成功");
            UserBo userBo = new UserBo();
            userBo.setTokenStr(token);
            resultVo.setIsSuccess(HANDLE_SUCCESS);
            resultVo.setIsOverdue(HANDLE_SUCCESS);
            resultVo.setMessage("success");
            resultVo.setUrlStr("/bs_index/toUserInfoManagePage");
            resultVo.setResultObj(JSONObject.toJSONString(userBo));
            return resultVo;
        }
        resultVo.setIsSuccess(HANDLE_FAILED);
        resultVo.setIsOverdue(HANDLE_FAILED);
        resultVo.setMessage("删除失败");
        return resultVo;
    } 
    
    /**
     * @Description (TODO 前往用户信息查看页面)
     * @param request
     * @param token
     * @param userId
     * @return
     */
    @RequestMapping("/to_user_info_check_page")
    @ResponseBody
    public ModelAndView toUserInfoCheckPage(HttpServletRequest request, String token, int userId){
        ModelAndView modelAndView = new ModelAndView();
        ResultVo<UserPoJo> resultVo = new ResultVo<>();
        HttpSession session = request.getSession();
        //验证令牌有效期
        if (!TokenUtil.doValidateTokenInfo(session, token)) {
            logger.info("令牌失效");
            resultVo.setIsSuccess(HANDLE_SUCCESS);
            resultVo.setIsOverdue(HANDLE_FAILED);
            resultVo.setMessage("登录失效,请重新登录！");
            modelAndView.setViewName("/jsp/backstage/login");
            return modelAndView;
        }
        if (userId <= 0) {
            logger.info("参数错误");
            resultVo.setIsSuccess(HANDLE_FAILED);
            resultVo.setIsOverdue(HANDLE_SUCCESS);
            resultVo.setMessage("参数错误！");
            return modelAndView;
        }
        UserPoJo userPoJo = mUserService.selectByPrimaryKey(userId);
        if (userPoJo == null || userPoJo.getTuid() == 0) {
            resultVo.setIsSuccess(HANDLE_FAILED);
            resultVo.setIsOverdue(HANDLE_SUCCESS);
            resultVo.setMessage("failed");
            return modelAndView;
        }
        resultVo.setIsSuccess(HANDLE_SUCCESS);
        resultVo.setIsOverdue(HANDLE_SUCCESS);
        resultVo.setMessage("success");
        resultVo.setResultObj(userPoJo);
        modelAndView.setViewName("/jsp/backstage/userinfo/user_info_check");
        modelAndView.addObject("result", resultVo);
        return modelAndView;
    }
    
    
    /**
     * @Description (TODO 前往用户信息编辑页面)
     * @param request
     * @param token
     * @param userId
     * @return
     */
    @RequestMapping("/to_user_info_edit_page")
    @ResponseBody
    public ResultVo<UserPoJo> toUserInfoEditPage(HttpServletRequest request, String token, int userId){
        ModelAndView modelAndView = new ModelAndView();
        ResultVo<UserPoJo> resultVo = new ResultVo<>();
        HttpSession session = request.getSession();
        //验证令牌有效期
        if (!TokenUtil.doValidateTokenInfo(session, token)) {
            logger.info("令牌失效");
            modelAndView.setViewName("/jsp/backstage/login");
            resultVo.setIsSuccess(HANDLE_SUCCESS);
            resultVo.setIsOverdue(HANDLE_FAILED);
            resultVo.setMessage("登录失效,请重新登录！");
            resultVo.setUrlStr("/jsp/backstage/login");
            return resultVo;
        }
        if (userId <= 0) {
            logger.info("参数错误");
            resultVo.setIsSuccess(HANDLE_FAILED);
            resultVo.setIsOverdue(HANDLE_SUCCESS);
            resultVo.setMessage("参数错误！");
            return resultVo;
        }
        UserPoJo userPoJo = mUserService.selectByPrimaryKey(userId);
        if (userPoJo == null || userPoJo.getTuid() == 0) {
            resultVo.setIsSuccess(HANDLE_FAILED);
            resultVo.setIsOverdue(HANDLE_SUCCESS);
            resultVo.setMessage("failed");
            return resultVo;
        }
        resultVo.setUrlStr("/jsp/backstage/userinfo/user_info_edit");
        resultVo.setIsSuccess(HANDLE_SUCCESS);
        resultVo.setIsOverdue(HANDLE_SUCCESS);
        resultVo.setMessage("success");
        resultVo.setResultObj(userPoJo);
        return resultVo;
    }
    
    /**
     * 
     * @Description (TODO 编辑/更新用户信息)
     * @param request
     * @param userBo
     * @return
     */
    @RequestMapping(value="/editUser")
    @ResponseBody
    public ResultVo<String> editUser(HttpServletRequest request,RedirectAttributes attr, UserBo userBo){
        logger.info("编辑/更新用户信息");
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        ResultVo<String> resultVo = new ResultVo<>();
        try {
            if (userBo == null) {
                resultVo.setIsSuccess(HANDLE_FAILED);
                resultVo.setIsOverdue(HANDLE_SUCCESS);
                resultVo.setMessage("参数错误！");
                return resultVo;
            }
            //验证令牌有效期
            if (!TokenUtil.doValidateTokenInfo(session, userBo.getTokenStr())) {
                resultVo.setIsSuccess(HANDLE_SUCCESS);
                resultVo.setIsOverdue(HANDLE_FAILED);
                resultVo.setMessage("登录失效,请重新登录！");
                modelAndView.setViewName("/jsp/backstage/login");
                return resultVo;
            }
            UserPoJo tmUserPoJo = new UserPoJo();
            tmUserPoJo.setTuid(userBo.getUserPoJo().getTuid());
            tmUserPoJo.setActualName(userBo.getUserPoJo().getActualName());
            tmUserPoJo.setNickname(userBo.getUserPoJo().getNickname());
            tmUserPoJo.setCreditValue(userBo.getUserPoJo().getCreditValue());
            tmUserPoJo.setPhone(userBo.getUserPoJo().getPhone());
            tmUserPoJo.setIdCardno(userBo.getUserPoJo().getIdCardno());
            tmUserPoJo.setAuthenticationCheck(userBo.getUserPoJo().getAuthenticationCheck());
            tmUserPoJo.setSchool(userBo.getUserPoJo().getSchool());
            tmUserPoJo.setSex(userBo.getUserPoJo().getSex());
            tmUserPoJo.setSmoke(userBo.getUserPoJo().getSmoke());
            tmUserPoJo.setDrink(userBo.getUserPoJo().getDrink());
            tmUserPoJo.setBirthday(userBo.getUserPoJo().getBirthday());
            tmUserPoJo.setAge(userBo.getUserPoJo().getAge());
            tmUserPoJo.setAboutMe(userBo.getUserPoJo().getAboutMe());
            tmUserPoJo.setPwd("");
            tmUserPoJo.setHeight(0);
            tmUserPoJo.setWork(29);
            tmUserPoJo.setDistrict(4);
            tmUserPoJo.setStatus(0);    //默认有效用户
            int result = mUserService.updateByPrimaryKeySelective(tmUserPoJo);
            if (result > 0) {
                logger.info("更新成功: "+tmUserPoJo.getTuid());
                //上传头像
//                if (userBo.getHeadimgUrl() != null && userBo.getHeadimgUrl().length() >= 0) {
//                    String fileUploadPath = getHeadImgStorePath(tmUserPoJo.getTuid());        //获取上传路径
//                    if (Base64AndImageUtil.generateImage(userBo.getHeadimgUrl(), fileUploadPath)) {
//                        logger.info("文件上传成功");
//                        //将头像路径存储到对应用户记录里
//                        String hostPath = getHeadImgHostPath(TYPE_HEAD_IMG, tmUserPoJo.getTuid(), 1);
//                        if (hostPath!=null && hostPath.length()>0) {
//                            tmUserPoJo.setHeadimgUrl(hostPath);
//                            if (mUserService.updateHeadImgByUserId(tmUserPoJo)>0) {
//                                logger.info("头像路径更新成功");
//                            }
//                        }
//                    }
//                }
                UserBo bUserBo = new UserBo();
                bUserBo.setTokenStr(userBo.getTokenStr());
                resultVo.setIsSuccess(HANDLE_SUCCESS);
                resultVo.setIsOverdue(HANDLE_SUCCESS);
                resultVo.setMessage("Success");
                resultVo.setResultObj(JSON.toJSONString(bUserBo));
                resultVo.setUrlStr("/bs_index/toUserInfoManagePage");
                return resultVo;
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
            resultVo.setIsSuccess(HANDLE_FAILED);
            resultVo.setIsOverdue(HANDLE_SUCCESS);
            resultVo.setMessage("处理异常！");
            return resultVo;
        }
        return resultVo;
    }
    
}
