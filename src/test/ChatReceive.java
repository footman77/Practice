package test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ChatReceive extends Thread{
    @Override
    public void run() {
        try{
            DatagramSocket datagramSocket = new DatagramSocket(9090);
            byte[] buf = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);

            while(true) {
                datagramSocket.receive(packet);
                System.out.println(packet.getAddress().getHostAddress() + ":" + new String(buf, 0, packet.getLength()));
            }
        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
