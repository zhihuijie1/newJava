package p1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    public static void main(String[] args) throws IOException {
        // 1: 创建套接字：指定服务器的端口
        ServerSocket serverSocket = new ServerSocket(88);
        // 2: 等待客户端发来信息
        //    注意这是一个阻塞方法，等待接收客户端的数据，什么时候接收数据，什么时候继续往下执行。
        //    s() 返回值是一个Socket，这个socket就是客户端的socket.
        Socket s = serverSocket.accept();
        // 接收到socket以后，客户端与服务器才真正的建立了连接。才可以真正的通信。
        // 3: 建立流
        InputStream inputStream = s.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        // 4：读取客户端发来的数据
        String str = dataInputStream.readUTF();
        System.out.println("客户端发来的数据是： " + str);

        // 5:向客户端反馈一句话,实现双向通信。 ---> 利用输出流
        OutputStream outputStream = s.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF("服务器已收到");

        // 6：关闭流
        dataOutputStream.close();
        dataInputStream.close();
        s.close();
        serverSocket.close();
    }
}
