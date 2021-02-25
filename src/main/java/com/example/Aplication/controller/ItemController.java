package com.example.Aplication.controller;

import com.example.Aplication.model.bean.APIResponse;
import com.example.Aplication.model.service.ItemRepository;
import com.example.Aplication.model.table.Cart;
import com.example.Aplication.model.table.Items;
import com.example.Aplication.model.table.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Item")
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;
    @PostMapping("/save")
    public Object save(Items item){
        APIResponse res = new APIResponse();
        itemRepository.save(item);
        res.setData(item);
        res.setMessage("save success");
        res.setStatus(0);
        return res;
    }
    @GetMapping("/list")
    public Object list(){
        APIResponse res = new APIResponse();
        List<Items> getItem = itemRepository.findAll();
        res.setData(getItem);
        res.setMessage("ListAllItems...");
        return res;
    }
    @GetMapping("/delete/{id}")
    public Object delete(Items items, @PathVariable int id){
        APIResponse res = new APIResponse();
        itemRepository.delete(items);
        res.setData(items);
        res.setMessage("delete items success....");
        return res;
    }
    @PostMapping("/find/name")
    public Object find(String name){
        APIResponse res = new APIResponse();
        List<Cart> getList = this.itemRepository.findByName(name);
        res.setData(getList);
        res.setMessage("Find By name Order...");
        res.setStatus(1);
        return res;
    }
    @PostMapping("/find/user")
    public Object findUserId(int user){
        APIResponse res = new APIResponse();
        List<Cart> getIdUser = itemRepository.findByUser(user);
        res.setData(getIdUser);
        res.setMessage("list order by user_id success....");
        res.setStatus(1);
        return res;
    }
}
