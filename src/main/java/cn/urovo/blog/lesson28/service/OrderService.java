package cn.urovo.blog.lesson28.service;

import cn.urovo.blog.lesson28.ZKDistributeLock;
import cn.urovo.blog.lesson28.ZKLock;
import cn.urovo.blog.lesson28.util.OrderNumberCreateUtil;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-02-27 23:55
 **/
public class OrderService {

    private OrderNumberCreateUtil orderNumberCreateUtil = new OrderNumberCreateUtil();

    ZKLock zkLock = new ZKDistributeLock();

    public void getOrderNumber() {

        zkLock.zkLock();
        try {
            System.out.println("----------->" + orderNumberCreateUtil.getOrderNumber());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            zkLock.zkUnLock();
        }



    }

}
