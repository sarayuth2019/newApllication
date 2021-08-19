package com.powergroup.controller;

import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.bean.ImagesReponse;
import com.powergroup.model.service.PayRepository;
import com.powergroup.model.table.PayEntity;
import com.powergroup.util.ContextUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(name = "/Pay")
public class PayController {
    @Autowired
    private PayRepository payRepository;
    @Autowired
    private ContextUtil contextUtil;
    String configParse = "D:\\picturekakkak/";
    @PostMapping("/save")
    public Object save(PayEntity payEntity, @RequestParam("picture")MultipartFile file){
        APIResponse apiResponse = new APIResponse();
        String parse = configParse+file.getOriginalFilename()+".png";
        File file1 = new File(parse);
        try {
            file.transferTo(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        payEntity.setImageTransfer(file.getOriginalFilename());
        PayEntity data = payRepository.save(payEntity);
        apiResponse.setMessage("save success...");
        apiResponse.setData(data);
        apiResponse.setStatus(1);
        return apiResponse;
    }
    @GetMapping("/listId/{id}")
    public Object listId(@PathVariable int id) {
        ImagesReponse imagesReponse = new ImagesReponse();
        Optional<PayEntity> data = payRepository.findById(id);
        String parse = configParse +data.get().getImageTransfer()+".png";
        try {
            InputStream _image = new FileInputStream(parse);
            byte[] process = IOUtils.toByteArray(_image);
            imagesReponse.setDataImages(process);
            imagesReponse.setDataId(data);
            imagesReponse.setStatus(1);
            imagesReponse.setMessage("success...");
            _image.close();
        } catch (IOException e) {
            e.printStackTrace();
            imagesReponse.setStatus(0);
            imagesReponse.setMessage("error");
        }
        return imagesReponse;
    }
    @GetMapping("/list")
    public Object list(){
        APIResponse response = new APIResponse();
        List<PayEntity> data= payRepository.findAll();
        response.setStatus(1);
        response.setData(data);
        response.setMessage("listAll Pay success...");
        return response;
    }
    @GetMapping("/listByStatus/{status}")
    public Object listStatus(@PathVariable String status){
        ImagesReponse imagesReponse = new ImagesReponse();
        List<PayEntity> data = payRepository.findByStatus(status);
        imagesReponse.setDataId(data);
        imagesReponse.setStatus(1);
        imagesReponse.setMessage("list by Status");
        return imagesReponse;
    }
    @PostMapping("/user")
    public Object listUser(int userId){
        APIResponse response = new APIResponse();
        List<PayEntity> data = payRepository.findByUserId(userId);
        response.setMessage("list Pay by UserId...");
        response.setData(data);
        response.setStatus(1);
        return response;
    }
    @PostMapping("/market")
    public Object listMarket(int marketId){
        APIResponse response = new APIResponse();
        List<PayEntity> data = payRepository.findByMarketId(marketId);
        response.setMessage("list Pay by MarketId...");
        response.setData(data);
        response.setStatus(1);
        return response;
    }
    @PostMapping("/item")
    public Object listItem(int itemId){
        APIResponse response = new APIResponse();
        List<PayEntity> data = payRepository.findByItemId(itemId);
        response.setMessage("list Pay by itemId...");
        response.setData(data);
        response.setStatus(1);
        return response;
    }
}
