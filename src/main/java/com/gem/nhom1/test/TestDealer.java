package com.gem.nhom1.test;

import com.gem.nhom1.model.entities.*;
import com.gem.nhom1.service.DealerService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by phuongtd on 22/01/2016.
 */
@ComponentScan("con.grm.nhom1")
public class TestDealer {

    private SessionFactory factory;
    private Session session;
    private Transaction tx;

    private int IdTestUpdate = 15;

    private int IdTestDeleteExit = 10;

    private int IdTestDeleteNotExit = 100;

    private int IdTestDetail = 1;

    @Autowired
    private DealerService dealerService;

    @Before
    public void setUp() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void insert() {
       // session = factory.openSession();

      //  tx = session.beginTransaction();


        Dealer dealer = new Dealer("Insert Normal", "Insert Normal");

       // int id = (Integer) session.save(dealer);
       // tx.commit();

        int id = dealerService.insert(dealer);

        Dealer kq = (Dealer) session.get(Dealer.class, id);

        Assert.assertEquals("Insert Normal", kq.getName());

    }

    @Test
    public void insertNull() {
        session = factory.openSession();

        tx = session.beginTransaction();


        Dealer dealer = new Dealer("Test db", null);

        int id = (Integer) session.save(dealer);
        tx.commit();

        Dealer kq = (Dealer) session.get(Dealer.class, id);

        Assert.assertEquals("Test db", kq.getName());


    }

    @Test
    public void insertTooLong() {
        session = factory.openSession();

        tx = session.beginTransaction();


        Dealer dealer = new Dealer("Test dbTest dbTest dbTest dbTest dbTest dbTest dbTest dbTest dbTest dbTest dbTest dbTest dbTest dbTest dbTest dbTest dbTest dbTest dbTest dbTest dbTest dbTest dbTest dbTest dbTest dbTest dbTest dbTest dbTest dbTest dbTest db", "Address");

        int id = (Integer) session.save(dealer);
        tx.commit();

        Dealer kq = (Dealer) session.get(Dealer.class, id);

        Assert.assertEquals("Address", kq.getAddress());


    }

    @Test
    public void update() {
        session = factory.openSession();

        tx = session.beginTransaction();

        Dealer dealer = (Dealer) session.get(Dealer.class, IdTestUpdate);

        dealer.setName("New Name");

        session.save(dealer);

        tx.commit();

        Dealer dealer_ = (Dealer) session.get(Dealer.class, IdTestUpdate);

        Assert.assertEquals("New Name", dealer_.getName());

    }

    @Test
    public void updateNull() {
        session = factory.openSession();

        tx = session.beginTransaction();

        Dealer dealer = (Dealer) session.get(Dealer.class, IdTestUpdate);

        dealer.setName(null);

        session.save(dealer);

        tx.commit();

        Dealer dealer_ = (Dealer) session.get(Dealer.class, IdTestUpdate);

        Assert.assertEquals("New Name", dealer_.getName());

    }

    @Test
    public void updateTooLong() {
        session = factory.openSession();

        tx = session.beginTransaction();

        Dealer dealer = (Dealer) session.get(Dealer.class, IdTestUpdate);

        dealer.setName("too Long too Longtoo Longtoo Longtoo Longtoo Longtoo Longtoo Longtoo Longtoo Longtoo Longtoo Longtoo Longtoo Longtoo Longtoo Longtoo Longtoo Longtoo Longtoo Longtoo Longtoo Longtoo Longtoo Longtoo Longtoo Longtoo Long");

        session.save(dealer);

        tx.commit();

        Dealer dealer_ = (Dealer) session.get(Dealer.class, IdTestUpdate);

        Assert.assertEquals("New Name", dealer_.getName());


    }

    @Test
    public void deleteNotExit() {
        session = factory.openSession();

        tx = session.beginTransaction();

        Dealer dealer = (Dealer) session.get(Dealer.class, IdTestDeleteNotExit);


        session.delete(dealer);

        tx.commit();
    }

    @Test
    public void getList(){
        session = factory.openSession();
        tx = session.beginTransaction();

        List<Dealer> dealers = session.createQuery("from Dealer").list();

        Assert.assertEquals(10  , dealers.size());
        tx.commit();

    }

    @Test
    public void getUnits(){
        session = factory.openSession();
        tx = session.beginTransaction();

        Dealer dealer = (Dealer) session.get(Dealer.class , IdTestDetail);

        List<UnitDealer> listUnit = new ArrayList<UnitDealer>(dealer.getUnitDealers());


        Assert.assertEquals(2 , listUnit.size());

        tx.commit();

    }

    @Test
    public void getInventories(){
        session = factory.openSession();
        tx = session.beginTransaction();

        Dealer dealer = (Dealer) session.get(Dealer.class , IdTestDetail);

        List<Inventory> inventories = new ArrayList<Inventory>(dealer.getInventorys());

        Assert.assertEquals(1 , inventories.size());

        tx.commit();

    }

    @Test
    public void getStaffs(){
        session = factory.openSession();
        tx = session.beginTransaction();

        Dealer dealer = (Dealer) session.get(Dealer.class , IdTestDetail);

        List<Staff> staffs = new ArrayList<Staff>(dealer.getStaffs());

        Assert.assertEquals(1 , staffs.size());

        tx.commit();

    }

    @Test
    public void getBills(){
        session = factory.openSession();
        tx = session.beginTransaction();

        Dealer dealer = (Dealer) session.get(Dealer.class , IdTestDetail);

        List<Bill> bills = new ArrayList<Bill>(dealer.getBills());

        Assert.assertEquals(2  , bills.size());

        tx.commit();
    }


}