package com.example.customresponse.service;

import com.example.customresponse.entity.DummyEntity;
import org.springframework.stereotype.Service;

@Service
public interface DummyService {
    DummyEntity doSomething();
    DummyEntity throwSomething() throws RuntimeException;
}
