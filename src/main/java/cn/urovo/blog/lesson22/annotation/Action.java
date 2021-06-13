package cn.urovo.blog.lesson22.annotation;

import java.lang.annotation.*;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-01-31 21:49
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}
