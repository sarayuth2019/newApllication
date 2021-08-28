package com.powergroup.controller;

import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.service.AdminRepository;
import com.powergroup.model.table.AdminNotify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/delete/{id}")
    public Object deleteId(@PathVariable int id){
        APIResponse response = new APIResponse();
        Optional<AdminNotify> data = adminRepository.findById(id);
        adminRepository.deleteById(id);
        response.setData(data);
        response.setStatus(1);
        response.setMessage("delete success...");
        return response;
    }
}
