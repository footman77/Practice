package test;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(7777);
        Socket socket = serverSocket.accept();
        //获取socket对应的流通道
        InputStream  inputStream =  socket.getInputStream();

        byte[] buf = new byte[1024];
        int length = inputStream.read(buf);
        System.out.println(new String(buf, 0, length));

        serverSocket.close();
    }
}
