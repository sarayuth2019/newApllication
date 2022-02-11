package com.powergroup.controller;

import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.service.ItemRepository;
import com.powergroup.model.service.PayAdminRepository;
import com.powergroup.model.table.Items;
import com.powergroup.model.table.PaymentAdmin;
import com.powergroup.util.ContextUtil;
import com.powergroup.util.EncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/PayAdmin")
public class PaymentAdminController {
    @Autowired
    private PayAdminRepository payAdminRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private EncoderUtil encoderUtil;

    @Autowired
    private ContextUtil contextUtil;

    @PostMapping("/save")
    public Object save(PaymentAdmin paymentAdmin){
        APIResponse response = new APIResponse();
        var data = payAdminRepository.save(paymentAdmin);
        response.setData(data);
        response.setStatus(1);
        response.setMessage("success...");
        return response;
    }
    @PostMapping("/update/{payId}")
    public Object update(@PathVariable int payId, PaymentAdmin paymentAdmin){
        APIResponse rs = new APIResponse();
        var save = payAdminRepository.save(paymentAdmin);
        rs.setData(save);
        rs.setMessage("update success...");
        rs.setStatus(1);
        return rs;
    }
    @PostMapping("/listByItemId")
    public Object listItem(int itemId){
        APIResponse rs=  new APIResponse();
        List<PaymentAdmin> list = payAdminRepository.findByItemId(itemId);
//        var o = itemRepository.findById(itemId);
        rs.setMessage("list pay admin by itemId....");
        rs.setStatus(1);
        rs.setData(list);
        return rs;
    }
    @GetMapping("/list")
    public Object list(){
        APIResponse res= new APIResponse();
        var data = payAdminRepository.findAll();
        res.setMessage("list Payment Admin success...");
        res.setData(data);
        res.setStatus(1);
        return res;
    }
    @PostMapping("/listMarket")
    public Object listMarket(int marketId){
        APIResponse rs = new APIResponse();
        List<PaymentAdmin> admins = payAdminRepository.findByMarketId(marketId);
        rs.setMessage("list pay admin...");
        rs.setStatus(1);
        rs.setData(admins);
        return rs;
    }
    @GetMapping("/listPending")
    public Object listPending(){
        APIResponse res = new APIResponse();
        List<Optional> process = new ArrayList<>();
        String status = "รอดำเนินการ";
        List<PaymentAdmin> data = payAdminRepository.findByStatus(status);
        for (int i = 0; i < data.size(); i++) {
            int itemId = data.get(i).getItemId();
            var optionalItems= itemRepository.findById(itemId);
            int count = optionalItems.get().getCount();
            int countRequest = optionalItems.get().getCountRequest();
            if (count == countRequest){
                process.add(optionalItems);
            }
        }
        res.setStatus(1);
        res.setMessage("รอดำเนินการ...");
        res.setData(process);
        return res;
    }
    @GetMapping("/listCheckPay")
    public Object checkPay(){
        APIResponse res = new APIResponse();
        List<Optional> process = new ArrayList<>();
        String status = "รอตรวจสอบจากร้านค้า";
        List<PaymentAdmin> data = payAdminRepository.findByStatus(status);
        for (int i = 0; i < data.size(); i++) {
            int itemId = data.get(i).getItemId();
            var optionalItems= itemRepository.findById(itemId);
            int count = optionalItems.get().getCount();
            int countRequest = optionalItems.get().getCountRequest();
            if (count == countRequest){
                process.add(optionalItems);
            }
        }
        res.setStatus(1);
        res.setMessage("รอตรวจสอบจากร้านค้า...");
        res.setData(process);
        return res;
    }
    @GetMapping("/listPaymentFail")
    public Object payFail(){
        APIResponse res = new APIResponse();
        List<Optional> process = new ArrayList<>();
        String status = "ชำระเงินผิดพลาด";
        List<PaymentAdmin> data = payAdminRepository.findByStatus(status);
        for (int i = 0; i < data.size(); i++) {
            int itemId = data.get(i).getItemId();
            var optionalItems= itemRepository.findById(itemId);
            int count = optionalItems.get().getCount();
            int countRequest = optionalItems.get().getCountRequest();
            if (count == countRequest){
                process.add(optionalItems);
            }
        }
        res.setStatus(1);
        res.setMessage("ชำระเงินผิดพลาด...");
        res.setData(process);
        return res;
    }
    @GetMapping("/listPaymentSuccess")
    public Object paySuccess(){
        APIResponse res = new APIResponse();
        List<Optional> process = new ArrayList<>();
        String status = "ชำระเงินสำเร็จ";
        List<PaymentAdmin> data = payAdminRepository.findByStatus(status);
        for (int i = 0; i < data.size(); i++) {
            int itemId = data.get(i).getItemId();
            var optionalItems= itemRepository.findById(itemId);
            int count = optionalItems.get().getCount();
            int countRequest = optionalItems.get().getCountRequest();
            if (count == countRequest){
                process.add(optionalItems);
            }
        }
        res.setStatus(1);
        res.setMessage("ชำระเงินสำเร็จ...");
        res.setData(process);
        return res;
    }

}
