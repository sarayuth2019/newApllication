package com.powergroup.controller;

import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.service.ImageRepository;
import com.powergroup.model.table.Image;
import com.powergroup.model.table.Market;
import com.powergroup.util.ContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.Random;

@RequestMapping("/images")
@RestController
public class ImageController {
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private ContextUtil contextUtil;
    @PostMapping("/save")
    public Object imageSave(Image image,@RequestParam("picture") MultipartFile file){
        APIResponse res = new APIResponse();
        Random xxx = new Random();
        int randomnumber = xxx.nextInt(100000000);
        String part = "D:\\picturekakkak"+"/"+ file.getName()+randomnumber+".png";
        String nameImage = file.getName()+randomnumber+".png";
        File file1 = new File(part);
        try {
            file.transferTo(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        image.setImage(nameImage);
        imageRepository.save(image);
        res.setData(image);
        res.setMessage("success...");
        res.setData(1);
        return res;
    }

    @GetMapping("/{itemId}")
    private Object listImage(@PathVariable int itemId){
        APIResponse res = new APIResponse();
//        Optional<Market> dataCustomer = contextUtil.getMarketDataFromContext();
        Optional<Image> data = Optional.ofNullable(imageRepository.findByItemId(itemId);
        String nameImage = data.get().getImage();
        String part = "D:\\picturekakkak"+"/"+nameImage;
        File file = new File(part);
        byte[] process = file.getName().getBytes();
        res.setData(process);
        res.setStatus(1);
        res.setMessage("success...");
        return res;
    }
}
