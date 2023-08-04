package com.example.customresponse.utls;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ApiUtils {
    private ApiUtils(){}
    public static ResponseEntity<Object> generateErrorResponse(HttpStatus status, String code, String message) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("message", message);
        return new ResponseEntity<>(map,status);
    }

    public static ResponseEntity<Object> generateResponse(HttpStatus status, Object responseObj) {
        return new ResponseEntity<>(responseObj, status);
    }
}
