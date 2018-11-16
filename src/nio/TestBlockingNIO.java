package nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author footman77
 * @create 2018-10-23 20:06
 *
 * 一、使用 NIO 完成网络通信的三个核心：
 *
 * 1. 通道（Channel）：负责连接
 *
 * 	   java.nio.channels.Channel 接口：
 * 			|--SelectableChannel
 * 				|--SocketChannel
 * 				|--ServerSocketChannel
 * 				|--DatagramChannel
 *
 * 				|--Pipe.SinkChannel
 * 				|--Pipe.SourceChannel
 *
 * 2. 缓冲区（Buffer）：负责数据的存取
 *
 * 3. 选择器（Selector）：是 SelectableChannel 的多路复用器。用于监控 SelectableChannel 的 IO 状况
 *
 */
public class TestBlockingNIO {

    @Test
    public void client() throws IOException {

        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));

        FileChannel fileChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);


        while ( fileChannel.read(byteBuffer) != -1){
            byteBuffer.flip();
            sChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        fileChannel.close();
        sChannel.close();


    }

    @Test
    public void server() throws IOException {
        //获取通道
        ServerSocketChannel socketChannel = ServerSocketChannel.open();

        FileChannel fileChannel = FileChannel.open(Paths.get("3.jpg"), StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        //绑定连接
        socketChannel.bind(new InetSocketAddress(9999));

        //获取客户端连接的通道
        SocketChannel sChannel = socketChannel.accept();

        //缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //接收客户端的数据，并保存到本地
        while (sChannel.read(buffer) != -1){
            buffer.flip();
            fileChannel.write(buffer);
            buffer.clear();
        }

        //关闭通道
        sChannel.close();
        fileChannel.close();
        socketChannel.close();

    }

}
