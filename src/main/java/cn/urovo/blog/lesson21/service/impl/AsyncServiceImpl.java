package cn.urovo.blog.lesson21.service.impl;

import cn.urovo.blog.lesson21.service.AsyncService;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-01-31 17:09
 **/
@Service
public class AsyncServiceImpl implements AsyncService {

    private static final Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);

    @SneakyThrows
    @Override
    @Async("asyncServiceExecutor")
    public void executeAsync() {
//        logger.info("start executeAsync");

//        System.out.println("异步线程要做的事情");
//        System.out.println("可以在这里执行批量插入等耗时的事情");
//        logger.info(Thread.currentThread().getName());
//        logger.info("end executeAsync");

    }

}
