package com.gem.nhom1.service;

import com.gem.nhom1.model.entities.User;

/**
 * Created by phuongtd on 16/02/2016.
 */
public interface UserService {
        public User userDetail(int id);
        public User login(String username ,  String passord);
}
