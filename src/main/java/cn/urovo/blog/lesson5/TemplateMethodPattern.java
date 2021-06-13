package cn.urovo.blog.lesson5;

/**
 * https://www.bilibili.com/video/BV1kk4y117j5?from=search&seid=1689330392127303954
 * @program: blog
 * @description 模板方法模式
 * @author: zheng
 * @create: 2020-12-26 16:38
 **/
public class TemplateMethodPattern {

    public static void main(String[] args) {

        CookingFood cookingFood = new CookingFood();
        cookingFood.cook();

    }

}

abstract class Cooking {

    protected abstract void step1();

    protected abstract void step2();

    public void cook() {
        System.out.println("2020年12月26日16:40:17 : " + "开始...");
        step1();
        step2();
        System.out.println("2020年12月26日16:40:27 : " + "结束...");
    }

}

class CookingFood extends Cooking {

    @Override
    protected void step1() {
        System.out.println("2020年12月26日16:41:43 : " + "放油...");
    }

    @Override
    protected void step2() {
        System.out.println("2020年12月26日16:41:55 : " + "放食物...");
    }

}

