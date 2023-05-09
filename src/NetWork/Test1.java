package p1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test1 {
    public static void main(String[] args) throws UnknownHostException {
        // 不可直接创建对象，因为InetAddress的构造器被defaut修饰，不可在指定包外创建对象。
        // InetAddress inetAddress = new InetAddress();
        InetAddress inetAddress = InetAddress.getByName("10.22.61.215"); // 传IP地址
        System.out.println(inetAddress); // /10.22.61.215

        InetAddress inetAddress2 = InetAddress.getByName("localhost"); // localhost代指本机的IP
        System.out.println(inetAddress2); // localhost/127.0.0.1 其中127.0.0.1代之的是本机的IP地址。

        InetAddress inetAddress3 = InetAddress.getByName("127.0.0.1");
        System.out.println(inetAddress3); // /127.0.0.1

        InetAddress inetAddress4 = InetAddress.getByName("inspiration16plus");//封装计算机名
        System.out.println(inetAddress4); // inspiration16plus/10.22.61.215

        InetAddress inetAddress5 = InetAddress.getByName("www.mashibing.com"); // 封装域名
        System.out.println(inetAddress5); // www.mashibing.com/8.142.18.182   前半段-> 域名 后半段-> IP地址
        System.out.println(inetAddress5.getHostName());// 获取域名 // www.mashibing.com
        System.out.println(inetAddress5.getHostAddress()); // 获取域名对应的IP地址 // 8.142.18.182
    }
}
