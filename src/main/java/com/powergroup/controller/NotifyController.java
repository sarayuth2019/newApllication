package com.powergroup.controller;

import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.service.NotifyRepository;
import com.powergroup.model.table.Customer;
import com.powergroup.model.table.Notify;
import com.powergroup.model.table.UserEntity;
import com.powergroup.util.ContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Notify")
public class NotifyController {
    @Autowired
    private NotifyRepository notifyRepository;
    @Autowired
    private ContextUtil contextUtil;

    @PostMapping("/save")
    public Object save(Notify notify) {
        APIResponse res = new APIResponse();
        notifyRepository.save(notify);
        res.setData(notify);
        res.setMessage("save success...");
        res.setStatus(1);
        return res;
    }

    @PostMapping("/list/user")
    public Object list(@PathVariable int user) {
        APIResponse res = new APIResponse();
        //Optional<UserEntity> dataUser = contextUtil.getUserDataFromContext();
        List<Notify> getList = notifyRepository.findByUserId(user);
        res.setData(getList);
        res.setMessage("List User...");
        return res;
    }

    @PostMapping("/delete/user")
    public Object delete(int user) {
        APIResponse res = new APIResponse();
        notifyRepository.deleteByUserId(user);
        res.setStatus(1);
        res.setData(user);
        res.setMessage("delete user success....");
        return res;
    }

    @PostMapping("/list/customer")
    public Object listCustomer(int customer) {
        APIResponse response = new APIResponse();
       // Optional<Customer> dataCustomer = contextUtil.getCustomerDataFromContext();
        List<Notify> list = notifyRepository.findByCustomerId(customer);
        response.setData(list);
        response.setMessage("List customer...");
        response.setStatus(1);
        return response;
    }

    @PostMapping("/delete/customer")
    private Object deleteCustomer(int customer) {
        APIResponse response = new APIResponse();
        notifyRepository.deleteByCustomerId(customer);
        response.setData(customer);
        response.setStatus(1);
        response.setMessage("delete customer success...");
        return response;
    }

    @GetMapping("/list")
    public Object check() {
        APIResponse res = new APIResponse();
        List<Notify> getList = notifyRepository.findAll();
        res.setData(getList);
        return res;
    }
}
