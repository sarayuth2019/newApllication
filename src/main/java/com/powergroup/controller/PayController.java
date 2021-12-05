package com.powergroup.controller;

import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.bean.ImagesReponse;
import com.powergroup.model.service.PayRepository;
import com.powergroup.model.table.PayEntity;
import com.powergroup.util.ContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Pay")
public class PayController {
    @Autowired
    private PayRepository payRepository;
    @Autowired
    private ContextUtil contextUtil;
    @PostMapping("/save")
    public Object save(PayEntity payEntity){
        APIResponse apiResponse = new APIResponse();
        PayEntity data = payRepository.save(payEntity);
        apiResponse.setMessage("save success...");
        apiResponse.setData(data);
        apiResponse.setStatus(1);
        return apiResponse;
    }
    @PostMapping("/listId")
    public Object listId(int id) {
        APIResponse response = new APIResponse();
        Optional<PayEntity> data = payRepository.findById(id);
        response.setStatus(1);
        response.setData(data);
        response.setMessage("list payId success... ");
        return response;
    }
    @GetMapping("/list")
    public Object list(){
        APIResponse response = new APIResponse();
        List<PayEntity> data= payRepository.findAll();
        response.setStatus(1);
        response.setData(data);
        response.setMessage("listAll Pay success...");
        return response;
    }
    @PostMapping("/listByStatus")
    public Object listStatus(String status){
        ImagesReponse imagesReponse = new ImagesReponse();
        List<PayEntity> data = payRepository.findByStatus(status);
        imagesReponse.setDataId(data);
        imagesReponse.setStatus(1);
        imagesReponse.setMessage("list by Status");
        return imagesReponse;
    }
    @PostMapping("/listByIdAndStatus")
    public Object listIdAndStatus(int userId,String status){
        APIResponse res = new APIResponse();
        List<PayEntity> data = payRepository.findByUserIdAndStatus(userId,status);
        res.setData(data);
        res.setStatus(1);
        res.setMessage("list by id and status");
        return res;
    }
    @PostMapping("/user")
    public Object listUser(int userId){
        APIResponse response = new APIResponse();
        List<PayEntity> data = payRepository.findByUserId(userId);
        response.setMessage("list Pay by UserId...");
        response.setData(data);
        response.setStatus(1);
        return response;
    }
    @PostMapping("/market")
    public Object listMarket(int marketId){
        APIResponse response = new APIResponse();
        List<PayEntity> data = payRepository.findByMarketId(marketId);
        response.setMessage("list Pay by MarketId...");
        response.setData(data);
        response.setStatus(1);
        return response;
    }
    @PostMapping("/item")
    public Object listItem(int itemId){
        APIResponse response = new APIResponse();
        List<PayEntity> data = payRepository.findByItemId(itemId);
        response.setMessage("list Pay by itemId...");
        response.setData(data);
        response.setStatus(1);
        return response;
    }

    @PostMapping("/listItemIdByUserId")
    public Object listUserId(int itemId){
        APIResponse rs = new APIResponse();
        List<PayEntity> data =payRepository.findByItemId(itemId);
        ArrayList UserId = new ArrayList();
        for (int i = 0; i < data.size(); i++) {
            int x = data.get(i).getUserId();
            UserId.add(x);
        }
        List<PayEntity> unique = (List<PayEntity>) UserId.stream()
                .sorted()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(unique);
        rs.setData(unique);
        rs.setStatus(1);
        rs.setMessage("list userId success...");
        return rs;
    }
}
