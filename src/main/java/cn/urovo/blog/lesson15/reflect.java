package cn.urovo.blog.lesson15;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-01-26 11:02
 **/
public class reflect {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {

        //
        Demo demo = Demo.class.newInstance();

        Class<Demo> clazz = (Class<Demo>) Class.forName("Demo");
        Demo newInstance2 = clazz.newInstance();
        newInstance2.setPassWord("12345");
        newInstance2.setUserName("Sarah");
        System.out.println(newInstance2.getUserName()+ newInstance2.getPassWord());

        Class<Demo> clazz3 = (Class<Demo>) Class.forName("Demo");
        Constructor<Demo> con = clazz3.getDeclaredConstructor(String.class,String.class);
        Demo newInstance3 = con.newInstance("Mike","12345");
        newInstance3.setUserName("vincent");//可以通过反射是可以改变对象的值
        newInstance3.setPassWord("12345");
        System.out.println(newInstance3.getUserName()+ newInstance3.getPassWord());



    }


}
