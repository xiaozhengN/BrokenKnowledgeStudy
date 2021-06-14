package cn.urovo.zhouyu.service;

import cn.urovo.spring.BeanNameAware;
import cn.urovo.spring.InitializingBean;
import cn.urovo.spring.annotation.Autowired;
import cn.urovo.spring.annotation.Component;
import lombok.Setter;

/**
 * @author: zWX1038562
 * @create: 2021-06-13 11:30
 **/
@Component("userService")
//@Scope("prototype")
public class UserServiceImpl implements UserService, BeanNameAware, InitializingBean {

    @Autowired
    private OrderService orderService;

    private String beanName;

    @Setter
    private String name;

    @Override
    public void setBeanName(String name) {
        beanName = name;
    }

    public void test() {
        System.out.println(orderService);
        System.out.println(beanName);
        System.out.println(name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化...");
    }
}
