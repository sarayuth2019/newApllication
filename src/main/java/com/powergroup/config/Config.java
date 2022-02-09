package com.powergroup.config;

public class Config {

    public static final String[] ALLOW_API_PATH = new String[]{
            "/home/index",//อย่าลบ เอาไว้ตอน deploy
            "/token_check",
            "/authorizeUser",
            "/authorizeMarket",
            "/Register/user",
            "/Register/market",
            "/BankMarket/save"
    };

}
