package com.example.Aplication.controller;

import com.example.Aplication.model.bean.APIResponse;
import com.example.Aplication.model.service.UserRepository;
import com.example.Aplication.model.table.Order;
import com.example.Aplication.model.table.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/Register")
public class RegisterController {
    @Autowired
    private UserRepository userRepository;


    @PostMapping("/register")
    public Object register(User user) {
        APIResponse res = new APIResponse();
        try {
            User dbUser = userRepository.findByEmail(user.getEmail());
            if (dbUser == null) {
                userRepository.save(user);
                System.out.print(user);
                res.setStatus(1);
                res.setData(user);
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
    @GetMapping("/list")
    public Object list(){
        APIResponse res = new APIResponse();
        List<User> getOrder = userRepository.findAll();
        res.setData(getOrder);
        res.setStatus(1);
        res.setMessage("List User....");
        return res;
    }
}
