package com.powergroup.controller;
import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.bean.ImagesReponse;
import com.powergroup.model.service.ImageRepository;
import com.powergroup.model.table.Image;
import com.powergroup.util.ContextUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    @PostMapping("/deleteItemId")
    public Object delete(int itemId) throws IOException {
        APIResponse res = new APIResponse();
        String parseImage = "";
        List<Image> data = imageRepository.findByItemId(itemId);
        for (int i = 0; i < data.size(); i++) {
            String nameImage = data.get(i).getImageName();
            parseImage = "D:\\picturekakkak" + "/" + nameImage;
//            Files.createFile(Paths.get(parseImage));
            Path fileToDeletePath = Paths.get(parseImage);
            Files.delete(fileToDeletePath);
            System.out.println("delete images in store"+fileToDeletePath+"\n");
        }
        imageRepository.deleteByItemId(itemId);
        res.setData("delete By userId = "+ itemId);
        res.setMessage("delete success...");
        res.setStatus(1);
        return res;
    }

    @GetMapping("/{itemId}")
    public Object listImg(@PathVariable int itemId){
        ImagesReponse imagesReponse = new ImagesReponse();
        List<Image> data = imageRepository.findByItemId(itemId);
        String arrayList;
        ArrayList listDataImages = new ArrayList();
        ArrayList arrayId = new ArrayList();
        String part = "D:\\picturekakkak"+"/";
        for (int i = 0;i<data.size();i++){
            arrayList = data.get(i).getImageName();
            arrayId.add(data.get(i).getItemId());
            String partImg =part+arrayList;
            try {
                InputStream inputStream = new FileInputStream(partImg);
                byte[] process = IOUtils.toByteArray(inputStream);
                listDataImages.add(process);
                inputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
                imagesReponse.setDataImages(e);
                imagesReponse.setStatus(0);
                imagesReponse.setMessage("fail to list...");
            }
            imagesReponse.setStatus(1);
            imagesReponse.setMessage("list images success...");
            imagesReponse.setDataId(arrayId);
            imagesReponse.setDataImages(listDataImages);
        }
        return imagesReponse;
    }
    @PostMapping("/update/{id}")
    public Object update(@PathVariable int id,@RequestParam("picture")MultipartFile file) {
        APIResponse res = new APIResponse();
        String partDir = "";
        Image data = imageRepository.findById(id);
        String nameImage = data.getImageName();
        partDir = "D:\\picturekakkak" + "/"+nameImage;
        File updateImages = new File(partDir);
        try {
            data.setImageName(nameImage);
            imageRepository.save(data);
            file.transferTo(updateImages);
            res.setData(data);
            res.setMessage("update images success...");
            res.setStatus(1);
        } catch (IOException e) {
            e.printStackTrace();
            res.setData(e);
            res.setMessage("process fail...");
            res.setStatus(0);
        }
        System.out.println("++++++======================++++++++>"+data);
        return res;
    }
}
