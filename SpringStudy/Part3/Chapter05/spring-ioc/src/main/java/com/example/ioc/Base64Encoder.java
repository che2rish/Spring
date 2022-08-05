package com.example.ioc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Base64;

// @Component("") -> 다른 이름으로 불러오고 싶을 때 이름 설정
@Component
public class Base64Encoder implements IEncoder {

    public String encode(String message){
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}
