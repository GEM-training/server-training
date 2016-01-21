package com.gem.nhom1.controller;

<<<<<<< HEAD
import com.gem.nhom1.model.Dealer;
import com.gem.nhom1.model.Promotion;
import com.gem.nhom1.model.Unit;
import com.gem.nhom1.service.DealerService;
import com.gem.nhom1.service.PromotionService;
=======
import com.gem.nhom1.dao.BillDetailDao;
import com.gem.nhom1.dao.DealerDao;
import com.gem.nhom1.model.*;
import com.gem.nhom1.service.*;
>>>>>>> e6af37389a8b16ff5c42ceac2631748ce1525c82
import net.arnx.jsonic.JSON;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;
=======
import org.springframework.transaction.annotation.Transactional;
>>>>>>> e6af37389a8b16ff5c42ceac2631748ce1525c82
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by phuong on 1/19/2016.
 */
@Controller
@RequestMapping("/home")
@Transactional
public class HomeController {
    @Autowired
    private DealerService dealerService;

    @Autowired
    private BillService billService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PromotionService promotionService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private UnitService unitService;

    @Autowired
    private BillDetailService billDetailService;

    @RequestMapping("/demo")
<<<<<<< HEAD
    public @ResponseBody  String  home(ModelMap mm){
       // dealerService.save(new Dealer("Yamaha VietNam" , "Ha Noi"));
        List<Dealer> list =  dealerService.getListDealer();
        mm.addAttribute("dealers"  ,  list);
=======
    public @ResponseBody String  home(ModelMap mm){

        /*Dealer dealer = dealerService.getDealerById(1);
        Customer customer = customerService.getCustomerById(1);
        Staff staff = staffService.getStaffById(1);

        Bill bill = new Bill();
        bill.setDealer(dealer);
        bill.setStaff(staff);
        bill.setCustomer(customer);
        bill.setState("Waiting...");

        billService.save(bill);

        Unit unit1 = unitService.getUnitById(1);
        Unit unit3 = unitService.getUnitById(3);

        BillDetail billDetail = new BillDetail();
        billDetail.setUnit(unit1);
        billDetail.setBill(bill);
        billDetail.setQuantity(3);

        BillDetail billDetail1 = new BillDetail();
        billDetail1.setUnit(unit3);
        billDetail1.setBill(bill);
        billDetail1.setQuantity(1);

        billDetailService.save(billDetail);
        billDetailService.save(billDetail1);*/

>>>>>>> e6af37389a8b16ff5c42ceac2631748ce1525c82


<<<<<<< HEAD

        mm.addAttribute("bills"  ,  d.getBills());

        mm.addAttribute("uds"  ,  d.getUnitDealers());

        return JSON.encode(d.getBills().iterator());
=======
        //BillDetail billDetail = billDetailService.getBillDetailById(1);
        Bill bill = billService.getBillById(1);


        return JSON.encode(bill.getBillDetail().iterator().next());
>>>>>>> e6af37389a8b16ff5c42ceac2631748ce1525c82
    }


}
