package cn.urovo.blog.lesson15;

import java.io.Serializable;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-01-26 11:02
 **/
public class Demo implements Serializable {

    private String userName;

    private String passWord;

    public Demo(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public Demo() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
