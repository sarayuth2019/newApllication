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
        res.setStatus(1);
        res.setData(order);
        return res;
    }
    @PostMapping("/update")
    public Object update(Order order){
        APIResponse response = new APIResponse();
        orderRepository.save(order);
        response.setStatus(1);
        response.setMessage("update success...");
        response.setData(order);
        return response;
    }
    @GetMapping("/list")
    public Object list(){
        APIResponse res = new APIResponse();
        List<Order> getOrder = orderRepository.findAll();
        res.setData(getOrder);
        res.setStatus(1);
        res.setMessage("List Order....");
        return res;
    }
    @GetMapping("/delete/{id}")
    public Object delete(Order order, @PathVariable int id){
        APIResponse res = new APIResponse();
        orderRepository.delete(order);
        res.setData(order);
        res.setStatus(1);
        res.setMessage("delete success...");
        return res;
    }
    @PostMapping("/find/name")
    public Object find(String name){
        APIResponse res = new APIResponse();
        List<Order>getList = this.orderRepository.findByName(name);
        res.setData(getList);
        res.setMessage("Find By name Order...");
        res.setStatus(1);
        return res;
    }
    @PostMapping("/find/user")
    public Object findUserId(int user){
        APIResponse res = new APIResponse();
        List<Order>getIdUser = orderRepository.findByUser(user);
        res.setData(getIdUser);
        res.setMessage("List Order By user_id success....");
        res.setStatus(1);
        return res;
    }
    @PostMapping("/find/customer")
    public Object findCustomerId(int customer){
        APIResponse res = new APIResponse();
        List<Order>getCustomer = orderRepository.findByCustomer(customer);
        res.setData(getCustomer);
        res.setStatus(1);
        res.setMessage("List customerId....");
        return res;
    }
    @PostMapping("/find/user/{user}")
    public Object findstatus(Order order,@PathVariable int user){
        APIResponse res = new APIResponse();
        List<Order> checkstatus = orderRepository.findByStatusAndUser(order.getStatus(),order.getUserId());
        res.setMessage("find success...");
        res.setStatus(1);
        res.setData(checkstatus);
        return res;
    }
}
