package cn.urovo.blog.lesson28.controller;

import cn.urovo.blog.lesson28.service.OrderService;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-02-28 00:03
 **/
public class Client {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                new OrderService().getOrderNumber();
            }).start();
        }


    }
}
