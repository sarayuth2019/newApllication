package com.powergroup.controller;

import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.service.BankMarketRepository;
import com.powergroup.model.table.BankMarket;
import com.powergroup.util.ContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BankMarket")
public class BankMarketController {
    @Autowired
    private BankMarketRepository bankMarketRepository;
    @Autowired
    private ContextUtil contextUtil;
    @PostMapping("/save")
    public Object save(BankMarket bankMarket) {
        APIResponse res = new APIResponse();
        bankMarketRepository.save(bankMarket);
        res.setData(bankMarket);
        res.setMessage("save success...");
        res.setStatus(1);
        return res;
    }
    @PostMapping("/deleteByBankMarketId")
    public Object delete(int bankMarketId){
        APIResponse rs = new APIResponse();
        bankMarketRepository.deleteById(bankMarketId);
        rs.setData(bankMarketId);
        rs.setMessage("delete bankMarket success...");
        rs.setStatus(1);
        return rs;
    }
    @PostMapping("/update/{bankMarketId}")
    public Object update(@PathVariable int bankMarketId,BankMarket bankMarket){
        APIResponse rs = new APIResponse();
        bankMarket.setBankMarketId(bankMarket.getBankMarketId());
        var save = bankMarketRepository.save(bankMarket);
        rs.setMessage("update success");
        rs.setData(save);
        rs.setStatus(1);
        return rs;
    }
    @PostMapping("/listBankByMarketId")
    public Object listBank(int marketId){
        APIResponse rs = new APIResponse();
        List<BankMarket> data = bankMarketRepository.findByMarketId(marketId);
        rs.setData(data);
        rs.setStatus(1);
        rs.setMessage("list Bank by MarketId...");
        return rs;
    }

}
