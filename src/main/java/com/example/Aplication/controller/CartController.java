package com.example.Aplication.controller;

import com.example.Aplication.model.bean.APIResponse;
import com.example.Aplication.model.service.CartRepository;
import com.example.Aplication.model.table.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Cart")
public class CartController {
    @Autowired
    private CartRepository cartRepository;
    @PostMapping("/save")
    public Object save(Cart cart){
        APIResponse res = new APIResponse();
        cartRepository.save(cart);
        res.setData(cart);
        res.setMessage("save success...");
        res.setStatus(1);
        return res;
    }
    @PostMapping("/update")
    public Object update(Cart cart){
        APIResponse response = new APIResponse();
        cartRepository.save(cart);
        response.setMessage("update success...");
        response.setStatus(1);
        response.setData(cart);
        return response;
    }

    @GetMapping("/list")
    public Object list(){
        APIResponse res = new APIResponse();
        List<Cart>getList = cartRepository.findAll();
        res.setData(getList);
        res.setMessage("List All...");
        return res;
    }
    @GetMapping("/delete/{id}")
    public Object delete(Cart cart, @PathVariable int id){
        APIResponse res = new APIResponse();
        cartRepository.delete(cart);
        res.setData(cart);
        res.setMessage("delete items success....");
        return res;
    }
    @PostMapping("/find/name")
    public Object find(String name){
        APIResponse res = new APIResponse();
        List<Cart> getList = this.cartRepository.findByName(name);
        res.setData(getList);
        res.setMessage("Find By name Cart...");
        res.setStatus(1);
        return res;
    }
    @PostMapping("/find/user")
    public Object findUserId(int user){
        APIResponse res = new APIResponse();
        List<Cart> getIdUser = cartRepository.findByUser(user);
        res.setData(getIdUser);
        res.setMessage("list cart by user_id success....");
        res.setStatus(1);
        return res;
    }
    @PostMapping("/find/customer")
    public Object findCustomerId(int customer){
        APIResponse res = new APIResponse();
        List<Cart>getCustomer = cartRepository.findByCustomer(customer);
        res.setData(getCustomer);
        res.setStatus(1);
        res.setMessage("List customerId....");
        return res;
    }

}
