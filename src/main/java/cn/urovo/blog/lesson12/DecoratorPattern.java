package cn.urovo.blog.lesson12;

/**
 * @url https://www.bilibili.com/video/BV1hp4y1D7MP?from=search&seid=15092246480122064394
 * @program: blog
 * @description 装饰器模式
 * @author: zheng
 * @create: 2021-01-21 05:25
 **/
public class DecoratorPattern {

    public static void main(String[] args) {
        //通过装饰器自己实现的第二代机器人
        new RobotDecorator(new FirstRobot()).doMoreThings();
    }

}

interface Robot {
    void doSomeThing();
}

class FirstRobot implements Robot {

    @Override
    public void doSomeThing() {
        System.out.println("对话");
        System.out.println("唱歌");
    }
}

class SecondRobot implements Robot {
    @Override
    public void doSomeThing() {
        System.out.println("对话");
        System.out.println("唱歌");
        System.out.println("扫地");
        System.out.println("跳舞");
    }
}

class RobotDecorator implements Robot {

    private Robot robot;

    public RobotDecorator(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void doSomeThing() {
        robot.doSomeThing();
    }

    public void doMoreThings() {
        robot.doSomeThing();
        System.out.println("扫地, 跳舞");
    }


}