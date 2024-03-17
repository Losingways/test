package learn.Internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class testIp {
    public static void main(String[] args) throws UnknownHostException {
        System.out.println(InetAddress.getLocalHost());
        System.out.println(InetAddress.getLocalHost().getHostAddress());
        System.out.println(InetAddress.getLocalHost().getHostName());
        System.out.println(InetAddress.getLocalHost().getCanonicalHostName());
        System.out.println( InetAddress.getByName("www.baidu.com"));
       
    }
}
