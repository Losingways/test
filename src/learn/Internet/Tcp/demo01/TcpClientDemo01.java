package learn.Internet.Tcp.demo01;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

//客户端
public class TcpClientDemo01 {
    public static void main(String[] args) throws IOException {

        OutputStream os = null;
        Socket socket = null;
        InetAddress serverIp = null;
        try {
            //从键盘获取服务器IP地址
            serverIp = InetAddress.getByName("127.0.0.1");
            //创建socket对象(用来获取服务端的接口)，需要指定服务器的地址和端口号
            socket = new Socket(serverIp, 9999); 
            //获取端口对应的输出流
            os = socket.getOutputStream();
            //向服务器发送消息
            os.write("你好，服务器".getBytes());
            

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!os.equals(null)) {
                os.close();
            }
            if (!socket.equals(null))
                socket.close();
        }
    }
}
