package com.powergroup.controller;

import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.service.UserEntityRepository;
import com.powergroup.model.table.UserEntity;
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
    private UserEntityRepository userEntityRepository;

    @PostMapping("/user")
    public Object register(UserEntity userEntity) {
        APIResponse res = new APIResponse();
        try {
            UserEntity dbUserEntity = userEntityRepository.findByEmail(userEntity.getEmail());
            if (dbUserEntity == null) {
                userEntityRepository.save(userEntity);
                System.out.print(userEntity);
                res.setStatus(1);
                res.setData(userEntity);
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

    @GetMapping("/list/user")
    public Object list() {
        APIResponse res = new APIResponse();
        List<UserEntity> getOrder = userEntityRepository.findAll();
        res.setData(getOrder);
        res.setStatus(1);
        res.setMessage("List User....");
        return res;
    }
}
