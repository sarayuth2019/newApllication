package com.example.Aplication.controller;
import com.example.Aplication.model.bean.APIResponse;
import com.example.Aplication.model.service.ItemRepository;
import com.example.Aplication.model.table.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @PostMapping("/update")
    public Object update(Items items){
        APIResponse response = new APIResponse();
        itemRepository.save(items);
        response.setMessage("update success...");
        response.setStatus(1);
        response.setData(items);
        return response;
    }
    @PostMapping("/list/item")
    public Object listItem(int id){
        APIResponse res = new APIResponse();
        Optional<Items> getItem = itemRepository.findById(id);
        res.setData(getItem);
        res.setMessage("success");
        res.setStatus(1);
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
        List<Items> getList = this.itemRepository.findByName(name);
        res.setData(getList);
        res.setMessage("Find By name Order...");
        res.setStatus(1);
        return res;
    }
    @PostMapping("/find/user")
    public Object findUserId(int user){
        APIResponse res = new APIResponse();
        List<Items> getIdUser = this.itemRepository.findByUser(user);
        res.setData(getIdUser);
        res.setMessage("list order by user_id success....");
        res.setStatus(1);
        return res;
    }
    @PostMapping("find/group")
    public Object findGroup(int group){
        APIResponse res = new APIResponse();
        List<Items> getGroup = this.itemRepository.findByGroup(group);
        res.setMessage("List Group Items....");
        res.setData(getGroup);
        res.setStatus(1);
        return res;
    }

}
