package cn.urovo.blog.lesson14;

/**
 * @program: blog
 * @description 同时实现 Runnable 接口, 重新run方法, 完成新线程的创建.
 * @author: zheng
 * @create: 2021-01-26 09:59
 **/
public class RunnableTest implements Runnable {

    private int i;

    @Override
    public void run() {
        for (; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + " -- " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " -- " + i);
            if (i == 20) {
                RunnableTest runnableTest = new RunnableTest();
                new Thread(runnableTest, "线程1").start();
                new Thread(runnableTest, "线程2").start();
            }
        }
    }

}
