package com.gem.nhom1.controller;

import com.gem.nhom1.model.dto.ResponseDTO;
import com.gem.nhom1.model.entities.*;
import com.gem.nhom1.security.TokenInfo;
import com.gem.nhom1.security.TokenManager;
import com.gem.nhom1.service.UserService;
import com.gem.nhom1.util.Constant;
import com.gem.nhom1.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by vanhop on 2/17/16.
 */
@Controller
public class LoginLogoutController {

    @Autowired
    private UserService userService;
    private TokenManager tokenManager = TokenManager.getInstaince();

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody ResponseDTO login(@RequestBody UserInfo userInfo) {
        User user = userService.login(userInfo.getUsername(), userInfo.getPassword());
        if (user == null)
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR, "Username or Password is invalid", null);
        else {
            TokenInfo tokenInfo = new TokenInfo(TokenUtil.generateAccessToken(user,userInfo.getDeviceId()),userInfo.getDeviceId(), user);
            tokenManager.addToken(tokenInfo);
            return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",tokenInfo);
        }
    }

/*    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody ResponseDTO login(@RequestParam("username") String username, @RequestParam("password") String password) {
        UserInfo userInfo  = new UserInfo(username,password,"android");
        User user = userService.login(userInfo.getUsername(), userInfo.getPassword());
        if (user == null)
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR, "Username or Password is invalid", null);
        else {
            TokenInfo tokenInfo = new TokenInfo(TokenUtil.generateAccessToken(user,userInfo.getDeviceId()),userInfo.getDeviceId(), user);
            tokenManager.addToken(tokenInfo);
            return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",tokenInfo);
        }
    }*/

    @RequestMapping("/logout")
    public @ResponseBody ResponseDTO logout(HttpServletRequest request, HttpServletResponse response){
        String access_token = request.getHeader("access_token");
        if(access_token != null)
            tokenManager.deleteToken(access_token);
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"","");
    }

}
