package com.example.Aplication.controller;

import com.example.Aplication.model.bean.APIResponse;
import com.example.Aplication.model.service.ItemRepository;
import com.example.Aplication.model.table.Items;
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
}
