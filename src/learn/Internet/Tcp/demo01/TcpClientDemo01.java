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
            serverIp = InetAddress.getByName("127.0.0.1");
            socket = new Socket(serverIp, 9999);
            
            os = socket.getOutputStream();
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
