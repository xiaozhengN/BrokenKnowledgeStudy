package cn.urovo.spring;

import lombok.Data;

/**
 * @description Bean的定义对象
 * 模拟Spring中Bean的定义对象, 暂时只定义两个属性
 * @author: zWX1038562
 * @create: 2021-06-13 14:57
 **/
@Data
public class BeanDefinition {

    /**
     * bean的类型
     */
    private Class clazz;

    /**
     * bean的作用域
     */
    private String scope;

}
