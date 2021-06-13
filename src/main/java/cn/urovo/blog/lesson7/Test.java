package cn.urovo.blog.lesson7;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2020-12-27 17:48
 **/
public class Test {


    public int aMethod() {
//        static int i = 0;
        int i = 0;
        i++;
        return i;
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.aMethod();
        int j = test.aMethod();
        System.out.println(j);//1
    }
}
