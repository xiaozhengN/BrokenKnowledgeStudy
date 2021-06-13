package cn.urovo.blog.lesson28;

import org.I0Itec.zkclient.ZkClient;
import java.util.concurrent.CountDownLatch;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-02-27 23:13
 **/
public abstract class ZKAbstractTemplateLock implements ZKLock{

    public static final String ZKSERVER = "47.115.53.135:2181";
    public static final int TIME_OUT = 60 * 1000;
    ZkClient zkClient = new ZkClient(ZKSERVER, TIME_OUT);
    protected String path = "/zklock0401";

    public CountDownLatch countDownLatch = null;

    public abstract void waitZkLock();
    public abstract boolean tryZkLock();

    @Override
    public void zkLock() {
        // 利用zk 创建临时节点
        if (tryZkLock()) {
            System.out.println(Thread.currentThread().getName() + "\t " + "占用锁成功...");
        } else {
            waitZkLock();
            zkLock();
        }

    }

    @Override
    public void zkUnLock() {

        // 等待, 临时节点被删除
        if (zkClient != null) {
            zkClient.close();
        }

        System.out.println(Thread.currentThread().getName() + "\t " + "释放锁成功...");

        System.out.println();
        System.out.println();

    }

}
