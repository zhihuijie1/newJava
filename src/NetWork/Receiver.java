package p3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Receiver {
    // 1:创建套接字
    DatagramSocket socket;

    // 构造器
    public Receiver(int port) throws SocketException {
        this.socket = new DatagramSocket(port); // 指定的是接收方自己的端口。
    }

    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // 2:创建一个空的数据包，用来接收发送方的数据。
            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
            // 3：接收对方的数据包，然后放入我们的数据包中。
            socket.receive(datagramPacket);
            // 4:取出数据
            //   参数：数据包中的数据byte[]，有效长度：[ 0 , datagramPacket.getLength() )
            String str = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
            System.out.println("学生对我说：->" + str);
            if(str.equals("再见")) {
                System.out.println("学生已经下线，我也下线");
                break;
            }

            // 5:回复数据
            String str2 = scanner.next();
            byte[] bytes2 = str2.getBytes(); // string -> byte
            // 待发送的数据包指定了要发送的数据，数据长度，接受区的IP与端口号。
            DatagramPacket datagramPacket2 = new DatagramPacket(bytes2, bytes2.length, InetAddress.getByName("localhost"), 8888);
            socket.send(datagramPacket2);
        }
        // 6:关闭资源
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        Receiver receiver = new Receiver(9999);
        receiver.start();
    }
}
