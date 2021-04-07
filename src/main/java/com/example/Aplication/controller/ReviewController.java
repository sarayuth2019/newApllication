package com.example.Aplication.controller;

import com.example.Aplication.model.bean.APIResponse;
import com.example.Aplication.model.service.ReviewRepository;
import com.example.Aplication.model.table.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "Review")
public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository;
    @PostMapping("/save")
    public Object save(Review review){
        APIResponse response = new APIResponse();
        reviewRepository.save(review);
        response.setData(review);
        response.setMessage("save rating success...");
        response.setStatus(1);
        return response;
    }
    @GetMapping("/find/Items")
    public Object findItems(int items){
        APIResponse res = new APIResponse();
        List<Review>getItemsId = this.reviewRepository.findByItems(items);
        res.setStatus(1);
        res.setData(getItemsId);
        res.setMessage("find ItemsId...");
        return res;
    }
    @GetMapping("/list")
    public Object list(){
        APIResponse res = new APIResponse();
        reviewRepository.findAll();
        res.setMessage("list review...");
        res.setStatus(1);
        return res;
    }
}
