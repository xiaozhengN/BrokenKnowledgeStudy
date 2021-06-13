package cn.urovo.blog.lesson15;

import java.io.*;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-01-26 11:10
 **/
public class serializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        output("E:\\aaa.txt");
        input("E:\\aaa.txt");
    }

    private static void output(String path) throws IOException {

        File file = new File(path);
        OutputStream op = new FileOutputStream(file);
        ObjectOutputStream ops = new ObjectOutputStream(op);
        ops.writeObject(new Demo("Chris", "12345"));
        ops.close();

    }

    private static void input(String path) throws IOException, ClassNotFoundException {

        InputStream in = new FileInputStream(path);
        ObjectInputStream os = new ObjectInputStream(in);
        Demo d = (Demo) os.readObject();
        System.out.println(d.getUserName()+ d.getPassWord());
        os.close();

    }
}
