package cn.urovo.blog.lesson28;

import lombok.SneakyThrows;
import org.I0Itec.zkclient.IZkDataListener;

import java.util.concurrent.CountDownLatch;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-02-28 00:53
 **/
public class ZKDistributeLock extends ZKAbstractTemplateLock{


    @SneakyThrows
    @Override
    public void waitZkLock() {

        IZkDataListener iZkDataListener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String s) throws Exception {

                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }

            }
        };
        zkClient.subscribeDataChanges(path, iZkDataListener);

        if (zkClient.exists(path)) {
            //只能等着
            countDownLatch = new CountDownLatch(1);
            countDownLatch.await();
        }

    }

    @Override
    public boolean tryZkLock() {

        try {
            zkClient.createEphemeral(path);
           return true;
        } catch (Exception e) {
            return false;
        }

    }
}
