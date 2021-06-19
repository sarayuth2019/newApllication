package com.example.Aplication.controller;

import com.example.Aplication.model.bean.APIResponse;
import com.example.Aplication.model.service.UserRepository;
import com.example.Aplication.model.table.Customer;
import com.example.Aplication.model.table.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(value = "/User",method = RequestMethod.GET)
public class UserController {
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
    @PostMapping("/update")
    public Object update(User user){
        APIResponse response = new APIResponse();
        userRepository.save(user);
        response.setMessage("Update User success...");
        response.setStatus(1);
        response.setData(user);
        return response;
    }
    @PostMapping("/list/id")
    public Object listId(int id){
        APIResponse res = new APIResponse();
        Optional<User> getId = userRepository.findById(id);
        res.setData(getId);
        res.setMessage("success");
        res.setStatus(1);
        return res;
    }


}
