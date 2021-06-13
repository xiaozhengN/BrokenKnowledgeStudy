package cn.urovo.blog.lesson9.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-01-10 14:22
 **/
@EnableScheduling
@Configuration
@ComponentScan({"cn.urovo.blog.lesson9.service"})
public class AopConfig1 {
}
