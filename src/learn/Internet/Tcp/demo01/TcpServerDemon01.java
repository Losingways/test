package learn.Internet.Tcp.demo01;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务端
public class TcpServerDemon01 {
    public static void main(String[] args) {
        //定义ByteArrayOutputStream对象，用于接收客户端数据
        ByteArrayOutputStream baos = null;
        //定义InputStream对象，用于接收客户端数据
        InputStream is = null;
        //定义ServerSocket对象，用于监听客户端连接
        ServerSocket serverSocket = null;
        try {
            //创建ServerSocket对象，监听9999端口
            serverSocket = new ServerSocket(9999);
            //accept方法返回一个Socket对象，表示客户端已连接
            Socket accept = serverSocket.accept();
            System.out.println("客户端已连接");
            //获取客户端的输入流
            is = accept.getInputStream();

            baos = new ByteArrayOutputStream();
            //创建一个ByteArrayOutputStream对象，用于存储客户端发送的数据
            //定义一个byte数组，用于接收客户端数据
            byte[] buffer = new byte[1024];
            //定义一个int类型的变量，用于接收客户端发送的数据长度
            int len;
            //接收客户端数据
            while ((len = is.read(buffer)) != -1) {
                //将接收到的数据存入ByteArrayOutputStream对象中
                baos.write(buffer, 0, len);
            }
            System.out.println(baos.toString());
            System.out.println("客户端已接收");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
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
