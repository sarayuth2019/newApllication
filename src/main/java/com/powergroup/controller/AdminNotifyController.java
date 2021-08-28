package com.powergroup.controller;

import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.service.AdminRepository;
import com.powergroup.model.table.AdminNotify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Admin")
public class AdminNotifyController {
    @Autowired
    private AdminRepository adminRepository;
    @PostMapping("/save")
    public Object save(AdminNotify adminNotify){
        APIResponse response = new APIResponse();
        adminRepository.save(adminNotify);
        response.setStatus(1);
        response.setData(adminNotify);
        response.setMessage("save success");
        return response;
    }
    @GetMapping("/list")
    public Object lst(){
        APIResponse response = new APIResponse();
        var data = adminRepository.findAll();
        response.setStatus(1);
        response.setData(data);
        response.setMessage("success");
        return response;
    }
}
