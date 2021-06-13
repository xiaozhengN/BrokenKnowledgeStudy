package cn.urovo.blog.lesson14;

/**
 * @url https://www.cnblogs.com/lingz/p/9692545.html
 * @program: blog
 * @description 通过集成 Thread 类, 完成线程的创建
 * @author: zheng
 * @create: 2021-01-26 09:54
 **/
public class ThreadTest extends Thread {

    private int i = 0;

    @Override
    public void run() {
        for (; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + " is running " + i);
        }
    }

    public static void main(String[] args) {
        for (int j = 0; j < 50; j++) {
            if (j == 20) {
                new ThreadTest().start();
                new ThreadTest().start();
            }
        }
    }
}
