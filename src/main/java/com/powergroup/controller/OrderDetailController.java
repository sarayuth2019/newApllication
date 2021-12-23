package com.powergroup.controller;

import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.service.OrderDetailRepository;
import com.powergroup.model.table.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/DetailOrder")
public class OrderDetailController {
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @PostMapping("/save")
    public Object save(OrderDetail orderDetail){
        APIResponse response = new APIResponse();
        var data = orderDetailRepository.save(orderDetail);
        response.setStatus(1);
        response.setData(data);
        response.setMessage("save detail order success...");
        return response;
    }
    @PostMapping("/listByOrderId")
    public Object listOrderId(int orderId){
        APIResponse response = new APIResponse();
        var data= orderDetailRepository.findByOrderId(orderId);
        response.setStatus(1);
        response.setMessage("list by orderId...");
        response.setData(data);
        return response;
    }
    @PostMapping("/deleteDetailOrder")
    public Object deleteDetail(int id){
        APIResponse response = new APIResponse();
        var data = orderDetailRepository.findById(id);
        orderDetailRepository.deleteById(id);
        response.setMessage("delete order detail success...");
        response.setStatus(1);
        response.setData(data);
        return response;
    }
}
