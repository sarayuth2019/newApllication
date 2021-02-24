package com.example.Aplication.controller;

import com.example.Aplication.model.bean.APIResponse;
import com.example.Aplication.model.service.PromotionRepository;
import com.example.Aplication.model.table.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Promotion")
public class PromotionController {
    @Autowired
    private PromotionRepository promotionRepository;
    @PostMapping("/save")
    public Object save(Promotion promotion){
        APIResponse res = new APIResponse();
        promotionRepository.save(promotion);
        res.setMessage("save success...");
        res.setData(promotion);
        return res;
    }
    @GetMapping("/list")
    public Object list(){
        APIResponse res = new APIResponse();
        List<Promotion> getPromotion = promotionRepository.findAll();
        res.setMessage("List Promotion");
        res.setData(getPromotion);
        return res;
    }
    @GetMapping("/delete/{id}")
    public Object delete(Promotion promotion, @PathVariable int id){
        APIResponse res = new APIResponse();
        promotionRepository.delete(promotion);
        res.setMessage("delete Promotion success...");
        res.setData(promotion);
        return res;
    }
}
