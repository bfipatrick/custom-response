package com.example.customresponse.controller;

import com.example.customresponse.entity.DummyEntity;
import com.example.customresponse.service.DummyService;
import com.example.customresponse.utls.ApiUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("custom")
@Slf4j
public class DummyController {
    @Autowired
    DummyService dummyService;

    @GetMapping("/ok")
    public ResponseEntity<Object> doSomething(){
        return ApiUtils.generateResponse(HttpStatus.OK, dummyService.doSomething());
    }

    @GetMapping("/error")
    public ResponseEntity<Object> throwSomething(){
        try {
            return ApiUtils.generateResponse(HttpStatus.OK, dummyService.throwSomething());
        }catch (Exception e){
            log.error(e.toString());
            return ApiUtils.generateErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,
                    HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                    HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        }
    }

    @GetMapping("/error-bind")
    public DummyEntity errorBind(@RequestParam(value = "data", required = true) Integer data){
        return dummyService.doSomething();
    }
}
