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
import java.util.ArrayList;
import java.util.List;
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
    @PostMapping("/payId")
    public Object listImg(int payId){
        ImagesReponse res = new ImagesReponse();
        List<ImagePay> data = payRepository.findByPayId(payId);
        String arrayList;
        ArrayList listDataImages = new ArrayList();
        ArrayList arrayId = new ArrayList();
        String part = configParse;
        for (int i = 0;i<data.size();i++){
            arrayList = data.get(i).getNameImages()+".png";
            String partImg = part+arrayList;
            System.out.println(partImg);
            try {
                InputStream inputStream = new FileInputStream(partImg);
                byte[] process = IOUtils.toByteArray(inputStream);
                listDataImages.add(process);
                arrayId.add(data.get(i).getId() );
                inputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
                res.setDataImages(e);
                res.setStatus(0);
                res.setMessage("fail to list...");
            }
            System.out.println(arrayId);
            res.setStatus(1);
            res.setMessage("list images success...");
            res.setDataId(arrayId);
            res.setDataImages(listDataImages);
        }
        System.out.println(data);
        return res;
    }
//    @PostMapping("/listId")
//    public Object list(int payId){
//        ImagesReponse imagesReponse = new ImagesReponse();
//        Optional<ImagePay> data = Optional.ofNullable(payRepository.findByPayId(payId));
//        String part = configParse + data.get().getNameImages() + ".png";
//        try {
//            InputStream inputStream = new FileInputStream(part);
//            byte[] process = IOUtils.toByteArray(inputStream);
//            imagesReponse.setDataId(data);
//            imagesReponse.setDataImages(process);
//            imagesReponse.setStatus(1);
//            imagesReponse.setMessage("list imagePay success...");
//            inputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//            imagesReponse.setDataImages(e);
//            imagesReponse.setStatus(0);
//            imagesReponse.setMessage("list imagePay fail...");
//        }
//        return imagesReponse;
//    }
}
