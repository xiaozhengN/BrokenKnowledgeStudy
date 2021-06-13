package cn.urovo.blog.lesson1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: blog
 * @description Spring Bean作用域
 * @author: zheng
 * @create: 2020-12-26 09:07
 **/
public class SpringBeanLifecycleApplication {

    public static void main(String[] args) throws InterruptedException {
        // 为面试而准备的Bean生命周期加载过程
        ApplicationContext context = new ClassPathXmlApplicationContext("Bean-Lifecycle.xml");
        Book book = (Book)context.getBean("book");
        System.out.println("Book name = " + book.getBookName());

        ((ClassPathXmlApplicationContext) context).destroy();

    }

}
