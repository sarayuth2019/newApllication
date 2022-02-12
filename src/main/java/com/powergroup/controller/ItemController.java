package com.powergroup.controller;

import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.service.ItemRepository;
import com.powergroup.model.table.Items;
import com.powergroup.util.ContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/Item")
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ContextUtil contextUtil;

    @PostMapping("/save")
    public Object save(Items item) {
        APIResponse res = new APIResponse();
        itemRepository.save(item);
        res.setData(item);
        res.setMessage("save success");
        res.setStatus(0);
        return res;
    }

    @PostMapping("/update")
    public Object update(Items items) {
        APIResponse response = new APIResponse();
        items.setItemId(items.getItemId());
        itemRepository.save(items);
        response.setMessage("update success...");
        response.setStatus(1);
        response.setData(items);
        return response;
    }

    @PostMapping("/list/item")
    public Object listItem(int id) {
        APIResponse res = new APIResponse();
        Optional<Items> get = itemRepository.findById(id);
        res.setData(get);
        res.setMessage("success");
        res.setStatus(1);
        return res;
    }

    @GetMapping("/list")
    public Object list() {
        APIResponse res = new APIResponse();
        List<Items> getItem = itemRepository.findAll();
        res.setData(getItem);
        res.setMessage("ListAllItems...");
        return res;
    }

    @GetMapping("/delete/{id}")
    public Object delete(@PathVariable int id) {
        APIResponse res = new APIResponse();
        Optional<Items> data = itemRepository.findById(id);
        int deleteId = data.get().getItemId();
        itemRepository.deleteById(deleteId);
        res.setData(deleteId);
        res.setMessage("delete items success...." + deleteId);
        return res;
    }

    @PostMapping("/find/name")
    public Object find(String name) {
        APIResponse res = new APIResponse();
        List<Items> getList = this.itemRepository.findByNameItems(name);
        res.setData(getList);
        res.setMessage("Find By name Order...");
        res.setStatus(1);
        return res;
    }

    @PostMapping("/find/market")
    public Object findMarketId(int market) {
        APIResponse res = new APIResponse();
        //Optional<Customer> data = contextUtil.getCustomerDataFromContext();
        List<Items> getIdUser = this.itemRepository.findByMarketId(market);
        res.setData(getIdUser);
        res.setMessage("list order by marketId success....");
        res.setStatus(1);
        return res;
    }

    @PostMapping("/find/group")
    public Object findGroup(int group) {
        APIResponse res = new APIResponse();
        List<Items> getGroup = this.itemRepository.findByGroupItems(group);
        res.setMessage("List Group Items....");
        res.setData(getGroup);
        res.setStatus(1);
        return res;
    }
    @GetMapping("/ListProduct")
    public Object listProduct(){
        APIResponse response = new APIResponse();
        Date localDate = new Date();
        List<Items> process = new ArrayList<>();
        System.out.println(localDate);

        List<Items> data = itemRepository.findAll();
        for (int i = 0; i < data.size(); i++) {
            var date = data.get(i).getDealFinal();
            if (date.after(localDate)){
                 List<Items> x = itemRepository.findByDealFinal(date);
                 process.addAll(x);
            }
            Set set = new LinkedHashSet(process);
            ArrayList remove = new ArrayList(set);
            System.out.println(remove);
            response.setData(remove);
            response.setStatus(1);
            response.setMessage("list product success...");
        }
        return response;
    }

}
