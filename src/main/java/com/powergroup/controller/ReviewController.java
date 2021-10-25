package com.powergroup.controller;

import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.service.ReviewRepository;
import com.powergroup.model.table.Review;
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
    public Object save(Review review) {
        APIResponse response = new APIResponse();
        reviewRepository.save(review);
        response.setData(review);
        response.setMessage("save rating success...");
        response.setStatus(1);
        return response;
    }

    @PostMapping("/find/MarketId")
    public Object findItems(int marketId) {
        APIResponse res = new APIResponse();
        List<Review> getMarketId = this.reviewRepository.findByMarketId(marketId);
        res.setStatus(1);
        res.setData(getMarketId);
        res.setMessage("find ItemsId...");
        return res;
    }

    @GetMapping("/list")
    public Object list() {
        APIResponse res = new APIResponse();
        reviewRepository.findAll();
        res.setMessage("list review...");
        res.setStatus(1);
        return res;
    }
}
