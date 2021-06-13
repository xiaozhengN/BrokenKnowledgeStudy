package cn.urovo.blog.lesson21.controller;

import cn.urovo.blog.lesson21.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-01-31 17:11
 **/
@RestController
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/async")
    public void async(){
        asyncService.executeAsync();
    }

}
