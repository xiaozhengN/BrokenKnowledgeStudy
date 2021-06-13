package cn.urovo.blog.lesson10.test;

import cn.urovo.blog.lesson10.config.AopConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-01-10 14:49
 **/
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
    }
}
