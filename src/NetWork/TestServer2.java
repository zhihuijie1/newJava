package p1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer2 {
    public static void main(String[] args) {
        // 1:创建套接字，指定服务器的端口；
        ServerSocket serverSocket = null;
        Socket s = null;
        ObjectInputStream objectInputStream = null;
        DataOutputStream dataOutputStream = null;
        try {
            serverSocket = new ServerSocket(88);
            // 2: 创建accept方法，等待客户端发来数据。
            s = serverSocket.accept(); // 注意这个socket就是客户端的。
            // 与客户端真正的建立连接。
            // 3：创建流 -- 输入流。
            InputStream inputStream = s.getInputStream();
            objectInputStream = new ObjectInputStream(inputStream);
            User user = (User) (objectInputStream.readObject());
            // 进行数据的比对
            Boolean flag = false;
            if (user.name.equals("肝死你们，草泥马") && user.password.equals("123456")) {
                flag = true;
            }
            // 4:进行数据的反馈 -- 输出流
            OutputStream outputStream = s.getOutputStream();
            dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeBoolean(flag);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5: 关闭流,与网络资源。
            try {
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
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