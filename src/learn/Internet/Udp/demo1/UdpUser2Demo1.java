package learn.Internet.Udp.demo1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpUser2Demo1 {
    public static void main(String[] args) throws Exception {
        // 创建一个UDP套接字，绑定到端口9090
        DatagramSocket socket = new DatagramSocket(9090);
        // 创建一个字节数组，用于存储接收到的数据
        byte[] buffer = new byte[1024];
        // 创建一个DatagramPacket对象，用于接收数据
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        // 接收数据
        socket.receive(packet);
        // 打印接收到的数据
        System.out.println(new String(buffer, 0, packet.getLength()));
        // 关闭套接字
        socket.close();
    }
}