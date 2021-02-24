package com.example.Aplication.controller;

import com.example.Aplication.model.bean.APIResponse;
import com.example.Aplication.model.service.UserRepository;
import com.example.Aplication.model.table.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/User",method = RequestMethod.GET)
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/Login")
    public Object login(User user) {
        APIResponse res = new APIResponse();
        try {
            User checkUserAndPass = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
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


}
