package com.example.Aplication.controller;

import com.example.Aplication.model.bean.APIResponse;
import com.example.Aplication.model.service.OrderRepository;
import com.example.Aplication.model.table.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Order")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @PostMapping("/save")
    public Object save(Order order){
        APIResponse res = new APIResponse();
        orderRepository.save(order);
        res.setMessage("save success...");
        res.setData(order);
        return res;
    }
    @GetMapping("/list")
    public Object list(){
        APIResponse res = new APIResponse();
        List<Order> getOrder = orderRepository.findAll();
        res.setData(getOrder);
        res.setMessage("List Order....");
        return res;
    }
    @GetMapping("/delete/{id}")
    public Object delete(Order order, @PathVariable int id){
        APIResponse res = new APIResponse();
        orderRepository.delete(order);
        res.setData(order);
        res.setMessage("delete success...");
        return res;
    }
}
