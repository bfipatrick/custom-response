package com.example.customresponse.controller;

import com.example.customresponse.entity.DummyEntity;
import com.example.customresponse.service.DummyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    public DummyEntity doSomething(){
        return dummyService.doSomething();
    }

    @GetMapping("/error")
    public DummyEntity throwSomething(){
        try {
            return dummyService.throwSomething();
        }catch (Exception e){
            log.error(e.toString());
            throw e;
        }
    }

    @GetMapping("/error-bind")
    public DummyEntity errorBind(@RequestParam(value = "data", required = true) Integer data){
        return dummyService.doSomething();
    }
}
