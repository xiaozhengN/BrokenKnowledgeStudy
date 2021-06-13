package cn.urovo.blog.lesson25;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-02-27 17:05
 **/
public class VisibilityTest {

    private static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {

        changeFlag();

        System.out.println(flag);

        Thread.sleep(1000);

        System.out.println(flag);

        while (flag) {

        }

        System.out.println("end....");

    }

    private static void changeFlag() {
        new Thread(() -> {
            flag = false;
        }).start();
    }

}
