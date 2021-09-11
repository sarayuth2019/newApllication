package com.powergroup.controller;

import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.service.UserRepository;
import com.powergroup.model.table.UserEntity;
import com.powergroup.util.ContextUtil;
import com.powergroup.util.EncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(value = "/User", method = RequestMethod.GET)
public class UserEntityController {
    @Autowired
    private UserRepository userEntityRepository;

    @Autowired
    private ContextUtil contextUtil;

    @Autowired
    private EncoderUtil encoderUtil;

    @Deprecated
    @PostMapping("/Login")
    public Object login(UserEntity userEntity) {
        APIResponse res = new APIResponse();
        try {
            UserEntity checkUserEntityAndPass = userEntityRepository.findByEmailAndPassword(userEntity.getEmail(), userEntity.getPassword());
            if (checkUserEntityAndPass != null) {
                encoderUtil.passwordEncoder();
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
        encoderUtil.passwordEncoder();
        userEntityRepository.save(userEntity);
        response.setMessage("Update User success...");
        response.setStatus(1);
        response.setData(userEntity);
        return response;
    }

    @PostMapping("/list/id")
    public Object listId(int id){
        APIResponse response = new APIResponse();
        var data = userEntityRepository.findById(id);
        response.setData(data);
        response.setStatus(1);
        response.setMessage("list By user Id...");
        return response;
    }

    @PostMapping("/list")
    public Object list() {
        APIResponse res = new APIResponse();
        Optional<UserEntity> dataUser = contextUtil.getUserDataFromContext();
        Optional<UserEntity> get = userEntityRepository.findById(dataUser.get().getUserId());
        res.setData(get);
        res.setMessage("success");
        res.setStatus(1);
        return res;
    }


}
