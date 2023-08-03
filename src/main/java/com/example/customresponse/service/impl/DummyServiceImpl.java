package com.example.customresponse.service.impl;

import com.example.customresponse.entity.DummyEntity;
import com.example.customresponse.service.DummyService;
import org.springframework.stereotype.Component;

@Component
public class DummyServiceImpl implements DummyService {
    @Override
    public DummyEntity doSomething() {
        return DummyEntity.builder()
                .id("1")
                .name("dummy")
                .build();
    }

    @Override
    public DummyEntity throwSomething() throws RuntimeException {
        throw new RuntimeException("dummy error");
    }
}
