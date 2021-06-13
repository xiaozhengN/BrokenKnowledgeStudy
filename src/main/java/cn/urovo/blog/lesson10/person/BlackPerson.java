package cn.urovo.blog.lesson10.person;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-01-10 14:45
 **/
@Order(0)
@Component
public class BlackPerson implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("BlackPerson....");
    }
}
