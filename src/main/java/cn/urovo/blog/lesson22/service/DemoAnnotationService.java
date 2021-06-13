package cn.urovo.blog.lesson22.service;

import cn.urovo.blog.lesson22.annotation.Action;
import org.springframework.stereotype.Service;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-01-31 21:51
 **/
@Service
public class DemoAnnotationService {

    @Action(name = "注解式拦截的add操作")
    public void add() {
        System.out.println("DemoAnnotationService.add()...");
    }

}
