package cn.urovo.blog.lesson2;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2020-12-26 10:06
 **/
public class SingletonBean {
    private String message;
    public void setMessage(String message){
        this.message  = message;
    }
    public void getMessage(){
        System.out.println("Your Message : " + message);
    }
}
