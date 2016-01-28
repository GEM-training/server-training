package com.gem.nhom1.service.impl;

import com.gem.nhom1.dao.BillDetailDao;
import com.gem.nhom1.model.Bill;
import com.gem.nhom1.model.BillDetail;
import com.gem.nhom1.model.BillDetailId;
import com.gem.nhom1.model.ResponseDTO;
import com.gem.nhom1.service.BillDetailService;
import com.gem.nhom1.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

/**
 * Created by vanhop on 1/20/16.
 */
@Service
@Transactional
public class BillDetailServiceImpl implements BillDetailService {

    @Autowired
    private BillDetailDao billDetailDao;

    private Validator validator;

    public ResponseDTO getById(BillDetailId id) {
        try {
            return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , billDetailDao.getById(id));
        } catch (Exception e){
            return  new ResponseDTO(Constant.RESPONSE_STATUS_ERROR , e.getMessage() , null);
        }

    }

    public ResponseDTO getList(int page) {

        List<BillDetail> list = billDetailDao.getList(page);
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , list);

    }

    public ResponseDTO insert(BillDetail billDetail){

        Set<ConstraintViolation<BillDetail>> constraintViolations = validator.validate(billDetail);

        if (constraintViolations.size() > 0) {
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR , constraintViolations.iterator().next().getMessage() , null );
        }
        try {
            billDetailDao.insert(billDetail);
        } catch (Exception e){
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR , e.getMessage() , null );
        }

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , null);
    }

    public ResponseDTO delete(BillDetailId id){
        try {
            billDetailDao.delete(id);
        } catch (Exception e) {
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR , e.getMessage() , null);
        }

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , null);
    }

    public ResponseDTO update(BillDetail billDetail){
        Set<ConstraintViolation<BillDetail>> constraintViolations = validator.validate(billDetail);

        if(constraintViolations.size() > 0){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("message" , constraintViolations.iterator().next().getMessage());

            return  new ResponseDTO(Constant.RESPONSE_STATUS_ERROR ,constraintViolations.iterator().next().getMessage() , null );
        }
        try {
            billDetailDao.update(billDetail);
        } catch (Exception e){
            return  new ResponseDTO(Constant.RESPONSE_STATUS_ERROR ,e.getMessage() , null );
        }

        return  new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , null);
    }
}
