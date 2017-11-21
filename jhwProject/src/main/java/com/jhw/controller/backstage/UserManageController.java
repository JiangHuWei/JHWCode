package com.jhw.controller.backstage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.jhw.controller.base.BaseController;
import com.jhw.pojo.PowerMenuPoJo;
import com.jhw.pojo.UserPoJo;
import com.jhw.service.UserService;
import com.jhw.util.login.LoginUtil;
import com.jhw.util.md5.Md5Util;
import com.jhw.util.timedate.TimeDateUtil;
import com.jhw.util.token.TokenUtil;
import com.jhw.vo.PowerMenuVo;
import com.jhw.vo.ResultVo;

/**
 * 后台用户管理
 * @ClassName UserManageController
 * @Description TODO(后台用户信息管理)
 * @author Jce
 * @Date 2017年9月15日 下午5:00:48
 * @version 1.0.0
 */
@Controller
@RequestMapping("/backstage")
public class UserManageController extends BaseController{
    //处理成功
    private final int HANDLE_SUCCESS = 1;
    //处理失败
    private final int HANDLE_FAILE = 0;
    
    @Autowired
    private UserService userService;
    
    /**
     * @Description (TODO 前往后台登录页面，验证token令牌是否有效，有效则进入首页，无效则进入登陆页面)
     * @param request
     * @return
     */
    @RequestMapping(value="/tologinpage")
    @ResponseBody
    public ResultVo<String> toLoginPage(HttpServletRequest request, String token){
        HttpSession session = request.getSession();
        ResultVo<String> resultVo = new ResultVo<>();
        //验证token有效期
        if (token == null || token.length() == 0) {
//            return "/jsp/backstage/login";
            resultVo.setIsSuccess(HANDLE_FAILE);
            resultVo.setMessage("请重新登录");
            return resultVo;
        }
        String valueStr = (String) session.getAttribute(token);
        if (valueStr == null || valueStr.length() == 0) {
//            return "/jsp/backstage/login";
            resultVo.setIsSuccess(HANDLE_FAILE);
            resultVo.setMessage("请重新登录");
            return resultVo;
        }
        String tokenVal[] = TokenUtil.analiseTokenValue(valueStr);
        String timeStamp = tokenVal[1];
        try {
            long currentTime = System.currentTimeMillis();
            long oldTime = Long.valueOf(timeStamp);
            int day = (int) ((currentTime - oldTime)/(1000*60*60*24*7));
//            long day = ((currentTime - oldTime)/(1000*60));
            if (day>=7) {
                session.removeAttribute(token);     //token失效,从session中删除
//                return "/jsp/backstage/login";
                resultVo.setIsSuccess(HANDLE_FAILE);
                resultVo.setMessage("请重新登录");
                return resultVo;
            }
        } catch (Exception e) {
            resultVo.setIsSuccess(HANDLE_FAILE);
            resultVo.setMessage("登录异常！");
            return resultVo;
        }
        resultVo.setIsSuccess(HANDLE_SUCCESS);
        resultVo.setMessage("success");
        resultVo.setUrlStr("/jsp/backstage/index.jsp");
        return resultVo;
    }
    
