package com.powergroup.controller;

import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.service.ItemRepository;
import com.powergroup.model.table.Items;
import com.powergroup.util.ContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/Test")
@RestController
public class DescriptionController {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ContextUtil contextUtil;

    @PostMapping("/test")
    public Object test(Items items){
        APIResponse es = new APIResponse();
        itemRepository.save(items);
        es.setData(items);
        return es;
    }
    @GetMapping("/list/{id}")
    public Object list(@PathVariable int id){
        APIResponse rs = new APIResponse();
        Optional<Items> data = itemRepository.findById(id);
        int price = 0;
        String[] s = data.get().getSize();
        System.out.println(s);
//        if (data.get().getSize() != null ){
//            data.get().getPrice() +  = price;
//        }
        rs.setData(s);
        return rs;
    }
}
