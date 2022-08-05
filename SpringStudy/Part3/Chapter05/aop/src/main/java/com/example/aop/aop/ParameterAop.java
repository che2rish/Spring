package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect // aop로 동작하기 위해서
@Component // spring에서 관리
public class ParameterAop {

    // com.example.aop.controller 하위에 있는 모든 메소드를 다 aop로 보겠다.
    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void cut(){}

    // 언제 실행 시킬 것인지
    @Before("cut()")
    public void before(JoinPoint joinPoint){

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());

        Object[] args = joinPoint.getArgs(); // 메소드에 들어가는 매개변수의 배열

        for(Object obj : args){
            System.out.println("type : "+ obj.getClass().getSimpleName());
            System.out.println("value : "+obj);
        }
    }

    // 어디서 반환할 것인지
    @AfterReturning(value = "cut()",returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj){
        System.out.println("return obj");
        System.out.println(returnObj);
    }
}
