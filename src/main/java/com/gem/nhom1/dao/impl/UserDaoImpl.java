package com.gem.nhom1.dao.impl;

import com.gem.nhom1.dao.UserDao;
import com.gem.nhom1.model.entities.User;
import org.springframework.stereotype.Repository;

/**
 * Created by phuongtd on 16/02/2016.
 */
@Repository
public class UserDaoImpl extends AbstractDao<Integer , User> implements UserDao {
    public User userDetail(int id) {
        return getByKey(id);
    }
}
