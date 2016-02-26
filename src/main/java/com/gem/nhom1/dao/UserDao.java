package com.gem.nhom1.dao;

import com.gem.nhom1.model.entities.User;

/**
 * Created by phuongtd on 16/02/2016.
 */
interface UserDao {
    User userDetail(int id);
    User login(String username , String password);
}