    /**
     * @Description (TODO 后台账号密码登录)
     * @param request
     * @param resultMap
     * @param userPoJo
     * @return
     */
    @RequestMapping(value="/login_by_pwd", method=RequestMethod.POST)
    @ResponseBody
    public ResultVo<String> loginByPwd(HttpServletRequest request, ModelAndView resultMap, UserPoJo userPoJo) {
        logger.info("通过账号密码登录！");
        HttpSession session = request.getSession();
        ResultVo<String> resultVo = new ResultVo<>();
        if (userPoJo == null) {
            resultVo.setIsSuccess(HANDLE_FAILE);;
            resultVo.setMessage("参数错误异常！");
            return resultVo;
        }
        if (userPoJo.getNickname() == null || userPoJo.getNickname().length()==0) {
            resultVo.setIsSuccess(HANDLE_FAILE);
            resultVo.setMessage("登录名不能为空！");
            return resultVo;
        }
        if (userPoJo.getPwd() == null || userPoJo.getPwd().length()==0) {
            resultVo.setIsSuccess(HANDLE_FAILE);
            resultVo.setMessage("密码不能为空！");
            return resultVo;
        }
        try {
            //登录失败、记录登录失败次数，如果失败次数超过3次则冻结账号半小时，如果输错超过6次则冻结该账号。可以通过超级管理员解冻。
            String accountState = (String) session.getAttribute(userPoJo.getNickname());
            Map<String, Boolean> stateCheckResult = LoginUtil.checkAccountState(session, userPoJo.getNickname());
            if (stateCheckResult.get(LoginUtil.achieveSix)) {
                resultVo.setIsSuccess(HANDLE_FAILE);
                resultVo.setMessage("您的密码输错次数已超过6次,账号已被冻结,请联系管理员!");
                return resultVo;
            }
            if (!stateCheckResult.get(LoginUtil.freeze)) {
                resultVo.setIsSuccess(HANDLE_FAILE);
                resultVo.setMessage("您的密码输错次数已超过3次,账号被冻结30分钟!");
                return resultVo;
            }
            UserPoJo tmpUser = userService.loginByPwd(userPoJo);
            if (tmpUser == null || tmpUser.getTuid()==null) {
                if (accountState == null || accountState.length()==0) {     
                    //表示用户等一次登录失败
                    String countAndTimeStamp = "1-"+System.currentTimeMillis();
                    session.setAttribute(userPoJo.getNickname(), countAndTimeStamp);
                }else {
                    String[] tmpArray = accountState.split("-");
                    Integer count = Integer.valueOf(tmpArray[0]);   //失败
                    count++;
                    session.setAttribute(userPoJo.getNickname(), count+"-"+System.currentTimeMillis());
                    if (count == 6) {
                        userService.disableUser(userPoJo.getNickname());
                    }
                }
                resultVo.setIsSuccess(HANDLE_FAILE);
                resultVo.setMessage("账号或密码错误,请确认!");
                return resultVo;
            }
            logger.info("账号验证通过！");
            tmpUser.setPwd("");     //返回给页面的数据中不应该包含密码
            //取时间戳
            String timeStamp = TimeDateUtil.getCurrentTimeStamp();
            //令牌构成 = md5(userid+timedate)
            String tokenKey = Md5Util.getMD5(tmpUser.getTuid().toString()+timeStamp);
            String userPojoJson = JSONObject.toJSONString(tmpUser);
            //根据用户id、时间戳、UserPoJo的json构建value值
            String value = TokenUtil.structureTokenValue(tmpUser.getTuid().toString(), timeStamp,userPojoJson);
            
            //将token作为key，userid和时间戳构成的字符串作为value存入session
            session.setAttribute(tokenKey, value);
            logger.info("令牌保存成功");
            //获取该用户的菜单信息,根据用户id到
            
            resultVo.setIsSuccess(HANDLE_SUCCESS);
            resultVo.setMessage("欢迎"+tmpUser.getNickname());
            resultVo.setUrlStr("/jsp/backstage/index.jsp");
            resultVo.setResultObj(tokenKey);
            
            resultMap.addObject("user_token", tokenKey);
            resultMap.addObject("result", tmpUser);
        } catch (Exception e) {
            // TODO: handle exception
            resultVo.setIsSuccess(HANDLE_FAILE);
            resultVo.setMessage("登录处理异常！");
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return resultVo;
    }
	
    /**
     * 
     * @Description (TODO 重定向到首页)
     * @param request
     * @param token
     * @return
     */
    @RequestMapping(value="/toindex")
    public ModelAndView redirectToIndexPage(HttpServletRequest request, String token){
        HttpSession session = request.getSession();
        String valueStr = (String) session.getAttribute(token);
        logger.info("=====================================进入重定向到首页====================================");
        logger.info("取缓存值："+valueStr);
        ModelAndView modelAndView = new ModelAndView();
        if (valueStr == null || valueStr.length() == 0) {
            modelAndView.setViewName("/jsp/backstage/login");
            return modelAndView;
        }
        String tokenVal[] = TokenUtil.analiseTokenValue(valueStr);
        String userJson = tokenVal[2];
        if (userJson == null || userJson.length() == 0) {
            modelAndView.setViewName("/jsp/backstage/login");
            return modelAndView;
        }
        String userIdStr = tokenVal[0];
        if (userIdStr == null || userIdStr.length() == 0) {
            modelAndView.setViewName("/jsp/backstage/login");
            return modelAndView;
        }
        int userId = new Integer(userIdStr);    //登录用户id
        if (userId <= 0) {
            modelAndView.setViewName("/jsp/backstage/login");
            return modelAndView;
        }
        //根据用户id获取用户的菜单信息
        List<PowerMenuPoJo> menus = new ArrayList<>();
        if ("1".equals(userIdStr)) {
            menus = userService.getAdminMenu();
        }else{
            menus = userService.getMenuByUserId(userId);
        }
        if (menus == null || menus.size() == 0) {
            modelAndView.setViewName("/jsp/backstage/login");
            return modelAndView;
        }
        //构建菜单数据结构
        List<PowerMenuVo> menuVos = new LinkedList<>();     
        for(PowerMenuPoJo menu : menus){        
            if (menu.getParentid() == 0) {                                      //只取顶级菜单 
                Integer tmpParentId = menu.getParentid();       
                Integer tmpMenuId = menu.getTpmid();
                PowerMenuVo tmPowerMenuVo = new PowerMenuVo();                  //构建单个菜单项
                tmPowerMenuVo.setMenuId(tmpParentId);                           //注入父菜单id
                tmPowerMenuVo.setMenuName(menu.getName());                      //注入父菜单名称
                List<PowerMenuPoJo> tmpChildrenMenu = new LinkedList<>();       //构建该父菜单的子菜单列表
                //过滤出该父菜单包含的子菜单
                for(PowerMenuPoJo childMenu : menus){
                    Integer tmpChildParentId = childMenu.getParentid();
                    //判断该菜单不是顶级菜单，并且该菜单的父菜单是当前菜单
                    if (tmpChildParentId!=0 && tmpChildParentId==tmpMenuId) {
                        tmpChildrenMenu.add(childMenu);                         //向子菜单列表中添加子菜单
                    }
                }
                tmPowerMenuVo.setChildrenMenus(tmpChildrenMenu);                //将填充好的子菜单列表添加到父菜单中
                menuVos.add(tmPowerMenuVo);                                     //将构建好的父菜单填充到父菜单列表中
            }
        }
        
        modelAndView.setViewName("/jsp/backstage/index");
        UserPoJo userPoJo = JSONObject.parseObject(userJson, UserPoJo.class);
        modelAndView.addObject("userInfo", userPoJo);   //登录用户信息
        modelAndView.addObject("menus", menuVos);       //用户对应的菜单
        return modelAndView;
    }
}
