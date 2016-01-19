package com.gem.nhom1.dao.impl;

import com.gem.nhom1.dao.UserDao;
import com.gem.nhom1.model.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by phuong on 1/19/2016.
 */
@Repository
public class UserDaoImpl extends AbstractDao<Integer , User> implements UserDao {
    public List<User> getListUser() {
        Session session = getSession();
        return session.createQuery("from User").list();
    }

    public void save(User user) {
        persist(user);
    }
}
