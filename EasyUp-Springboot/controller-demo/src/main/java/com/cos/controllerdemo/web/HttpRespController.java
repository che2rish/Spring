package com.cos.controllerdemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 파일을 리턴할 것이기 때문!!
public class HttpRespController {

    @GetMapping("/txt")
    public String txt(){
        // 프레임워크 사용 (틀이 이미 정해져 있음) - 일반 정적 파일들은 resource/static 폴더 내부가 디폴트 경로이다.
        return "a.txt";
    }

    @GetMapping("/mus")
    public String mus(){
        // mustache 템플릿 엔진 라이브러리 등록 완료 -> ViewResolver설정이 자동으로 되어있음
        //  - templates 폴더 안에 .mustache을 나두면 확장자 없이 파일명만 적으면 자동으로 찾아감.
        return "b";
    }

    @GetMapping("/jsp")
    public String jsp(){
        // jsp 엔진 사용 : src/main/webapp 폴더가 디폴트 경로!!
        // WEB-INF/views/c.jsp (ViewResolver)
        return "c";
    }

}
