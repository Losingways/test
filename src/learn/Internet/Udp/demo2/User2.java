package learn.Internet.Udp.demo2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class User2 {
    private static final String IP = "127.0.0.1";
    private static final int PORT = 9900;

    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(9901);
        byte[] buffer = new byte[1024];
        ReceiveThread thread = new ReceiveThread(ds, buffer);
        Thread t = new Thread(thread);
        t.start();

        boolean flag = true;
        while (flag) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            buffer = reader.readLine().getBytes();
            if ("bye".equals(new String(buffer))) {
                flag = false;
                buffer = "bye".getBytes();
                send(buffer, ds);
                ds.close();
            } else {
                send(buffer, ds);
            }

        }

    }

    static void send(byte[] buffer, DatagramSocket socket) throws Exception {
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, java.net.InetAddress.getByName(IP), PORT);
        socket.send(packet);
    }

    private static class ReceiveThread implements Runnable {
        DatagramSocket ds;
        byte[] buffer;
        private volatile boolean flag = true;

        public ReceiveThread(DatagramSocket ds, byte[] buffer) {
            this.ds = ds;
            this.buffer = buffer;
        }

        @Override
        public void run() {
            while (flag) {
                try {

                    if (ds.isClosed() == true) {
                        flag = false;
                        break;
                    }
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    try {
                        ds.receive(packet);
                    } catch (SocketException e) {
                        System.out.println("您已下线");
                        return;
                    }

                    String msg = new String(packet.getData(), 0, packet.getLength());
                    System.out.println("user2: " + msg);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }
    }
}
