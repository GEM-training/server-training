package com.gem.nhom1.service.impl;

import com.gem.nhom1.dao.UserDao;
import com.gem.nhom1.model.entities.User;
import com.gem.nhom1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by phuongtd on 16/02/2016.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    public User userDetail(int id) {
        return userDao.userDetail(id);
    }

    public User login(String username, String passord) {
        return userDao.login(username ,passord);
    }
}
