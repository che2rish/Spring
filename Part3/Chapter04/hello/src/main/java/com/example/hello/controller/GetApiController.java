package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    //http://localhost:8080/api/get/hello
    @GetMapping(path = "/hello") // path를 사용해서 명확하게 path 지정
    public String getHello(){
        return "get Hello";
    }

    //get http://localhost:8080/api/get/hi
    @RequestMapping(path = "/hi",method = RequestMethod.GET) // get/post/put/delete
    public String hi(){
        return "hi";
    }

    // http://localhost:8080/api/get/path-variable/{name}
    @GetMapping("/path-variable/{name}") // {name}은 변화하는 값
    public String pathVariable(@PathVariable String name){ // 보통 이름은 동일하게 하는데 만약 다르게 할 경우 (@PathVariable(name = "name")String pathName)
        System.out.println("PathVariable : " + name);
        return name;
    }

    // Query Parameter -> 검색을 할 때 여러가지 매개변수 인자 / key : value
    // http://localhost:8080/api/get/query-param?name=steve&email=steve@gmail.com&age=30
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String,String> queryParam){

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(entry ->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey()+" = "+ entry.getValue() + "\n");
        });

        return sb.toString();
    }

    @GetMapping("query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name + " " + email + " " + age;
    }

    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest){
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }

}
