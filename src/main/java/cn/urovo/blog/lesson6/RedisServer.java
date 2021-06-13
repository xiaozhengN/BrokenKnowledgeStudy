package cn.urovo.blog.lesson6;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2020-12-27 16:11
 **/
public class RedisServer {

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        InputStream inputStream = null;//读取数据

        try {
            serverSocket = new ServerSocket(6379);
            Socket socket = serverSocket.accept();
            inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                String message = new String(bytes, 0, len);
                System.out.print(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                serverSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
