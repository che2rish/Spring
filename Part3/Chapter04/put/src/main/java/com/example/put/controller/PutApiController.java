package com.example.put.controller;

import com.example.put.dto.PostRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put")
    public PostRequestDto put(@RequestBody PostRequestDto requestDto){
        System.out.println(requestDto);
        return requestDto;
    }

    @PutMapping("/put/{userId}")
    public PostRequestDto put(@RequestBody PostRequestDto requestDto, @PathVariable(name = "userId") long id){
        System.out.println(id);
        return requestDto;
    }
}
