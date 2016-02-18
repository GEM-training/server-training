package com.gem.nhom1.security;

/**
 * Created by vanhop on 2/17/16.
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gem.nhom1.util.TokenUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

public class LoginInterceptor implements HandlerInterceptor{

    private HashMap<String,TokenInfo> tokenManager = new HashMap<String, TokenInfo>();

    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub

    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
            throws Exception {
        //\

    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {

        String access_token = request.getHeader("access_token");
        if(access_token != null){
            TokenInfo tokenInfo = tokenManager.get(access_token);
            if(tokenInfo == null){
                response.setStatus(HttpStatus.FORBIDDEN.value());
                return false;
            } else if(TokenUtil.isExpiration(tokenManager.get(access_token))){
                tokenManager.remove(access_token);
                String new_acc = TokenUtil.generateAccessToken(tokenInfo.getUser());
                tokenManager.put(new_acc,tokenInfo);
                response.setHeader("access_token",new_acc);
                return true;
            }
        } else {
            String username = request.getHeader("username");
            String password = request.getHeader("password");

            //String sha1 = TokenUtil.generateAccessToken();

            return true;
        }
    return true;
    }

}
