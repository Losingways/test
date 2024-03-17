package learn.Internet.Tcp.demo01;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务端
public class TcpServerDemon01 {
    public static void main(String[] args) {
        ByteArrayOutputStream baos = null;
        InputStream is = null;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(9999);
            Socket accept = serverSocket.accept();
            System.out.println("客户端已连接");
            is = accept.getInputStream();

            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            System.out.println(baos.toString());
            System.out.println("客户端已接收");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(!is.equals(null))
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(!baos.equals(null))
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            System.out.println("服务端退出");
        }
    }
}
