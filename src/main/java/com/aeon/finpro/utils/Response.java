package com.aeon.finpro.utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Response {

    public Boolean isRequired(Object obj){
        return obj == null;
    }

    public Map<String, Object> resSuccess(Object data, String message, Integer statusCode) {
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("message", message);
        res.put("status_code", statusCode);
        return res;
    }

    public Map<String, Object> clientError(Object message) {
        Map<String, Object> res = new HashMap<>();
        res.put("message", message);
        res.put("status_code", 400);
        return res;
    }

    public Map<String, Object> internalServerError(Object message) {
        Map<String, Object> res = new HashMap<>();
        res.put("message", message);
        res.put("status", 500);
        return res;
    }

    public Map<String, Object> notFoundError(Object message ) {
        Map<String, Object> res = new HashMap<>();
        res.put("message", message);
        res.put("status", 404);
        return res;
    }
}

