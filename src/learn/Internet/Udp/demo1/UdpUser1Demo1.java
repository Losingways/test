package learn.Internet.Udp.demo1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpUser1Demo1 {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(8080);//设置user1端口
        //设置目标地址
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        int port = 9090;
        //存储msg到buffer
        String msg = "你好,UDP";
        byte[] buffer = msg.getBytes();
        //创建数据包
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length, ip, port);
        ds.send(packet);
        ds.close();
    }
}
