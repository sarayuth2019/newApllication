package com.powergroup.util;

import org.springframework.stereotype.Service;

@Service
public class TokenUtil {

    public String[] covert(String token) {
        String flagUser = token.substring(0, 1);
        String email = token.substring(1, token.length());
        return new String[]{flagUser, email};
    }
}
