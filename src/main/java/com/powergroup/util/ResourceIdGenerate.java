package com.powergroup.util;

import java.math.BigInteger;
import java.security.SecureRandom;

public class ResourceIdGenerate {
    private SecureRandom random = new SecureRandom();

    public String resourceId() {
        return new BigInteger(130, random).toString(32);
    }
}
