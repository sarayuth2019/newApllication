package com.powergroup.controller;

import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.service.MarketBackupNotifyRepository;
import com.powergroup.model.table.MarketBackupNotify;
import com.powergroup.util.ContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/MarketBackup")
@RestController
public class MarketBackupNotifyController {
    @Autowired
    private MarketBackupNotifyRepository notifyRepository;
    @Autowired
    private ContextUtil contextUtil;
    @PostMapping("/save")
    public Object save(MarketBackupNotify data){
        APIResponse response = new APIResponse();
        notifyRepository.save(data);
        response.setStatus(1);
        response.setData(data);
        response.setMessage("save success");
        return response;
    }
    @GetMapping("/list")
    public Object list(){
        APIResponse rs = new APIResponse();
        var data = notifyRepository.findAll();
        rs.setData(data);
        rs.setMessage("list notify success...");
        rs.setStatus(1);
        return rs;
    }
    @PostMapping("/list/market")
    public Object listMarketId(int marketId){
        APIResponse rs = new APIResponse();
        List<MarketBackupNotify> data = notifyRepository.findByMarketId(marketId);
        rs.setData(data);
        rs.setStatus(1);
        rs.setMessage("list by marketId success...");
        return rs;
    }
}
