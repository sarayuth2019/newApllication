package com.powergroup.model.service;

import com.powergroup.model.table.Market;
import com.powergroup.model.table.UserEntity;
import com.powergroup.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userShopRepository;

    @Autowired
    private MarketRepository userMarketRepository;

    @Autowired
    private TokenUtil tokenUtil;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        String[] tokenData = tokenUtil.covert(s);
        String flagUser = tokenData[0];
        String email = tokenData[1];
        UserEntity userManager = null;
        if ("1".equals(flagUser)) {
            //user
            UserEntity userShop = userShopRepository.findByEmail(email);
            if (userShop == null) {
                throw new UsernameNotFoundException(s);
            }
            return new User(userManager.getEmail(), "", getAuthority());
        } else {
            //market
            Market userMarket = userMarketRepository.findByEmail(email);
            if (userMarket == null) {
                throw new UsernameNotFoundException(s);
            }
            return new User(userMarket.getEmail(), "", getAuthority());
        }
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
}
