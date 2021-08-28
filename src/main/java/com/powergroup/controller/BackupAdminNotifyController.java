package com.powergroup.controller;

import com.powergroup.model.bean.APIResponse;

import com.powergroup.model.service.BackupAdminRepository;
import com.powergroup.model.table.BackupAdminNotify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("BackupAdmin")
public class BackupAdminNotifyController {
    @Autowired
    private BackupAdminRepository backupNotifyRepository;
    @PostMapping("/save")
    public Object save(BackupAdminNotify backupAdminNotify){
        APIResponse response = new APIResponse();
        backupNotifyRepository.save(backupAdminNotify);
        response.setStatus(1);
        response.setData(backupAdminNotify);
        response.setMessage("success...");
        return response;
    }
    @GetMapping("/list")
    public Object lst(){
        APIResponse response = new APIResponse();
        var data = backupNotifyRepository.findAll();
        response.setStatus(1);
        response.setData(data);
        response.setMessage("success");
        return response;
    }
}
