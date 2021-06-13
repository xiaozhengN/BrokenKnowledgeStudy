package cn.urovo.blog.lesson17;

/**
 * @program: blog
 * @description ThreadLocal的单例模式
 * @author: zheng
 * @create: 2021-01-29 07:02
 **/
public class Singleton2 {

    private static Singleton2 instance = null;

    private Singleton2() {
    };

    private static final ThreadLocal<Singleton2> threadLocalSingleton = new ThreadLocal<Singleton2>() {
        @Override
        protected Singleton2 initialValue() {
            return new Singleton2();
        }
    };

    public static Singleton2 getInstance() {
        return threadLocalSingleton.get();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    Singleton2 instance1 = Singleton2.getInstance();
                    Singleton2 instance2 = Singleton2.getInstance();
                    System.out.println(Thread.currentThread().getName() + "--" + (instance1 == instance2) + "--" + instance1);
                }
            }).start();

        }
    }


}
