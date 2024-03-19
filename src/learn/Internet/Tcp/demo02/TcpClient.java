package learn.Internet.Tcp.demo02;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 9900);
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream("2.jpg");
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }

        socket.shutdownOutput();
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer1 = new byte[1024];
        int len1;
        while ((len1 = is.read(buffer1)) != -1) {
            baos.write(buffer1, 0, len1);
            System.out.println(new String(buffer1, 0, len1));
        }
        baos.close();
        socket.close();
        os.close();
        fis.close();
        System.out.println("传输完毕");
    }
}
