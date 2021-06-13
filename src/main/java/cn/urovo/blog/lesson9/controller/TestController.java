package cn.urovo.blog.lesson9.controller;

import cn.urovo.blog.lesson9.config.AopConfig1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @url https://blog.csdn.net/rocling/article/details/81490411
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-01-10 14:25
 **/
public class TestController {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig1.class);

    }
}
