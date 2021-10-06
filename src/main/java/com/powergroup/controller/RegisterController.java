package com.powergroup.controller;

import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.service.UserRepository;
import com.powergroup.model.table.UserEntity;
import com.powergroup.util.EncoderUtil;
import com.powergroup.util.ResourceIdGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;


@RestController
@RequestMapping("/Register")
public class RegisterController {

    @Value("${app.image_path}")
    String configParse;

    @Autowired
    private UserRepository userEntityRepository;

    @Autowired
    private EncoderUtil encoderUtil;

    @PostMapping("/user")
    public Object register(UserEntity userEntity, @RequestParam("userImage")MultipartFile file) {
        APIResponse res = new APIResponse();
        String nameImage = "%s.png".formatted(new ResourceIdGenerate().resourceId());
        File file1 = new File("%s%s".formatted(configParse,nameImage));
        try {
            UserEntity dbUserEntity = userEntityRepository.findByEmail(userEntity.getEmail());
            file.transferTo(file1);
            if (dbUserEntity == null) {
                userEntity.setImageUser(nameImage);
                userEntity.setPassword(encoderUtil.passwordEncoder().encode(userEntity.getPassword()));
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
