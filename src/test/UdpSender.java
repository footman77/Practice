package test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpSender {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        String data = "おはよう";
        byte[] buf = data.getBytes();
        DatagramPacket packet = new DatagramPacket(buf,0,buf.length,InetAddress.getByName("192.168.0.104"),9090);
        socket.send(packet);
        socket.close();
    }

}
