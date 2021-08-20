package com.powergroup.controller;

import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.bean.ImagesReponse;
import com.powergroup.model.service.ImagePayRepository;
import com.powergroup.model.table.ImagePay;
import com.powergroup.util.ContextUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Optional;

@RequestMapping("/ImagePay")
@RestController
public class ImagePayController {
    @Autowired
    private ImagePayRepository payRepository;
    @Autowired
    private ContextUtil contextUtil;

    @Value("${app.image_path}")
    String configParse;

    @PostMapping("/save")
    private Object save(ImagePay imagePay,@RequestParam("picture") MultipartFile file){
        APIResponse response = new APIResponse();
        String part = configParse + file.getOriginalFilename()+".png";
        File file1 = new File(part);
        try {
            file.transferTo(file1);
            imagePay.setNameImages(file.getOriginalFilename());
            var data = payRepository.save(imagePay);
            response.setData(data);
            response.setMessage("create images success...");
            response.setStatus(1);
        } catch (IOException e) {
            e.printStackTrace();
            response.setStatus(0);
            response.setData(e);
            response.setMessage("can't create image fail...");
        }
        return response;
    }
    @GetMapping("/listId/{payId}")
    public Object list(@PathVariable int payId){
        ImagesReponse imagesReponse = new ImagesReponse();
        Optional<ImagePay> data = payRepository.findByPayId(payId);
        String part = configParse + data.get().getNameImages() + ".png";
        try {
            InputStream inputStream = new FileInputStream(part);
            byte[] process = IOUtils.toByteArray(inputStream);
            imagesReponse.setDataId(data);
            imagesReponse.setDataImages(process);
            imagesReponse.setStatus(1);
            imagesReponse.setMessage("list imagePay success...");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            imagesReponse.setDataImages(e);
            imagesReponse.setStatus(0);
            imagesReponse.setMessage("list imagePay fail...");
        }
        return imagesReponse;
    }
}
