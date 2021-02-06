package com.example.Aplication.controller;

import com.example.Aplication.model.bean.APIResponse;
import com.example.Aplication.model.service.UserRepository;
import com.example.Aplication.model.table.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/Register")
public class RegisterController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public Object register(User user, @RequestParam String username,@RequestParam String password) {
        APIResponse res = new APIResponse();
        try {
            User dbUser = userRepository.findByUsername(user.getUsername());
            if (dbUser == null) {
                userRepository.save(user);
                res.setStatus(1);
                res.setData(dbUser);
                res.setMessage("Success");
                return res;
            } else {
                res.setStatus(0);
                res.setMessage("have account");
                return res;
            }

        } catch (Exception err) {
            res.setMessage("error" + err.toString());
            res.setStatus(0);
        }
        return res;
    }
}
