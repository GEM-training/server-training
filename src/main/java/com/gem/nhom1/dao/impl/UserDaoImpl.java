package com.gem.nhom1.dao.impl;

import com.gem.nhom1.dao.UserDao;
import com.gem.nhom1.model.entities.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by phuongtd on 16/02/2016.
 */
@Repository
public class UserDaoImpl extends AbstractDao<Integer , User> implements UserDao {
    public User userDetail(int id) {
        return getByKey(id);
    }

    public User login(String username, String password) {
        Session session  = getSession();

        Query query = session.createQuery("from User u  where u.username = :username and u.password = :password");
        query.setParameter("username" , username);
        query.setParameter("password" , password);

        List<User> list = query.list();

        if(list.size() > 0)

        return list.get(0);

        return null;
    }
}
