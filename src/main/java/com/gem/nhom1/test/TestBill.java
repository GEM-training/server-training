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

/**
 * Created by phuong on 1/24/2016.
 */
@org.springframework.context.annotation.Configuration()
@ComponentScan("com.gem.nhom1")
public class TestBill {
    private SessionFactory factory;
    private Session session;
    private Transaction tx;

    private int idBillDetail = 2;

    @Autowired
    private DealerService dealerService;

    @Before
    public void setUp() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    //@Test
    public void insertBill(){
        session = factory.openSession();
        tx = session.beginTransaction();

        Bill bill = new Bill();

        Dealer dealer = (Dealer) session.get(Dealer.class , 1);
        Customer customer  = (Customer) session.get(Customer.class , 1);
        Staff staff = (Staff) session.get(Staff.class , 1);

        bill.setDealer(dealer);
        bill.setState("Demo State");
        bill.setCustomer(customer);

        session.persist(bill);


        tx.commit();
    }

    @Test
    public void insertBillNoDealer(){
        session = factory.openSession();
        tx = session.beginTransaction();

        Bill bill = new Bill();

        //Dealer dealer = (Dealer) session.get(Dealer.class , 1);
        Customer customer  = (Customer) session.get(Customer.class , 1);
        Staff staff = (Staff) session.get(Staff.class , 1);

       // bill.setDealer(dealer);
        bill.setState("Demo State");
        bill.setCustomer(customer);

        session.persist(bill);


        tx.commit();
    }

    @Test
    public void insertBillNoCustomer(){
        session = factory.openSession();
        tx = session.beginTransaction();

        Bill bill = new Bill();

        Dealer dealer = (Dealer) session.get(Dealer.class , 1);
        //Customer customer  = (Customer) session.get(Customer.class , 1);
        Staff staff = (Staff) session.get(Staff.class , 1);

        bill.setDealer(dealer);
        bill.setState("Demo State");
        //bill.setCustomer(customer);

        session.persist(bill);


        tx.commit();
    }

    @Test
    public void insertBillNoStaff(){
        session = factory.openSession();
        tx = session.beginTransaction();

        Bill bill = new Bill();

        Dealer dealer = (Dealer) session.get(Dealer.class , 1);
        Customer customer  = (Customer) session.get(Customer.class , 1);
      //  Staff staff = (Staff) session.get(Staff.class , 1);

        bill.setDealer(dealer);
        bill.setState("Demo State");
        bill.setCustomer(customer);
       // bill.setStaff(staff);

        session.persist(bill);


        tx.commit();
    }

    @Test
    public void insertBillNoState(){
        session = factory.openSession();
        tx = session.beginTransaction();

        Bill bill = new Bill();

        Dealer dealer = (Dealer) session.get(Dealer.class , 1);
        Customer customer  = (Customer) session.get(Customer.class , 1);
        Staff staff = (Staff) session.get(Staff.class , 1);

        bill.setDealer(dealer);
      //  bill.setState("Demo State");
        bill.setCustomer(customer);

        session.persist(bill);


        tx.commit();
    }

    @Test
    public void getBillDetail(){
        session = factory.openSession();
        tx = session.beginTransaction();
        Bill bill = (Bill) session.get(Bill.class , idBillDetail);

        Dealer dealer = bill.getDealer();
        Customer customer = bill.getCustomer();

        Assert.assertEquals(bill.getState() , "Van hop 3");
        Assert.assertEquals(bill.getDealer().getName() , "Duy Phuong");
        Assert.assertEquals(bill.getCustomer().getName() , "hop");

        List<BillDetail> billDetails = new ArrayList<BillDetail>(bill.getBillDetail());
        double total = 0;
        for(int i =0 ; i < billDetails.size() ; i++ ){
            BillDetail billDetail = billDetails.get(i);

            Unit unit = billDetail.getUnit();
            UnitDealerId unitDealerId = new UnitDealerId(unit.getUnitId() , dealer.getDealerId());

            UnitDealer unitDealer = (UnitDealer) session.get(UnitDealer.class , unitDealerId);
            total += unitDealer.getPrice()*billDetail.getQuantity();
        }

        Assert.assertEquals(total , 7500 , 0.5);
        tx.commit();
    }


}
