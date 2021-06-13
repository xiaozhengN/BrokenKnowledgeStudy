package cn.urovo.blog.lesson13;
import java.util.HashMap;
import java.util.Map;

/**
 * @url https://www.cnblogs.com/huangting/p/11220756.html
 * @program: blog
 * @description 缓存的简单模型
 * @author: zheng
 * @create: 2021-01-26 08:53
 **/
public class EhcacheDemo {

    static Map<Object, Object> cache = new HashMap<>();

    static Object getValue (String key) {

        Object value = cache.get(key);
        System.out.println("从缓存获取数据...");

        if (value == null) {
            System.out.println("从配置文件中获取数据...");
            cache.put(key, new String[] {"zs"});
            return cache.get(key);
        }
        return value;

    }
    
    public static void main(String[] args) {
        System.out.println(getValue("zs"));
        System.out.println(getValue("zs"));
    }
}
