package cn.urovo.zhouyu.service;

import cn.urovo.spring.BeanPostProcessor;
import cn.urovo.spring.annotation.Component;

import java.lang.reflect.Proxy;

/**
 * @description
 * @author: zWX1038562
 * @create: 2021-06-14 17:00
 **/
@Component("zhouyuBeanPostProcessor")
public class ZhouyuBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("初始化前...");
        if ("userService".equals(beanName)) {
            ((UserServiceImpl) bean).setName("周瑜好帅");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("初始化后");
        if ("userService".equals(beanName)) {
            Object proxyInstance = Proxy.newProxyInstance(ZhouyuBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), (proxy, method, args) -> {
                System.out.println("执行代理逻辑");
                return method.invoke(bean, args);
            });
            return proxyInstance;
        }
        return bean;
    }

}
