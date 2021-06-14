package cn.urovo.zhouyu;

import cn.urovo.spring.AppConfig;
import cn.urovo.spring.ZhouyuApplicationContext;
import cn.urovo.zhouyu.service.UserService;

/**
 * @author: zWX1038562
 * @create: 2021-06-13 11:16
 **/
public class Test {

    public static void main(String[] args) throws Exception {
        ZhouyuApplicationContext zhouyuApplicationContext = new ZhouyuApplicationContext(AppConfig.class);
        UserService bean = (UserService) zhouyuApplicationContext.getBean("userService");
        bean.test();
    }
}
