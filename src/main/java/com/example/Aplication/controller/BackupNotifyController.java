package com.example.Aplication.controller;

import com.example.Aplication.model.bean.APIResponse;
import com.example.Aplication.model.service.BackupNotifyRepository;
import com.example.Aplication.model.table.BackupNotify;
import com.example.Aplication.model.table.Cart;
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
    @GetMapping("/delete")
    public Object delete(BackupNotify backupNotify){
        APIResponse res = new APIResponse();
        backupRepository.deleteAll();
        res.setStatus(1);
        res.setData(backupNotify);
        res.setMessage("delete success....");
        return res;
    }
}
