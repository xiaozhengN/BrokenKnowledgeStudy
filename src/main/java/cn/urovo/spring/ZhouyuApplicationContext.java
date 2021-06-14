package cn.urovo.spring;

import cn.urovo.spring.annotation.Autowired;
import cn.urovo.spring.annotation.Component;
import cn.urovo.spring.annotation.ComponentScan;
import cn.urovo.spring.annotation.Scope;
import cn.urovo.spring.exception.BeanException;
import org.springframework.util.ObjectUtils;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description 核心容器
 * 模拟Spring中: AnnotationConfigApplicationContext/ClassPathXmlApplicationContext
 * @author: zWX1038562
 * @create: 2021-06-13 11:16
 **/
public class ZhouyuApplicationContext {

    private Class configClass;

    /**
     * 单例池
     */
    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();

    /**
     * 存放类的定定义
     */
    private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    private List<BeanPostProcessor> beanPostProcessorList = new ArrayList<>();

    public ZhouyuApplicationContext(Class configClass) throws Exception {
        this.configClass = configClass;
        /*
         * 解析配置类
         * Component注解 -> 扫描路径 -> 扫描 -> BeanDefinition -> BeanDefinitionMap
         */
        scan(configClass);
        for (Map.Entry<String, BeanDefinition> entry : beanDefinitionMap.entrySet()) {
            String beanName = entry.getKey();
            BeanDefinition beanDefinition = entry.getValue();
            if ("singleton".equals(beanDefinition.getScope())) {
                Object bean = createBean(beanName, beanDefinition);
                singletonObjects.put(beanName, bean);
            }
        }

    }

    /**
     * 创建Bean对线
     *
     * @param beanName       bean的名字
     * @param beanDefinition Bean对象的定义
     * @return
     */
    private Object createBean(String beanName, BeanDefinition beanDefinition) throws Exception {
        Class clazz = beanDefinition.getClazz();
        Object instance = clazz.getDeclaredConstructor().newInstance();
        /*
         * 依赖注入:
         * 从容器中拿一个bean对象, 赋值给属性, 实现依赖注入
         */
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Autowired.class)) {
                Object bean = getBean(field.getName());
                if (ObjectUtils.isEmpty(bean)) {
                    throw new BeanException("容器中不存在这个bean: " + bean.getClass());
                }
                field.setAccessible(true);
                field.set(instance, bean);
            }
        }
        // Aware 回调
        if (instance instanceof BeanNameAware) {
            ((BeanNameAware) instance).setBeanName(beanName);
        }
        // 后置处理器: 初始化之前执行
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
            instance = beanPostProcessor.postProcessBeforeInitialization(instance, beanName);
        }
        // 初始化
        if (instance instanceof InitializingBean) {
            ((InitializingBean) instance).afterPropertiesSet();
        }
        // 后置处理器: 初始化之后执行
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
            instance = beanPostProcessor.postProcessAfterInitialization(instance, beanName);
        }
        return instance;
    }

    private void scan(Class configClass) throws Exception {
        ComponentScan componentScanAnnotation = (ComponentScan) configClass.getDeclaredAnnotation(ComponentScan.class);
        String path = componentScanAnnotation.value();
        /*
         * Bootstrap ---> jre/lib
         * Ext ---------> jre/ext/lib
         * App ---------> classpath
         */
        ClassLoader classLoader = ZhouyuApplicationContext.class.getClassLoader();
        URL resource = classLoader.getResource("cn/urovo/zhouyu/service");
        File file = new File(resource.getFile());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                String fileName = f.getAbsolutePath();
                if (fileName.endsWith(".class")) {
                    String className = fileName.substring(fileName.indexOf("cn"), fileName.indexOf(".class")).replace("\\", ".");
                    Class<?> clazz = classLoader.loadClass(className);
                    if (clazz.isAnnotationPresent(Component.class)) {
                        BeanDefinition beanDefinition = new BeanDefinition();
                        // 表示当前类是一个Bean
                        // 创建 Class -> Bean?
                        // 解析类 --> BeanDefinition
                        Component componentAnnotation = clazz.getDeclaredAnnotation(Component.class);
                        String beanName = componentAnnotation.value();
                        beanDefinition.setClazz(clazz);
                        if (clazz.isAnnotationPresent(Scope.class)) {
                            Scope scopeAnnotation = clazz.getDeclaredAnnotation(Scope.class);
                            beanDefinition.setScope(scopeAnnotation.value());
                        } else {
                            beanDefinition.setScope("singleton");
                        }
                        beanDefinitionMap.put(beanName, beanDefinition);
                        if (BeanPostProcessor.class.isAssignableFrom(clazz)) {
                            BeanPostProcessor bean = (BeanPostProcessor) createBean("zhouyuBeanPostProcessor", beanDefinitionMap.get("zhouyuBeanPostProcessor"));
                            beanPostProcessorList.add(bean);
                        }
                    }
                }
            }
        }
    }

    /**
     * 获取Bean对象
     *
     * @param beanName
     * @return
     */
    public Object getBean(String beanName) throws Exception {
        if (beanDefinitionMap.containsKey(beanName)) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if ("singleton".equals(beanDefinition.getScope())) {
                return singletonObjects.get(beanName);
            } else {
                return createBean(beanName, beanDefinition);
            }
        } else {
            throw new BeanException("不存在对应的 Bean");
        }
    }
}
