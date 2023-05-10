package p1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

// 客户端代码
public class TcpEchoClient {
    // 属性
    private Socket socket;

    // 构造器
    public TcpEchoClient(String IP, int port) throws IOException {
        socket = new Socket(IP, port);
    }

    // start方法 --> 启动客户端
    public void start() {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            // 1. 从控制台读取用户的输入
            Scanner scanner = new Scanner(System.in);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            Scanner scannernet = new Scanner(inputStream);
            PrintWriter printWriter = new PrintWriter(outputStream);

            String request = scanner.next();
            // 2. 把请求发送给服务器
            printWriter.println(request);
            printWriter.flush();
            // 3. 从服务器读取响应
            //   用 next 来读，说明读到空白符（空格、回车、换行、制表、翻页、垂直制表...。）就会停止
            String response = scannernet.next();
            // 4. 把结果显示到界面上
            System.out.printf("req: %s; resp: %s", request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient tcpEchoClient = new TcpEchoClient("10.22.61.215", 8000);
        tcpEchoClient.start();
    }
}
