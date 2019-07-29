package com.bitmart.chaingatewaydemo.service;

import org.springframework.stereotype.Service;

@Service
public class CheckService {
    public  boolean stringCheck(String string) {
        boolean result = false;
        if (string != null)
            if (!string.equals(""))
                result = true;
        return result;
    }

    public  boolean intCheck(Integer integer) {
        boolean result = false;
        if (integer != null)
            if (integer > 0)
                result = true;
        return result;
    }

    public  boolean longCheck(Long longs) {
        boolean result = false;
        if (longs != null)
            if (longs > 0)
                result = true;
        return result;
    }

    public  boolean booleanCheck(Boolean booleans) {
        boolean result = false;
        if (booleans != null)
                result = true;
        return result;
    }
}
