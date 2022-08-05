package com.cos.controllerdemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller // File을 응답하는 컨트롤러(클라이언트가 브라우저면 .html파일을 응답)
@RestController // Data를 응답하는 컨트롤러 (클라이언트가 핸드폰이면 data)
public class HttpController {

    // http://localhost:8080/get
    @GetMapping("/get")
    public String get(){
        return "<h1>get요청됨</h1>";
    }

    @PostMapping("/post")
    public String post(){
        return "post요청됨";
    }

    @PutMapping("/put")
    public String put(){
        return "put요청됨";
    }

    @DeleteMapping("/delete")
    public String delete(){
        return "delete요청됨";
    }
}
