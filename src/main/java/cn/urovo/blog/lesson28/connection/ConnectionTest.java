package cn.urovo.blog.lesson28.connection;

import org.I0Itec.zkclient.ZkClient;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-02-28 02:14
 **/
public class ConnectionTest {

    public static final String ZKSERVER = "47.115.53.135:2181";
    public static final int TIME_OUT = 60 * 1000;
    public static void main(String[] args) {
        ZkClient zkClient = new ZkClient(ZKSERVER, TIME_OUT);
        System.out.println(zkClient);

    }

}
