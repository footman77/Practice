package test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClint {
    public static void main(String[] args) throws Exception {

        //建立tcp的客户端服务
        Socket socket = new Socket(InetAddress.getLocalHost(), 7777);
        String data = "tcp例子";
        OutputStream out = socket.getOutputStream();

        out.write(data.getBytes());

        socket.close();

    }
}
