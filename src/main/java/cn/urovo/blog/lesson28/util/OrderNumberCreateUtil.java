package cn.urovo.blog.lesson28.util;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-02-27 23:52
 **/
public class OrderNumberCreateUtil {

    private static int number = 0;

    public String getOrderNumber() {
        return "生成的订单号" + (++number);
    }

}
