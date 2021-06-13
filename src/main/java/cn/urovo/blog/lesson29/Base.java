package cn.urovo.blog.lesson29;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-03-03 17:13
 **/
public class Base {

    public Base() {
        System.out.println("Base()");
    }

    public Base(int i) {
        System.out.println("Base(int i)");
    }
}

class MyOver extends Base {
    public MyOver(int i) {

    }

    public void MyOver(int i) {

    }

    public static void main(String[] args) {
        MyOver m = new MyOver(10);
    }
}