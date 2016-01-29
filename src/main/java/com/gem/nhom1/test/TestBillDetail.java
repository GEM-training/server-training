package com.gem.nhom1.test;

import com.gem.nhom1.model.entities.Bill;
import com.gem.nhom1.model.entities.BillDetail;
import com.gem.nhom1.model.entities.BillDetailId;
import com.gem.nhom1.model.entities.Unit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by phuong on 1/24/2016.
 */
public class TestBillDetail {
    private SessionFactory factory;
    private Session session;
    private Transaction tx;

    @Before
    public void setUp() {
        factory = new Configuration().configure().buildSessionFactory();
    }
   // @Test
    public void insert(){
        session = factory.openSession();
        tx = session.beginTransaction();

        Unit unit = (Unit) session.get(Unit.class , 1);
        Bill bill = (Bill) session.get(Bill.class , 1);

        BillDetailId billDetailId = new BillDetailId();
        billDetailId.setUnit(unit);
        billDetailId.setBill(bill);

        BillDetail billDetail = new BillDetail(billDetailId , 5);

        session.persist(billDetail);

        tx.commit();
    }

    @Test
    public void insertNotUnit(){
        session = factory.openSession();
        tx = session.beginTransaction();

        Unit unit = (Unit) session.get(Unit.class , 1);
        Bill bill = (Bill) session.get(Bill.class , 1);

        BillDetailId billDetailId = new BillDetailId();
       // billDetailId.setUnit(unit);
        billDetailId.setBill(bill);

        BillDetail billDetail = new BillDetail(billDetailId , 5);

        session.persist(billDetail);

        tx.commit();
    }

    @Test
    public void insertNotBill(){
        session = factory.openSession();
        tx = session.beginTransaction();

        Unit unit = (Unit) session.get(Unit.class , 1);
        Bill bill = (Bill) session.get(Bill.class , 1);

        BillDetailId billDetailId = new BillDetailId();
        billDetailId.setUnit(unit);
        //billDetailId.setBill(bill);

        BillDetail billDetail = new BillDetail(billDetailId , 5);

        session.persist(billDetail);

        tx.commit();
    }

    @Test
    public void insertNotQuantity(){
        session = factory.openSession();
        tx = session.beginTransaction();

        Unit unit = (Unit) session.get(Unit.class , 1);
        Bill bill = (Bill) session.get(Bill.class , 1);

        BillDetailId billDetailId = new BillDetailId();
        billDetailId.setUnit(unit);
        billDetailId.setBill(bill);

        BillDetail billDetail = new BillDetail();
        billDetail.setPk(billDetailId);

        session.persist(billDetail);

        tx.commit();
    }

}
