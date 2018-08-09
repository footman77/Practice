package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class ChatSender extends Thread{

    @Override
    public void run() {
        DatagramSocket datagramSocket = null;
        try{
            datagramSocket = new  DatagramSocket();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            DatagramPacket packet = null;
            while((line = bufferedReader.readLine()) != null) {
                packet = new DatagramPacket(line.getBytes(),0, line.length(), InetAddress.getByName("192.168.0.255"), 9090);
                datagramSocket.send(packet);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            datagramSocket.close();
        }




    }


}
