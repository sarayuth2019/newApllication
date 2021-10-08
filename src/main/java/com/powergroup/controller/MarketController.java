package com.powergroup.controller;

import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.bean.ImagesReponse;
import com.powergroup.model.service.MarketRepository;
import com.powergroup.model.table.Market;
import com.powergroup.util.ContextUtil;
import com.powergroup.util.EncoderUtil;
import com.powergroup.util.ResourceIdGenerate;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        String marketImage = "%s.png".formatted(new ResourceIdGenerate().resourceId());
        String nameImage = data.get().getImageMarket();
        String part = configParse + marketImage;
        String partDelete = configParse+data.get().getImageMarket();
        File updateImage = new File(part);
            try {
                if (file!=null) {
                    Path toDelete = Paths.get(partDelete);
                    Files.delete(toDelete);
                    file.transferTo(updateImage);
                    market.setImageMarket(marketImage);
                }
                else {
                    market.setImageMarket(nameImage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        market.setMarketId(id);
        market.setPassword(data.get().getPassword());
        market.setEmail(data.get().getEmail());
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
    public Object listId(int id) throws IOException {
        ImagesReponse res = new ImagesReponse();
        var data = marketRepository.findById(id);
        String part = configParse+data.get().getImageMarket();
        byte[] process = new byte[0];
        try {
            InputStream inputStream = new FileInputStream(part);
            IOUtils.toByteArray(inputStream);
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        res.setDataImages(process);
        res.setDataId(data);
        res.setStatus(1);
        res.setMessage("list market by Id...");
        return res;
    }
}
