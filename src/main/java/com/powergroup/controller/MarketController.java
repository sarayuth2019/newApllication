package com.powergroup.controller;

import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.bean.ImagesReponse;
import com.powergroup.model.service.MarketRepository;
import com.powergroup.model.table.Market;
import com.powergroup.util.ContextUtil;
import com.powergroup.util.EncoderUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Optional;

@RestController
@RequestMapping(value = "/Market")
public class MarketController {

    @Value("${app.image_path}")
    String configParse;

    @Autowired
    private MarketRepository marketRepository;

    @Autowired
    private EncoderUtil encoderUtil;

    @Autowired
    private ContextUtil contextUtil;

    @Deprecated
    @PostMapping("/Login")
    public Object login(Market customer) {
        APIResponse res = new APIResponse();
        try {
            Market checkUserAndPass = marketRepository.findByEmailAndPassword(customer.getEmail(), customer.getPassword());
            if (checkUserAndPass != null) {
                res.setStatus(1);
                res.setMessage("Login success");
                res.setData(checkUserAndPass);
                return res;

            } else {
                res.setStatus(0);
                res.setMessage("Login fail");
            }

        } catch (Exception err) {
            res.setData(0);
            res.setMessage("Error" + err.toString());
        }
        return res;
    }

    @PostMapping("/update")
    public Object update(Market market, int id, @Param("marketImage") MultipartFile file) {
        APIResponse response = new APIResponse();
        var data = marketRepository.findById(id);
        String marketImage = data.get().getImageMarket();
        if (file != null) {
            String part = configParse + marketImage;
            File updateImage = new File(part);
            try {
                file.transferTo(updateImage);
                market.setImageMarket(file.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(file == null){
            market.setImageMarket(marketImage);
        }
        market.setMarketId(id);
        market.setStatusMarket(data.get().getStatusMarket());
        encoderUtil.passwordEncoder();
        marketRepository.save(market);
        response.setMessage("Update market success...");
        response.setStatus(1);
        response.setData(market);
        return response;
    }

    @PostMapping("/list")
    public Object list() throws IOException {
        ImagesReponse res = new ImagesReponse();
        Optional<Market> dataCustomer = contextUtil.getMarketDataFromContext();
        Optional<Market> get = marketRepository.findById(dataCustomer.get().getMarketId());
        String part = configParse + get.get().getImageMarket();
        byte[] process = new byte[0];
        try {
            InputStream inputStream = new FileInputStream(part);
            process = IOUtils.toByteArray(inputStream);
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        res.setStatus(1);
        res.setDataId(get);
        res.setDataImages(process);
        res.setMessage("List marketId By id...");
        return res;
    }

    @PostMapping("/list/id")
    public Object listId(int id) {
        APIResponse res = new APIResponse();
        var data = marketRepository.findById(id);
        res.setData(data);
        res.setStatus(1);
        res.setMessage("list market by Id...");
        return res;
    }
}
