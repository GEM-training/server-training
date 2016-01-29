package com.gem.nhom1.controller;

import com.gem.nhom1.exception.exception.ValidationException;
import com.gem.nhom1.model.dto.ResponseDTO;
import com.gem.nhom1.model.entities.Dealer;
import com.gem.nhom1.model.entities.Unit;
import com.gem.nhom1.model.entities.UnitDealer;
import com.gem.nhom1.model.entities.UnitDealerId;
import com.gem.nhom1.service.DealerService;
import com.gem.nhom1.service.UnitDealerService;
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
@RequestMapping("/unit_dealer")
public class UnitDealerController {

    @Autowired
    private UnitDealerService unitDealerService;
    @Autowired
    private DealerService dealerService;
    @Autowired
    private UnitService unitService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public @ResponseBody
    ResponseDTO insert(@RequestBody @Valid UnitDealer unitDealer, BindingResult bindingResult) throws SQLException,ValidationException,DataAccessException {

        if (bindingResult.hasErrors())
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        unitDealerService.insert(unitDealer);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",null);
    }

    @RequestMapping("/unit-{unit_id}/dealer-{dealer_id}")
    public @ResponseBody ResponseDTO query(@PathVariable("unit_id") Integer unitId, @PathVariable("dealer_id") Integer dealerId){

        Unit unit = unitService.getById(unitId);
        Dealer dealer = dealerService.getById(dealerId);

        UnitDealer unitDealer = unitDealerService.getById(new UnitDealerId(unitId,dealerId));

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",unitDealer);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody ResponseDTO update(@RequestBody @Valid UnitDealer unitDealer,BindingResult bindingResult) throws SQLException,ValidationException,DataAccessException {

        if (bindingResult.hasErrors())
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());

        unitDealerService.update(unitDealer);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",null);
    }

    @RequestMapping(value = "/delete/unit-{unit_id}/dealer-{dealer_id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseDTO delete(@PathVariable("unit_id") Integer unitId, @PathVariable("dealer_id") Integer dealerId){

        try {
            unitDealerService.delete(new UnitDealerId(unitId,dealerId));
        } catch (Exception e) {
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR,e.getMessage(),null);
        }
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",null);
    }

}
