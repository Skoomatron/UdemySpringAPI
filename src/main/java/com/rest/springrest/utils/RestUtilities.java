package com.rest.springrest.utils;

import java.math.BigInteger;
import java.security.SecureRandom;

public class RestUtilities {

    public String randomId() {
        SecureRandom secureRandom = new SecureRandom();
        String secureId = new BigInteger(32, secureRandom).toString();
        return secureId;
    }
}
