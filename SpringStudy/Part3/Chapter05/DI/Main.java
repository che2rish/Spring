package com.company.ioc;

public class Main {

    public static void main(String[] args) {
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        // DI -> 외부에서 주입
        Encoder encoder = new Encoder(new Base64Encoder()); // 이 부분만 바꿔주면 encoding방식을 바꿀 수 있음
        String result = encoder.encode(url);
        System.out.println(result);

        //Base 64 encoding
        IEncoder base64Encoder = new Base64Encoder();
        String Base64result = base64Encoder.encode(url);
        System.out.println(Base64result);

        // url encoding
        IEncoder urlEncoder = new UrlEncoder();
        String urlResult = urlEncoder.encode(url);
        System.out.println(urlResult);

    }
}
