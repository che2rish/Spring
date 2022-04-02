package com.example.ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class IocApplication {

	public static void main(String[] args) {
		SpringApplication.run(IocApplication.class, args);
		ApplicationContext context = ApplicationContextProvider.getContext();

//		Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
//		UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);
//
//		Encoder encoder = new Encoder(base64Encoder);
//		String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";
//
//		String result = encoder.encode(url);
//		System.out.println(result);
//
//		encoder.setIEncoder(urlEncoder);
//		result = encoder.encode(url);
//		System.out.println(result);

//		Encoder encoder = context.getBean(Encoder.class);
//		String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";
//		String result = encoder.encode(url);
//		System.out.println(result);

		Encoder encoder = context.getBean("urlEncode",Encoder.class);
		String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";
		String result = encoder.encode(url);
		System.out.println(result);

	}

}

// @Component를 사용하지 않고
@Configuration // 한개의 클래스에서 여러개의 빈을 등록
class AppConfig{

	@Bean("base64Encode")
	public Encoder encoder(Base64Encoder base64Encoder){
		return new Encoder(base64Encoder);
	}

	@Bean("urlEncode")
	public Encoder encoder(UrlEncoder urlEncoder){
		return new Encoder(urlEncoder);
	}
}
