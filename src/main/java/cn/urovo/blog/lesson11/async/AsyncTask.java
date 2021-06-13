package cn.urovo.blog.lesson11.async;

import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @url https://segmentfault.com/a/1190000010142962
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-01-10 15:46
 **/
@Component
@Slf4j
@EnableAsync
public class AsyncTask {

    @Async
    public void dealNoReturnTask(){
        log.info("Thread {} deal No Return Task start", Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Thread {} deal No Return Task end at {}", Thread.currentThread().getName(), System.currentTimeMillis());
    }

    @Async
    public Future<String> dealHaveReturnTask() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("thread", Thread.currentThread().getName());
        jsonObject.put("time", System.currentTimeMillis());
        return new AsyncResult<String>(jsonObject.toJSONString());
    }

}
