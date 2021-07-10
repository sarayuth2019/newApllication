package com.example.Aplication.controller;

import com.example.Aplication.model.bean.APIResponse;
import com.example.Aplication.model.service.CustomerRepository;
import com.example.Aplication.model.table.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/Customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/Login")
    public Object login(Customer customer) {
        APIResponse res = new APIResponse();
        try {
            Customer checkUserAndPass = customerRepository.findByEmailAndPassword(customer.getEmail(), customer.getPassword());
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
    public Object update(Customer customer){
        APIResponse response = new APIResponse();
        customerRepository.save(customer);
        response.setMessage("Update Customer success...");
        response.setStatus(1);
        response.setData(customer);
        return response;
    }
    @PostMapping("/list/id")
    public Object listId(int id){
        APIResponse res = new APIResponse();
        Optional<Customer> get = customerRepository.findById(id);
        res.setStatus(1);
        res.setData(get);
        res.setMessage("List Customer By id...");
        return res;
    }
}
