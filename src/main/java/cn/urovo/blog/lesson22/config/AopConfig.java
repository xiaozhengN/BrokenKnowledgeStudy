package cn.urovo.blog.lesson22.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-01-31 22:22
 **/
@ComponentScan("cn.urovo.blog.lesson22.*")
@EnableAspectJAutoProxy
@Configuration
public class AopConfig {
}
