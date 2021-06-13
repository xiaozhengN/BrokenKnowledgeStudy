package cn.urovo.blog.lesson3;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2020-12-26 13:34
 **/
public class RealSubject implements Subject {

    @Override
    public void doSomething() {
        System.out.println("2020年12月26日13:35:21 : " + "RealSubject doSomething...");
    }

}
