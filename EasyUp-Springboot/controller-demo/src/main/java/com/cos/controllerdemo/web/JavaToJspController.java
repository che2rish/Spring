package com.cos.controllerdemo.web;

import com.cos.controllerdemo.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JavaToJspController {

    @GetMapping("/jsp/java")
    public String jspToJava(){
        return "d";
    }

    @GetMapping("/jsp/java/model")
    public String jspToJavaToModel(Model model){ // 함수의 파라미터에 Model을 선언하고
        User user = new User();
        user.setUsername("ssar");

        // HashMap 자료구조
        model.addAttribute("username",user.getUsername()); // addAttribute 함수로 전달만 하면 됨.

        return "e";
    }
}
