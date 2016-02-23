package com.gem.nhom1.controller;

import com.gem.nhom1.security.TokenInfo;
import com.gem.nhom1.security.TokenManager;
import com.gem.nhom1.util.TokenUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by vanhop on 2/17/16.
 */
@Controller
public class TokenController {

    TokenManager tokenManager = TokenManager.getInstaince();

    @RequestMapping("/refresh_access_token")
    public void refreshAccessToken(HttpServletRequest request, HttpServletResponse response){

        String access_token = request.getHeader("access_token");
        TokenInfo tokenInfo = tokenManager.get(access_token);
        response.setHeader("access_token", TokenUtil.generateAccessToken(tokenInfo.getUser(),tokenInfo.getDeviceId()));

    }


}
