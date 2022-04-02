package com.example.ioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class Encoder {

    private IEncoder iEncoder;

    // @Qualifier() -> 어떤 거를 매칭해야하는지 지정
//    public Encoder(@Qualifier("base64Encoder") IEncoder iEncoder){
//       this.iEncoder = iEncoder;
//    }

    public Encoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }

    public void setIEncoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }

    public String encode(String message){
        return iEncoder.encode(message);
    }
}
