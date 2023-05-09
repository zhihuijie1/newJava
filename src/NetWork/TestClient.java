package p1;

import java.io.*;
import java.net.Socket;

public class TestClient {
    public static void main(String[] args) throws IOException {
        // 1: 创建套接字，指定服务器的IP与端口号
        Socket s = new Socket("localhost",88);
        // 2: 向外发送数据，利用输出流。
        OutputStream outputStream = s.getOutputStream();
        // 由于OutputStream不可直接发送字符串，所以我们子啊其外面套了一个处理流。
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF("肝死你们，草泥马，滚，傻逼");
        // 3:接收服务器发来的反馈 --> 输入流
        InputStream inputStream = s.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        String str = dataInputStream.readUTF();
        System.out.println(str);
        // 4：关闭流 关闭网络资源。
        dataInputStream.close();
        dataOutputStream.close();
        s.close();
    }
}
