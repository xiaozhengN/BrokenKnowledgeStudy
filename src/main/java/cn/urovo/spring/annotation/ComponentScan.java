package cn.urovo.spring.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description 包扫描注解
 * 模式Spring中包扫描注解.
 * @author: zWX1038562
 * @create: 2021-06-13 11:26
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ComponentScan {
    String value();
}
