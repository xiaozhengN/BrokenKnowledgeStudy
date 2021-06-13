package cn.urovo.blog.lesson10.person;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-01-10 14:44
 **/
@Order(1)
@Component
public class YellowPerson implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("YellowPerson...");
    }
}
