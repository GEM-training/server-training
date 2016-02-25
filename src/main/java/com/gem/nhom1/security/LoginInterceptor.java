package com.gem.nhom1.security;

/**
 * Created by vanhop on 2/17/16.
 */

import com.gem.nhom1.service.UserService;
import com.gem.nhom1.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    private TokenManager tokenManager = TokenManager.getInstaince();

    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub

    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
            throws Exception {

    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {

        String access_token = request.getHeader("access_token");
        String deviceId = request.getHeader("deviceId");
        if (access_token != null)
            return true;
        if (request.getRequestURI().startsWith("/login") || (access_token != null && request.getRequestURI().startsWith("/logout"))) {
            return true;
        }
        if (access_token != null) {
            TokenInfo tokenInfo = tokenManager.get(access_token);
            if (tokenInfo == null) {
                response.setStatus(HttpStatus.FORBIDDEN.value());
                return false;
            }
            /*else if (TokenUtil.isExpiration(tokenManager.get(access_token))) {
                response.setHeader("access_token", tokenManager.updateToken(tokenInfo));
            }*/
            return true;
        }
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return false;
    }

}
