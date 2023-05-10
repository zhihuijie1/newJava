package p1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// 服务器代码
public class TcpEchoServer {
    // 属性
    private ServerSocket serverSocket;

    // 构造器
    public TcpEchoServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    // starrt方法
    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            Socket clientSocket = serverSocket.accept();
            this.processConnect(clientSocket);
        }
    }

    // processConnect方法：连上客户端提供服务的方法。
    public void processConnect(Socket clientSocket) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            System.out.printf("[%s:%d] 建立连接!\n", clientSocket.getInetAddress(), clientSocket.getPort());
            inputStream = clientSocket.getInputStream();
            outputStream = clientSocket.getOutputStream();
            Scanner scanner = new Scanner(inputStream); // 管子插在scanner上，往里输入。
            PrintWriter printWriter = new PrintWriter(outputStream); // 管子插在printWriter上，往外输出。
            while (true) {
                if (!scanner.hasNext()) {
                    // 连接断开，当客户端断开连接的时候，读到 EOF，此时 hasNext 就会返回 false
                    // 当客户端进程退出，也就会触发客户端的 socket 文件关闭
                    // 此时服务器这边尝试读取请求，就会读到 EOF，也就触发了返回 false
                    System.out.printf("[%s:%d] 断开连接!\n", clientSocket.getInetAddress(), clientSocket.getPort());
                    break;
                }
                // 读取请求
                String request = scanner.next();
                // 解析请求
                String response = process(request);
                // 响应客户端
                printWriter.println(response);
                // 刷新一下缓冲区
                printWriter.flush();
                System.out.printf("[%s -> %d] request -> %s; response -> %s\n", clientSocket.getInetAddress(), clientSocket.getPort(), request, response);
            }
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
                if (clientSocket != null) {
                    clientSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer tcpEchoServer = new TcpEchoServer(8000);
        tcpEchoServer.start();
    }
}
