package com.gem.nhom1.controller;

import com.gem.nhom1.model.dto.ResponseDTO;
import com.gem.nhom1.model.entities.User;
import com.gem.nhom1.security.TokenInfo;
import com.gem.nhom1.security.TokenManager;
import com.gem.nhom1.service.UserService;
import com.gem.nhom1.util.Constant;
import com.gem.nhom1.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by vanhop on 2/17/16.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    private TokenManager tokenManager = TokenManager.getInstaince();

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody ResponseDTO login(@RequestParam("username") String username, @RequestParam("password") String password) {

        User user = userService.login(username, password);
        if (user == null)
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR, "Username or Password is invalid", null);
        else {
            TokenInfo tokenInfo = new TokenInfo(TokenUtil.generateAccessToken(user), user);
            tokenManager.addToken(tokenInfo);
            return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",tokenInfo);
        }

    }

}
