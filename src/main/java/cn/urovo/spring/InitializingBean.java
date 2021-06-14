package cn.urovo.spring;

/**
 * @description        InitializingBean接口
 * 模拟Spring中 InitializingBean接口
 * @author: zWX1038562
 *
 * @create: 2021-06-14 16:40
 **/
public interface InitializingBean {
    void afterPropertiesSet() throws Exception;
}
