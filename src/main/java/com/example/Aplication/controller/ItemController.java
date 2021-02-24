package com.example.Aplication.controller;

import com.example.Aplication.model.bean.APIResponse;
import com.example.Aplication.model.service.ItemRepository;
import com.example.Aplication.model.table.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/Item")
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;
    @PostMapping("/save")
    public Object save(Item item){
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
        List<Item> getItem = itemRepository.findAll();
        res.setData(getItem);
        res.setMessage("ListAllItems...");
        return res;
    }
}
