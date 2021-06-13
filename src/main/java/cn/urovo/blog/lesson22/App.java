package cn.urovo.blog.lesson22;

import cn.urovo.blog.lesson22.config.AopConfig;
import cn.urovo.blog.lesson22.service.DemoAnnotationService;
import cn.urovo.blog.lesson22.service.DemoMethodService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-01-31 21:49
 **/
public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);
        DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);

        demoAnnotationService.add();//基于注解的拦截
        demoMethodService.add();//给予方法规则的拦截
        context.close();
    }


}
