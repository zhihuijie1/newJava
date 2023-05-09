package p1;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TestClient1 {
    public static void main(String[] args) {
        // 1：创建套接字，指定服务器的IP与端口。
        Socket s = null;
        DataInputStream dataInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            s = new Socket("localhost", 88);
            // 2: 输入账号与密码。
            Scanner scanner = new Scanner(System.in);
            System.out.println("请录入您的账号：");
            String zhanghao = scanner.next();
            System.out.println("请录入您的密码：");
            String passward = scanner.next();
            // 将账号与密码封装成一个User类，方便数据的传输。
            User user = new User(zhanghao, passward);
            // 3：输出流
            OutputStream outputStream = s.getOutputStream();
            objectOutputStream = new ObjectOutputStream(outputStream); // 对象输出流
            objectOutputStream.writeObject(user);
            // 4: 接收服务器传来的反馈 -- 输入流
            InputStream inputStream = s.getInputStream();
            dataInputStream = new DataInputStream(inputStream);
            Boolean str = dataInputStream.readBoolean();
            if (str) {
                System.out.println("客户端收到服务器的反馈：" + "账号密码正确");
            } else {
                System.out.println("客户端收到服务器的反馈：" + "账号密码错误");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 5：关闭流
            try {
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (s != null) {
                    s.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
