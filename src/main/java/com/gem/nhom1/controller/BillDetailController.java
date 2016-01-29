package com.gem.nhom1.controller;

import com.gem.nhom1.exception.exception.ValidationException;
import com.gem.nhom1.model.dto.ResponseDTO;
import com.gem.nhom1.model.entities.Bill;
import com.gem.nhom1.model.entities.BillDetail;
import com.gem.nhom1.model.entities.BillDetailId;
import com.gem.nhom1.model.entities.Unit;
import com.gem.nhom1.service.BillDetailService;
import com.gem.nhom1.service.BillService;
import com.gem.nhom1.service.UnitService;
import com.gem.nhom1.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;

/**
 * Created by phuongtd on 21/01/2016.
 */
@Controller
@RequestMapping("/bill_detail")
public class BillDetailController {

    @Autowired
    private UnitService unitService;
    @Autowired
    private BillService billService;
    @Autowired
    private BillDetailService billDetailService;
    @RequestMapping(value = "/insert" , method = RequestMethod.POST)

    public @ResponseBody
    ResponseDTO insert(@RequestBody @Valid BillDetail billDetail, BindingResult bindingResult) throws SQLException,ValidationException,DataAccessException {

        if (bindingResult.hasErrors())
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        billDetailService.insert(billDetail);

        return  new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , null);

    }

   /* @RequestMapping(value = "/list")
    public @ResponseBody ResponseDTO list(@RequestParam (value = "page",defaultValue = "1") int page){
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , billDetailService.getList(page)) ;
    }*/

    @RequestMapping(value = "/update" ,method = RequestMethod.PUT)
    public @ResponseBody ResponseDTO update(@RequestBody @Valid BillDetail billDetail, BindingResult bindingResult) throws SQLException,ValidationException,DataAccessException {

        if (bindingResult.hasErrors())
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        billDetailService.update(billDetail);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS, "", null);
    }

    @RequestMapping("delete/{unitId}/{billId}")
    public @ResponseBody ResponseDTO delete(@PathVariable("unitId") int unitId, @PathVariable("billId") int billId) {

        Unit unit = unitService.getById(unitId);
        Bill bill = billService.getById(billId);
        BillDetailId billDetailId = new BillDetailId(bill, unit);

        try {
            billDetailService.delete(billDetailId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",null);
    }


}
