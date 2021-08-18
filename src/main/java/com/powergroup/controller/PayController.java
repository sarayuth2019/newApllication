package com.powergroup.controller;

import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.service.PayRepository;
import com.powergroup.model.table.PayEntity;
import com.powergroup.util.ContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/Pay")
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
    @GetMapping("/list")
    public Object list(){
        APIResponse response = new APIResponse();
        List<PayEntity> data= payRepository.findAll();
        response.setStatus(1);
        response.setData(data);
        response.setMessage("listAll Pay success...");
        return response;
    }
    @GetMapping("/user/{userId}")
    public Object listUser(@PathVariable int userId){
        APIResponse response = new APIResponse();
        List<PayEntity> data = payRepository.findByUserId(userId);
        response.setMessage("list Pay by UserId...");
        response.setData(data);
        response.setStatus(1);
        return response;
    }
    @GetMapping("/market/{marketId}")
    public Object listMarket(@PathVariable int marketId){
        APIResponse response = new APIResponse();
        List<PayEntity> data = payRepository.findByMarketId(marketId);
        response.setMessage("list Pay by MarketId...");
        response.setData(data);
        response.setStatus(1);
        return response;
    }
    @GetMapping("/item/{itemId}")
    public Object listItem(@PathVariable int itemId){
        APIResponse response = new APIResponse();
        List<PayEntity> data = payRepository.findByItemId(itemId);
        response.setMessage("list Pay by itemId...");
        response.setData(data);
        response.setStatus(1);
        return response;
    }
}
