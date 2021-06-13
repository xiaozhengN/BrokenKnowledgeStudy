package cn.urovo.blog.lesson2;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2020-12-26 10:07
 **/
public class TestBean {

    @Test
    public void testUser () {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
        SingletonBean singletonBean1 = (SingletonBean) context.getBean("SingletonBean");
        SingletonBean singletonBean2 = (SingletonBean) context.getBean("SingletonBean");
        System.out.println("2020年12月26日10:11:33 : " + (singletonBean1 == singletonBean2));

    }
}
