package com.powergroup.controller;

import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.service.MarketRepository;
import com.powergroup.model.table.Market;
import com.powergroup.util.EncoderUtil;
import com.powergroup.util.ResourceIdGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.html.Option;
import java.io.File;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/Register")
public class MarketRegisterController {
    @Value("${app.image_path}")
    String configParse;

    @Autowired
    private MarketRepository marketRepository;

    @Autowired
    private EncoderUtil encoderUtil;
    
    @PostMapping("/market")
    public Object registerMarket(Market market, @RequestParam("marketImage")MultipartFile file) {
        APIResponse res = new APIResponse();
        String part = "%s.png".formatted(new ResourceIdGenerate().resourceId());
        File file1 = new File("%s%s".formatted(configParse,part));
        try {
            file.transferTo(file1);
            var data = marketRepository.findAll().size();
            Market dbUser = marketRepository.findByEmail(market.getEmail());
            System.out.println(data);
            if (dbUser == null) {
                if (data == 0){
                    market.setMarketId(1);
                    market.setStatusMarket("admin");
                    market.setPassword(encoderUtil.passwordEncoder().encode(market.getPassword()));
                }else{
                market.setPassword(encoderUtil.passwordEncoder().encode(market.getPassword()));
                market.setStatusMarket("market");
                }
                market.setImageMarket(part);
                marketRepository.save(market);
                System.out.print(market);
                res.setStatus(1);
                res.setData(market);
                res.setMessage("Success");
            } else {
                res.setStatus(0);
                res.setMessage("have account");
            }
            return res;

        } catch (Exception err) {
            res.setMessage("error" + err.toString());
            res.setStatus(0);
        }
        return res;
    }

    @GetMapping("/list/market")
    public Object list() {
        APIResponse res = new APIResponse();
        List<Market> getOrder = marketRepository.findAll();
        res.setData(getOrder);
        res.setStatus(1);
        res.setMessage("List market....");
        return res;
    }
}
