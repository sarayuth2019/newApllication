package com.powergroup.model.service;

import com.powergroup.model.table.Market;
import com.powergroup.oauth2.TokenService;
import com.powergroup.util.EncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class MarketService {

    @Autowired
    private MarketRepository customerRepository;

    @Autowired
    private EncoderUtil encoderUtil;

    @Autowired
    private TokenService tokenService;

    public Optional<Map<String, Object>> login(LoginBean loginBean) {
        Market customer = customerRepository.findByEmail(loginBean.getUsername());
        Map<String, Object> ret = new HashMap<>();
        if (customer != null) {
            String userPassWord = customer.getPassword();
            if (encoderUtil.passwordEncoder().matches(loginBean.getPassword(), userPassWord)) {
                ret.put("data", 1);
                ret.put("token", tokenService.createTokenMarket(customer));
                ret.put("marketId", customer.getMarketId());
                return Optional.of(ret);
            } else {
                ret.put("data", 0);
                return Optional.of(ret);
            }
        }else {
            ret.put("data", 0);
        }
        return Optional.of(ret);
    }
}
