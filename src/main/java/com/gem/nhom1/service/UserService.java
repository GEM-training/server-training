package com.gem.nhom1.service;

import com.gem.nhom1.model.entities.User;

/**
 * Created by phuongtd on 16/02/2016.
 */
public interface UserService {
        User userDetail(int id);
        User login(String username ,  String passord);
}
