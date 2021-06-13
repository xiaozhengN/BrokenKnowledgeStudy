package cn.urovo.blog.lesson15;

/**
 * @url https://www.cnblogs.com/pickKnow/p/9517687.html
 * @program: blog
 * @description 创建对象的几种方式
 * 1. new
 * 2. 反射
 * 3. 克隆
 * 4. 反序列化
 * @author: zheng
 * @create: 2021-01-26 10:58
 **/
public class create {


    public static void main(String[] args) {
        //通过 new 创建对象
        Student student = new Student();
    }

}

class Student {

    private String name;

    private Integer age;


    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
