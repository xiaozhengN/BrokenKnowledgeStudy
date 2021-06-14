package cn.urovo.spring;

/**
 * @description
 * @author: zWX1038562
 * @create: 2021-06-14 16:58
 **/
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName);

    Object postProcessAfterInitialization(Object bean, String beanName);

}
