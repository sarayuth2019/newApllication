package com.powergroup.controller;

import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.service.CartRepository;
import com.powergroup.model.table.Cart;
import com.powergroup.util.ContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Cart")
public class CartController {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ContextUtil contextUtil;

    @PostMapping("/save")
    public Object save(Cart cart) {
        APIResponse res = new APIResponse();
        cartRepository.save(cart);
        res.setData(cart);
        res.setMessage("save success...");
        res.setStatus(1);
        return res;
    }

    @PostMapping("/findId")
    public Object findId(Integer id) {
        APIResponse response = new APIResponse();
        Optional<Cart> get = cartRepository.findById(id);
        response.setStatus(1);
        response.setData(get);
        response.setMessage("find by id success...");
        return response;
    }

    @PostMapping("/update")
    public Object update(Cart cart) {
        APIResponse response = new APIResponse();
        cartRepository.save(cart);
        response.setMessage("update success...");
        response.setStatus(1);
        response.setData(cart);
        return response;
    }

    @GetMapping("/list")
    public Object list() {
        APIResponse res = new APIResponse();
        List<Cart> getList = cartRepository.findAll();
        res.setData(getList);
        res.setMessage("List All...");
        return res;
    }

    @PostMapping("/delete")
    public Object delete(int id) {
        APIResponse res = new APIResponse();
        Optional<Cart> data = cartRepository.findById(id);
        int cartIdToDelete= data.get().getCartId();
        cartRepository.deleteById(cartIdToDelete);
        res.setData(cartIdToDelete);
        res.setMessage("delete items success...." + cartIdToDelete);
        return res;
    }

    @PostMapping("/find/name")
    public Object find(String name) {
        APIResponse res = new APIResponse();
        List<Cart> getList = this.cartRepository.findByNameCart(name);
        res.setData(getList);
        res.setMessage("Find By name Cart...");
        res.setStatus(1);
        return res;
    }

    @PostMapping("/find/user")
    public Object findUserId(int user) {
        APIResponse res = new APIResponse();
        //Optional<UserEntity> dataUser = contextUtil.getUserDataFromContext();
        List<Cart> getIdUser = cartRepository.findByUserId(user);
        res.setData(getIdUser);
        res.setMessage("list cart by user_id success....");
        res.setStatus(1);
        return res;
    }

    @PostMapping("/find/market")
    public Object findMarketId(int market) {
        APIResponse res = new APIResponse();
        //Optional<Customer> dataCustomer = contextUtil.getCustomerDataFromContext();
        List<Cart> getCustomer = cartRepository.findByMarketId(market);
        res.setData(getCustomer);
        res.setStatus(1);
        res.setMessage("List marketId....");
        return res;
    }

}
