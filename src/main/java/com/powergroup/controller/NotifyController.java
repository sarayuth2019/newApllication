package com.powergroup.controller;

import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.service.NotifyRepository;
import com.powergroup.model.table.Market;
import com.powergroup.model.table.Notify;
import com.powergroup.util.ContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Notify")
public class NotifyController {
    @Autowired
    private NotifyRepository notifyRepository;
    @Autowired
    private ContextUtil contextUtil;

    @PostMapping("/save")
    public Object save(Notify notify) {
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
        List<Notify> getList = notifyRepository.findByUserId(user);
        res.setData(getList);
        res.setMessage("List User...");
        return res;
    }

    @PostMapping("/delete/{user}")
    public Object delete(@PathVariable int user) {
        APIResponse res = new APIResponse();
        notifyRepository.deleteByUserId(user);
        res.setStatus(1);
        res.setData(user);
        res.setMessage("delete user success....");
        return res;
    }

    @PostMapping("/list/market")
    public Object listMarketId(int market) {
        APIResponse response = new APIResponse();
        List<Notify> list = notifyRepository.findByMarketId(market);
        response.setData(list);
        response.setMessage("List marketId...");
        response.setStatus(1);
        return response;
    }

    @PostMapping("/delete/{market}")
    private Object deleteMarketId(@PathVariable int market) {
        APIResponse response = new APIResponse();
        notifyRepository.deleteByMarketId(market);
        response.setData(market);
        response.setStatus(1);
        response.setMessage("delete marketId success...");
        return response;
    }

    @GetMapping("/list")
    public Object check() {
        APIResponse res = new APIResponse();
        List<Notify> getList = notifyRepository.findAll();
        res.setData(getList);
        return res;
    }
}
