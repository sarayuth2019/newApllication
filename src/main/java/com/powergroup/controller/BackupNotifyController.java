package com.powergroup.controller;

import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.service.BackupNotifyRepository;
import com.powergroup.model.table.BackupNotify;
import com.powergroup.util.ContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Backup")
public class BackupNotifyController {
    @Autowired
    private BackupNotifyRepository backupRepository;
    @Autowired
    private ContextUtil contextUtil;
    @PostMapping("/save")
    public Object save(BackupNotify backupNotify) {
        APIResponse res = new APIResponse();
        backupRepository.save(backupNotify);
        res.setData(backupNotify);
        res.setMessage("save success...");
        res.setStatus(1);
        return res;
    }

    @GetMapping("/list")
    public Object list() {
        APIResponse res = new APIResponse();
        List<BackupNotify> getList = backupRepository.findAll();
        res.setData(getList);
        res.setMessage("List All...");
        return res;
    }

    @PostMapping("/list/user")
    public Object listUser(int user) {
        APIResponse res = new APIResponse();
        //Optional<UserEntity> dataUser = contextUtil.getUserDataFromContext();
        List<BackupNotify> getList = backupRepository.findByUserId(user);
        res.setStatus(1);
        res.setData(getList);
        res.setMessage("List User...");
        return res;
    }

    @PostMapping("/list/market")
    public Object listCustomer(int market) {
        APIResponse response = new APIResponse();
        //Optional<Customer> dataCustomer = contextUtil.getCustomerDataFromContext();
        List<BackupNotify> getList = backupRepository.findByMarketId(market);
        response.setData(getList);
        response.setStatus(1);
        response.setMessage("List marketId...");
        return response;
    }

}
