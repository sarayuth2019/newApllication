package com.example.Aplication.controller;

import com.example.Aplication.model.bean.APIResponse;
import com.example.Aplication.model.service.BackupNotifyRepository;
import com.example.Aplication.model.service.NotifyRepository;
import com.example.Aplication.model.table.BackupNotify;
import com.example.Aplication.model.table.Notify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/Notify")
public class NotifyController {
    @Autowired
    private NotifyRepository notifyRepository;

    @PostMapping("/save")
    public Object save(Notify notify){
        APIResponse res = new APIResponse();
        notifyRepository.save(notify);
        res.setData(notify);
        res.setMessage("save success...");
        res.setStatus(1);
        return res;
    }
    @PostMapping("/list/user")
    public Object list(int user){
        APIResponse res = new APIResponse();
        List<Notify> getList = notifyRepository.findByUser(user);
        res.setData(getList);
        res.setMessage("List User...");
        return res;
    }

    @PostMapping("/delete/user")
    public Object delete(int user){
        APIResponse res = new APIResponse();
        notifyRepository.deleteByUser(user);
        res.setStatus(1);
        res.setData(user);
        res.setMessage("delete user success....");
        return res;
    }
    @GetMapping("/list")
    public Object check(){
        APIResponse res = new APIResponse();
        List<Notify> getList = notifyRepository.findAll();
        res.setData(getList);
        return res;
    }
}
