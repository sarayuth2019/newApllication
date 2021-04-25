package com.example.Aplication.controller;

import com.example.Aplication.model.bean.APIResponse;
import com.example.Aplication.model.service.BackupNotifyRepository;
import com.example.Aplication.model.table.BackupNotify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Backup")
public class BackupNotifyController {
    @Autowired
    private BackupNotifyRepository backupRepository;

    @PostMapping("/save")
    public Object save(BackupNotify backupNotify){
        APIResponse res = new APIResponse();
        backupRepository.save(backupNotify);
        res.setData(backupNotify);
        res.setMessage("save success...");
        res.setStatus(1);
        return res;
    }
    @GetMapping("/list")
    public Object list(){
        APIResponse res = new APIResponse();
        List<BackupNotify> getList = backupRepository.findAll();
        res.setData(getList);
        res.setMessage("List All...");
        return res;
    }

    @PostMapping("/list/notify")
    public Object Notify(int user,int customer){
        APIResponse res = new APIResponse();
        List<BackupNotify> getList = backupRepository.findByUserAndCustomer(user,customer);
        res.setStatus(1);
        res.setData(getList);
        res.setMessage("List Notify...");
        return res;
    }
    @PostMapping("/list/user")
    public Object listUser(int user){
        APIResponse res = new APIResponse();
        List<BackupNotify> getList = backupRepository.findByUser(user);
        res.setStatus(1);
        res.setData(getList);
        res.setMessage("List User...");
        return res;
    }
    @PostMapping("/list/customer")
    public Object listCustomer(int customer){
        APIResponse res = new APIResponse();
        List<BackupNotify> getList = backupRepository.findByCustomer(customer);
        res.setStatus(1);
        res.setData(getList);
        res.setMessage("List Customer...");
        return res;
    }
}
