package cn.urovo.blog.lesson17;

/**
 * @program: blog
 * @description 双检索式
 * @author: zheng
 * @create: 2021-01-29 06:26
 **/
public class Singleton1 {

    /**
     * 1. 私有化构造器
     * 2. 本来的属性
     * 3. 对外提供共有的初始化方法
     *
     * 指令重排: new Singleton1();
     * 1. 分配内存空间
     * 2. 指向内存地址
     * 3. 初始化对象
     * 不同的编译器, 在2, 3两个会有差别, 虽然最后的结果都是一样的.
     */
    private static volatile Singleton1 instance = null;//防止指令重排, 利用volatile保证可见性

    private Singleton1() {}

    public static Singleton1 getInstance() {

        if (instance == null) {
            synchronized (Singleton1.class) {
                if (instance == null) {
                    instance = new Singleton1();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Singleton1.getInstance());
                }
            }).start();
        }
    }


}
