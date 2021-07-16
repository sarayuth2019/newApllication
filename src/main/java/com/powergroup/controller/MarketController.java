package com.powergroup.controller;

import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.service.MarketRepository;
import com.powergroup.model.table.Market;
import com.powergroup.util.ContextUtil;
import com.powergroup.util.EncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/Market")
public class MarketController {
    @Autowired
    private MarketRepository marketRepository;

    @Autowired
    private EncoderUtil encoderUtil;

    @Autowired
    private ContextUtil contextUtil;

    @Deprecated
    @PostMapping("/Login")
    public Object login(Market customer) {
        APIResponse res = new APIResponse();
        try {
            Market checkUserAndPass = marketRepository.findByEmailAndPassword(customer.getEmail(), customer.getPassword());
            if (checkUserAndPass != null) {
                res.setStatus(1);
                res.setMessage("Login success");
                res.setData(checkUserAndPass);
                return res;

            } else {
                res.setStatus(0);
                res.setMessage("Login fail");
            }

        } catch (Exception err) {
            res.setData(0);
            res.setMessage("Error" + err.toString());
        }
        return res;
    }

    @PostMapping("/update")
    public Object update(Market customer) {
        APIResponse response = new APIResponse();
        encoderUtil.passwordEncoder();
        marketRepository.save(customer);
        response.setMessage("Update market success...");
        response.setStatus(1);
        response.setData(customer);
        return response;
    }

    @PostMapping("/list")
    public Object listId() {
        APIResponse res = new APIResponse();
        Optional<Market> dataCustomer = contextUtil.getCustomerDataFromContext();
        Optional<Market> get = marketRepository.findById(dataCustomer.get().getMarketId());
        res.setStatus(1);
        res.setData(get);
        res.setMessage("List marketId By id...");
        return res;
    }
}
