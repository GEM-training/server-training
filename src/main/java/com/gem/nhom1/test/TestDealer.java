package com.gem.nhom1.test;

import com.gem.nhom1.model.Dealer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by phuongtd on 22/01/2016.
 */
public class TestDealer {

    private SessionFactory factory;
    private Session session;
    private Transaction tx;

    @Before
    public void setUp() {
        factory = new Configuration().configure().buildSessionFactory();
    }

   // @Test
    public void insert() {
        session = factory.openSession();

        tx = session.beginTransaction();


        Dealer dealer = new Dealer("Test db", "Test dealer");

        int id = (Integer) session.save(dealer);
        tx.commit();

        Dealer kq = (Dealer) session.get(Dealer.class, id);

        Assert.assertEquals("Test db", kq.getName());


    }

    @Test
    public void update() {
        session = factory.openSession();

        tx = session.beginTransaction();

        Dealer dealer = (Dealer) session.get(Dealer.class, 9);

        dealer.setName("New Name");

        session.save(dealer);

        tx.commit();

        Dealer dealer_ = (Dealer) session.get(Dealer.class, 9);

        Assert.assertEquals("New Name", dealer_.getName());


    }


}