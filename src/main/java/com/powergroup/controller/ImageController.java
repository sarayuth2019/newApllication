package com.powergroup.controller;
import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.service.ImageRepository;
import com.powergroup.model.table.Image;
import com.powergroup.util.ContextUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

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
        image.setImageName(nameImage);
        imageRepository.save(image);
        res.setData(image);
        res.setMessage("success...");
        res.setData(1);
        return res;
    }
    @GetMapping("/{itemId}")
    public Object listImg(@PathVariable int itemId){
        APIResponse res = new APIResponse();
        List<Image> data = imageRepository.findByItemId(itemId);
        String arrayList;
        ArrayList list = new ArrayList();
        String part = "D:\\picturekakkak"+"/";
        for (int i = 0;i<data.size();i++){
            arrayList = data.get(i).getImageName();
            String partImg =part+arrayList;
            try {
                InputStream inputStream = new FileInputStream(partImg);
                byte[] process = IOUtils.toByteArray(inputStream);
                list.add(process);

            } catch (IOException e) {
                e.printStackTrace();
                res.setData(e);
                res.setData(0);
                res.setMessage("fail to list...");
            }
            System.out.println(list.toArray());
            res.setStatus(1);
            res.setMessage("list images success...");
            res.setData(list.toArray());
        }
        return res;
    }

//    @GetMapping("find/{itemId}")
//    public Object listImage(@PathVariable int itemId) throws IOException {
//        APIResponse res = new APIResponse();
//        Optional<Image> data = Optional.ofNullable(imageRepository.findByItemId(itemId));
//        String nameImage = data.get().getImageName();
//        String part = "D:\\picturekakkak"+"/"+nameImage;
//        try {
//            InputStream _image = new FileInputStream(part);
//            byte[] process = IOUtils.toByteArray(_image);
//            res.setData(process);
//            res.setStatus(1);
//            res.setMessage("success...");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            res.setStatus(0);
//            res.setMessage("error");
//        }
//        return res;
//    }
}
