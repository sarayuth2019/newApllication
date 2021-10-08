package com.powergroup.controller;

import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.bean.ImagesReponse;
import com.powergroup.model.service.UserRepository;
import com.powergroup.model.table.UserEntity;
import com.powergroup.util.ContextUtil;
import com.powergroup.util.EncoderUtil;
import com.powergroup.util.ResourceIdGenerate;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;


@RestController
@RequestMapping(value = "/User", method = RequestMethod.GET)
public class UserEntityController {
    @Value("${app.image_path}")
    String configParse;

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
    public Object update(UserEntity userEntity, int id, @Param("userImage") MultipartFile file) {
        APIResponse response = new APIResponse();
        var data = userEntityRepository.findById(id);
        String userImage = "%s.png".formatted(new ResourceIdGenerate().resourceId());
        String nameImage = data.get().getImageUser();
        String part = configParse+userImage;
        String deletePart = configParse+data.get().getImageUser();
        File updateImage = new File(part);
        try {
            if (file != null){
                Path toDelete = Paths.get(deletePart);
                Files.delete(toDelete);
                file.transferTo(updateImage);
                userEntity.setImageUser(userImage);
            }else {
                userEntity.setImageUser(nameImage);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        userEntity.setUserId(data.get().getUserId());
        userEntity.setEmail(data.get().getEmail());
        userEntity.setPassword(data.get().getPassword());
        encoderUtil.passwordEncoder();
        userEntityRepository.save(userEntity);
        response.setMessage("Update User success...");
        response.setStatus(1);
        response.setData(userEntity);
        return response;
    }

    @PostMapping("/list/id")
    public Object listId(int id) throws IOException {
        ImagesReponse response = new ImagesReponse();
        var data = userEntityRepository.findById(id);
        String part = configParse+ data.get().getImageUser();
        byte[] process = new byte[0];
        try {
            InputStream inputStream = new FileInputStream(part);
            process = IOUtils.toByteArray(inputStream);
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        response.setDataImages(process);
        response.setDataId(data);
        response.setStatus(1);
        response.setMessage("list By user Id...");
        return response;
    }

    @PostMapping("/list")
    public Object list() throws IOException {
        ImagesReponse res = new ImagesReponse();
        Optional<UserEntity> dataUser = contextUtil.getUserDataFromContext();
        Optional<UserEntity> get = userEntityRepository.findById(dataUser.get().getUserId());
        String part = configParse + get.get().getImageUser();
        byte[] process = new byte[0];
        try {
            InputStream inputStream = new FileInputStream(part);
            process = IOUtils.toByteArray(inputStream);
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        res.setDataImages(process);
        res.setDataId(get);
        res.setMessage("success");
        res.setStatus(1);
        return res;
    }


}
