package com.gem.nhom1.controller;

import com.gem.nhom1.model.dto.ResponseDTO;
import com.gem.nhom1.service.UserService;
import com.gem.nhom1.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by phuongtd on 16/02/2016.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/{id}")
    public ResponseDTO getdetail(@PathVariable( value = "id") int id){
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , userService.userDetail(id));
    }

    @RequestMapping("/login/{username}/{password}")
    public ResponseDTO login(@PathVariable( value = "username") String usename , @PathVariable(value = "password") String password){
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , userService.login(usename , password));
    }

}
