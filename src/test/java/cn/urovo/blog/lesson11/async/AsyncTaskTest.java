package cn.urovo.blog.lesson11.async;

import cn.urovo.blog.BlogApplication;
import cn.urovo.blog.lesson11.config.AsyncConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-01-10 15:47
 **/
@SpringBootTest(classes = AsyncTask.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
class AsyncTaskTest {

    @Autowired
    private AsyncTask asyncTask;

    @Test
    void dealNoReturnTask() {
        asyncTask.dealNoReturnTask();
        try {
            log.info("begin to deal other Task!");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void dealHaveReturnTask() throws InterruptedException, ExecutionException {

        Future<String> future = asyncTask.dealHaveReturnTask();
        log.info("begin to deal other Task!");
        while (true) {
            if (future.isCancelled()) {
                log.info("deal async task is Cancelled");
                break;
            }
            if (future.isDone()) {
                log.info("deal async task is Done");
                log.info("return result is " + future.get());
                break;
            }
            log.info("wait async task to end ...");
            Thread.sleep(1000);
        }

    }
}