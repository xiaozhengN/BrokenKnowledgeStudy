package cn.urovo.blog.lesson27;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-02-27 18:01
 **/
public class SynchronizeTest {

    public static void main(String[] args) {
        synchronized (SynchronizeTest.class) {
            int a = 1;
        }
    }
}
