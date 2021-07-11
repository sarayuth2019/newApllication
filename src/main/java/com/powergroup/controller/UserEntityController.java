package com.powergroup.controller;

import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.service.UserEntityRepository;
import com.powergroup.model.table.UserEntity;
import com.powergroup.util.EncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(value = "/User", method = RequestMethod.GET)
public class UserEntityController {
    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private EncoderUtil encoderUtil;

    @Deprecated
    public Object login(UserEntity userEntity) {
        APIResponse res = new APIResponse();
        try {
            UserEntity checkUserEntityAndPass = userEntityRepository.findByEmailAndPassword(userEntity.getEmail(), userEntity.getPassword());
            if (checkUserEntityAndPass != null) {
                res.setStatus(1);
                res.setMessage("Login success");
                res.setData(checkUserEntityAndPass);
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
    public Object update(UserEntity userEntity) {
        APIResponse response = new APIResponse();
        userEntity.setPassword(encoderUtil.passwordEncoder().encode(userEntity.getPassword()));
        userEntityRepository.save(userEntity);
        response.setMessage("Update User success...");
        response.setStatus(1);
        response.setData(userEntity);
        return response;
    }

    @PostMapping("/list/id")
    public Object listId(int id) {
        APIResponse res = new APIResponse();
        Optional<UserEntity> get = userEntityRepository.findById(id);
        res.setData(get);
        res.setMessage("success");
        res.setStatus(1);
        return res;
    }


}
