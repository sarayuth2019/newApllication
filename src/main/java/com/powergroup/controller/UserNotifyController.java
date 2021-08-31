package com.powergroup.controller;

import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.service.UserNotifyRepository;
import com.powergroup.model.table.UserNotify;
import com.powergroup.util.ContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/UserNotify")
public class UserNotifyController {
    @Autowired
    private UserNotifyRepository notifyRepository;
    @Autowired
    private ContextUtil contextUtil;

    @PostMapping("/save")
    public Object save(UserNotify notify) {
        APIResponse res = new APIResponse();
        notifyRepository.save(notify);
        res.setData(notify);
        res.setMessage("save success...");
        res.setStatus(1);
        return res;
    }

    @PostMapping("/list/user")
    public Object list(int user) {
        APIResponse res = new APIResponse();
        //Optional<UserEntity> dataUser = contextUtil.getUserDataFromContext();
        List<UserNotify> getList = notifyRepository.findByUserId(user);
        res.setData(getList);
        res.setMessage("List User...");
        return res;
    }

    @GetMapping("/deleteByUserId/{user}")
    public Object delete(@PathVariable int user) {
        APIResponse res = new APIResponse();
        notifyRepository.deleteByUserId(user);
        res.setStatus(1);
        res.setData(user);
        res.setMessage("delete user success....");
        return res;
    }
    @GetMapping("/deleteId/{id}")
    public Object deleteId(@PathVariable int id){
        APIResponse response = new APIResponse();
        Optional<UserNotify>data = notifyRepository.findById(id);
        notifyRepository.deleteById(id);
        response.setData(data);
        response.setStatus(1);
        response.setMessage("delete success...");
        return response;
    }
    @GetMapping("/list")
    public Object check() {
        APIResponse res = new APIResponse();
        List<UserNotify> getList = notifyRepository.findAll();
        res.setData(getList);
        return res;
    }
}
