package cn.urovo.blog.lesson17;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-01-29 06:34
 **/
class Singleton1Test {

    @Test
    void getInstance() {
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