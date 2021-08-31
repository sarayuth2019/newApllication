package com.powergroup.controller;

import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.service.MarketNotifyRepository;
import com.powergroup.model.table.MarketNotify;
import com.powergroup.util.ContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/MarketNotify")
public class MarketNotifyController {
    @Autowired
    private MarketNotifyRepository notifyRepository;
    @Autowired
    private ContextUtil contextUtil;
    @PostMapping("/save")
    public Object save(MarketNotify notify){
        APIResponse rs = new APIResponse();
        notifyRepository.save(notify);
        rs.setData(notify);
        rs.setMessage("save success...");
        rs.setStatus(1);
        return rs;
    }
    @PostMapping("/list/market")
    public Object listByMarketId(int marketId){
        APIResponse rs = new APIResponse();
        var data = notifyRepository.findByMarketId(marketId);
        rs.setData(data);
        rs.setMessage("list by MarketId success...");
        rs.setStatus(1);
        return rs;
    }
    @GetMapping("/deleteId/{id}")
    public Object deleteId(@PathVariable int id){
        APIResponse rs = new APIResponse();
        Optional<MarketNotify> data = notifyRepository.findById(id);
        notifyRepository.deleteById(id);
        rs.setData(data);
        rs.setMessage("delete success...");
        rs.setStatus(1);
        return rs;
    }
    @GetMapping("/deleteByMarketId/{marketId}")
    public Object delete(@PathVariable int marketId){
     APIResponse rs = new APIResponse();
        List<MarketNotify> data = notifyRepository.findByMarketId(marketId);
        notifyRepository.deleteByMarketId(marketId);
        rs.setData(data);
        rs.setStatus(1);
        rs.setMessage("delete By marketId success...");
     return rs;
    }
    @GetMapping("/list")
    public Object list(){
        APIResponse rs = new APIResponse();
        List<MarketNotify> data = notifyRepository.findAll();
        rs.setMessage("list success...");
        rs.setStatus(1);
        rs.setData(data);
        return rs;
    }
}
