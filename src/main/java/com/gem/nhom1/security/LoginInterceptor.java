package com.gem.nhom1.security;

/**
 * Created by vanhop on 2/17/16.
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub

    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
            throws Exception {
        //\

    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        /*if(request.getSession().getAttribute("rule") != null || request.getRequestURL().toString().endsWith("login"))
            return true;
        else {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }*/
        return true;
    }

}
