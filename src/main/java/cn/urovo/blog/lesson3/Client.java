package cn.urovo.blog.lesson3;

import org.aopalliance.intercept.Invocation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2020-12-26 13:43
 **/
public class Client {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", true);
        Subject subject = new JDKDynamicProxy(new RealSubject()).getProxy();
        subject.doSomething();

//        Subject rs = new RealSubject();
//        InvocationHandler jdkDynamicProxy = new JDKDynamicProxy(rs);
//
//        Class<? extends Subject> cls = rs.getClass();
//
//        Subject subject1 = (Subject) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), jdkDynamicProxy);
//
//        System.out.println("2020年12月26日14:17:27 : " + (subject1 instanceof Proxy));
//
//        //这里可以看出subject的Class类是$Proxy0,这个$Proxy0类继承了Proxy，实现了Subject接口
//        System.out.println("subject的Class类是："+subject1.getClass().toString());
//        System.out.print("subject中的属性有：");
//        Field[] field=subject1.getClass().getDeclaredFields();
//        for(Field f:field){
//            System.out.print(f.getName()+", ");
//        }
//        System.out.print("\n"+"subject1中的方法有：");
//        Method[] method=subject1.getClass().getDeclaredMethods();
//        for(Method m:method){
//            System.out.print(m.getName()+", ");
//        }
//
//        System.out.println("\n"+"subject1的父类是："+subject1.getClass().getSuperclass());
//        System.out.print("\n"+"subject1实现的接口是：");
//        Class<?>[] interfaces=subject1.getClass().getInterfaces();
//        for(Class<?> i:interfaces){
//            System.out.print(i.getName()+", ");
//        }
//        System.out.println("\n\n"+"运行结果为：");
//        subject1.doSomething();


    }
}
