package cn.urovo.blog.lesson25;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-02-27 17:20
 **/
public class HelloVolatile {

    volatile boolean running = true;

    void m() {

        System.out.println("m start...");
        while (running) {

        }
        System.out.println("m end...");

    }

    public static void main(String[] args) throws InterruptedException {
        HelloVolatile helloVolatile = new HelloVolatile();

        new Thread(helloVolatile::m, "t1").start();

        Thread.sleep(1000);

        helloVolatile.running = false;
    }
}
