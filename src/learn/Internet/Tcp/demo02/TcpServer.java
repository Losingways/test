package learn.Internet.Tcp.demo02;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9900);
        Socket accept = serverSocket.accept();
        InputStream is = accept.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("recieve.jpg"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }
        fos.close();
        serverSocket.close();
        accept.close();
        is.close();
        System.out.println("文件接收完成");

    }
}
