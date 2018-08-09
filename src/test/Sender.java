package test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Sender {
    public static void main(String[] args) throws Exception {
        //建立udp连接
        DatagramSocket socket = new DatagramSocket();
        //准备数据，把数据封装到数据包中
        String data = "例子而已";
        byte[] buf = data.getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.0.108"), 18881);
        socket.send(packet);
        socket.close();
    }
}
