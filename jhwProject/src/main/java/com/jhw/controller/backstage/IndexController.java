package com.jhw.controller.backstage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jhw.controller.base.BaseController;
import com.jhw.pojo.UserPoJo;
import com.jhw.service.UserService;
import com.jhw.util.token.TokenUtil;
import com.jhw.vo.ResultVo;

@Controller
@RequestMapping("/bs_index")
public class IndexController extends BaseController{

    @Autowired
    private UserService userService;
    /** token有效时间3天*/
    private static final int TOKEN_VALID_TIME = 3;
    
    /**
     * 
     * @Description (TODO 刷新首页)
     * @param request
     * @param token
     * @return
     */
    @RequestMapping(value="/refresh", method=RequestMethod.POST)
    @ResponseBody
    public String toLoginPage(HttpServletRequest request, String token){
        HttpSession session = request.getSession();
        //验证token有效期
        if (token == null || token.length() == 0) {
            return "invalid";
        }
        String valueStr = (String) session.getAttribute(token);
        if (valueStr == null || valueStr.length() == 0) {
            return "invalid";
        }
        String tokenVal[] = TokenUtil.analiseTokenValue(valueStr);
        String timeStamp = tokenVal[1];
        try {
            long currentTime = System.currentTimeMillis();
            long oldTime = Long.valueOf(timeStamp); 
            int day = (int) ((currentTime - oldTime)/(1000*60*60*24*TOKEN_VALID_TIME));
            if (day > TOKEN_VALID_TIME) {
                session.removeAttribute(token);     //token失效,从session中删除
                return "invalid";
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            logger.info(e.getMessage());
        }
        return "valid";
    }
    
    /**
     * 
     * @Description (TODO 进入用户资料管理页面)
     * @param request
     * @param token
     * @return
     */
    @RequestMapping(value="/toUserInfoManagePage")
    @ResponseBody
    public ModelAndView toUserInfoManagePage(HttpServletRequest request, String token) {
        logger.info("加载用户资料页面");
        HttpSession session = request.getSession();
        ModelAndView modelAndView = new ModelAndView();
        ResultVo<List<UserPoJo>> resultVo = new ResultVo<>();
        // 还需加验证token令牌是否过期, 安全验证可以使用面向切面编程
        // 验证令牌有效期
        if (!TokenUtil.doValidateTokenInfo(session, token)) {
            resultVo.setIsSuccess(HANDLE_SUCCESS);
            resultVo.setIsOverdue(HANDLE_FAILED);
            resultVo.setMessage("登录失效,请重新登录！");
            modelAndView.setViewName("/jsp/backstage/login.jsp");
            modelAndView.addObject("result", resultVo);
            return modelAndView;
        }

        try {
            List<UserPoJo> userPoJos = userService.getAllValidUser(0, LIMIT);
            if (userPoJos == null || userPoJos.size() == 0) {
                resultVo.setIsSuccess(HANDLE_FAILED);
                resultVo.setMessage("未检索到任何用户资料");
            } else {
                if (userPoJos.size() == LIMIT) {
                    resultVo.setWhetherNextPage(HAS_NETX_PAGE); // 有下一页
                    userPoJos.remove(LIMIT - 1);
                } else {
                    resultVo.setWhetherNextPage(NO_NEXT_PAGE); // 没有下一页
                }
                resultVo.setIsSuccess(HANDLE_SUCCESS);
                resultVo.setMessage("success");
                resultVo.setResultObj(userPoJos);
                resultVo.setPageNo(0); // 设置当前页数为第0页,即从0开始计数
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
            resultVo.setIsSuccess(HANDLE_FAILED);
            resultVo.setMessage("加载用户资料异常");
        }
        modelAndView.setViewName("/jsp/backstage/user_list");
        modelAndView.addObject("results", resultVo);
        return modelAndView;
    }
    
    
}
