package p3;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

// 数据包发送方
public class Sender {
    // 1：创建套接字
    DatagramSocket socket;

    // 构造器
    public Sender(int port) throws SocketException {
        socket = new DatagramSocket(port); // 注意这里的端口是发送方自己的端口。
    }

    public void start() throws IOException {
        System.out.println("发送方老子上线了");
        // 2: 创建数据包
        // 四个参数
        // 1：byte[]数组
        // 2：数组的长度
        // 3：接收方的IP
        // 4：接收方的port号
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String str = scanner.next();
            byte[] bytes = str.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("localhost"), 9999);

            // 3：发送数据
            socket.send(datagramPacket);
            if(str.equals("再见")) {
                break;
            }

            // 4:接收数据
            // 空数据包用来存放接收的数据。
            byte[] bytes1 = new byte[1024];
            DatagramPacket datagramPacket1 = new DatagramPacket(bytes1, bytes1.length);
            // 接收数据并将其存放在空数据包中。
            socket.receive(datagramPacket1);
            // 将数据包中的数据提取出来。
            String str2 = new String(datagramPacket1.getData(), 0, datagramPacket1.getLength());
            System.out.println(str2);

        }

        // 5：关闭资源
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        Sender sender = new Sender(8888);
        sender.start();
    }
}
