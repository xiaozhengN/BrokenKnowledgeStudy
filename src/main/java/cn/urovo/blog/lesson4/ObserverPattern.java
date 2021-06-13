package cn.urovo.blog.lesson4;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.bilibili.com/video/BV1vg4y1v7V4?from=search&seid=8457399807692796304
 *
 * @program: blog
 * @description 观察者模式
 * @author: zheng
 * @create: 2020-12-26 16:08
 **/
public class ObserverPattern {

    public static void main(String[] args) {
        ZhangSan zhangSan = new ZhangSan();
        zhangSan.borrow(new Zhaoliu());
        zhangSan.borrow(new Wangwu());

        if (zhangSan.getState() == 1) {
            zhangSan.notifyCredits();
        }

    }

}

interface Debit {

    void borrow(Credit credit);
    void notifyCredits();

}

interface Credit {

    void takeMoney();

}

class ZhangSan implements Debit{

    private List<Credit> allCredits = new ArrayList<>();
    private Integer state = 1;//1 表示有钱

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public void borrow(Credit credit) {
        allCredits.add(credit);
    }

    @Override
    public void notifyCredits() {
        allCredits.forEach(credit -> credit.takeMoney());
    }
}

class Wangwu implements Credit {

    @Override
    public void takeMoney() {
        System.out.println("Wangwu : " + "已收账完成...");
    }
}

class Zhaoliu implements Credit {

    @Override
    public void takeMoney() {
        System.out.println("Zhaoliu : " + "已收账完成...");
    }
}

