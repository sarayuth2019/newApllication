package com.powergroup.controller;

import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.service.CustomerRepository;
import com.powergroup.model.table.Customer;
import com.powergroup.util.EncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/Register")
public class MarketRegisterController {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EncoderUtil encoderUtil;
    
    @PostMapping("/market")
    public Object registerCus(Market customer) {
        APIResponse res = new APIResponse();
        try {
            Customer dbUser = customerRepository.findByEmail(customer.getEmail());
            if (dbUser == null) {
                customer.setPassword(encoderUtil.passwordEncoder().encode(customer.getPassword()));
                marketRepository.save(customer);
                System.out.print(customer);
                res.setStatus(1);
                res.setData(customer);
                res.setMessage("Success");
            } else {
                res.setStatus(0);
                res.setMessage("have account");
            }
            return res;

        } catch (Exception err) {
            res.setMessage("error" + err.toString());
            res.setStatus(0);
        }
        return res;
    }

    @GetMapping("/list/market")
    public Object list() {
        APIResponse res = new APIResponse();
        List<Customer> getOrder = customerRepository.findAll();
        res.setData(getOrder);
        res.setStatus(1);
        res.setMessage("List market....");
        return res;
    }
}
