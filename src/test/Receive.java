package test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receive {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(18881);
        //准备一个空的数据包
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        System.out.println(packet.getAddress().getHostAddress() + "接收" + new String(buf, 0, packet.getLength()));
        socket.close();
    }
}
