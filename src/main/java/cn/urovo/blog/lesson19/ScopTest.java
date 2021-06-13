package cn.urovo.blog.lesson19;

import cn.urovo.blog.lesson1.Book;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-01-31 11:31
 **/
public class ScopTest {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Bean-Lifecycle.xml");
        Book book1 = (Book) context.getBean("book");
        Book book2 = (Book) context.getBean("book");
        System.out.println(book1 == book2);

    }
}
