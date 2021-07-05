package com.example.Aplication.controller;

import com.example.Aplication.model.bean.APIResponse;
import com.example.Aplication.model.service.CustomerRepository;
import com.example.Aplication.model.table.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/Register")
public class CusRegisterController {
    @Autowired
    private CustomerRepository customerRepository;
    @PostMapping("/customer")
    public Object registerCus(Customer customer) {
        APIResponse res = new APIResponse();
        try {
            Customer dbUser = customerRepository.findByEmail(customer.getEmail());
            if (dbUser == null) {
                customerRepository.save(customer);
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
    @GetMapping("/list/customer")
    public Object list(){
        APIResponse res = new APIResponse();
        List<Customer> getOrder = customerRepository.findAll();
        res.setData(getOrder);
        res.setStatus(1);
        res.setMessage("List Customer....");
        return res;
    }
}
