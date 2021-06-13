package cn.urovo.blog.lesson22.aop;

import cn.urovo.blog.lesson22.annotation.Action;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-01-31 21:55
 **/
@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(cn.urovo.blog.lesson22.annotation.Action)")
    public void annotationPointCut() {
        System.out.println("annotationPointCut...");
    }

    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
        for (Annotation annotation : declaredAnnotations) {
            if (annotation instanceof Action) {
                System.out.println(((Action) annotation).name());
            }
        }
    }

    @Before("execution(* cn.urovo.blog.lesson22.service.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println(method.getName());
    }


}
