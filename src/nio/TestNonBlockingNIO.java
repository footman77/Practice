package nio;


import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;

import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author footman77
 * @create 2018-10-23 21:29
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
public class TestNonBlockingNIO {

    @Test
    public void client() throws IOException {
        //获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 7878));
        //切换成非阻塞模式
        socketChannel.configureBlocking(false);

        //分配指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //发送数据
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();
            byteBuffer.put((new Date().toString() + "\n" +  s).getBytes());

            byteBuffer.flip();

            socketChannel.write(byteBuffer);

            byteBuffer.clear();

        }


        //关闭通道
        socketChannel.close();


    }


    @Test
    public void server() throws IOException {
        //获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //切换成非阻塞模式
        serverSocketChannel.configureBlocking(false);

        //绑定连接
        serverSocketChannel.bind(new InetSocketAddress(7878));

        //获取选择器
        Selector selector = Selector.open();

        //将通道注册到选择器上,并且监听事件
        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);

        //通过选择器，轮询式的获取选择器上已经准备就绪的事件
        while (selector.select() > 0){
            //获取当前选择器中所有注册的选择键（已就绪的监听事件）
            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
            while (keyIterator.hasNext()){
                //获取准备就绪的事件
                SelectionKey key = keyIterator.next();

                //判断具体是什么时间准备就绪
                if(key.isAcceptable()){
                    //若接收就绪，获取客户端连接
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    //切换非阻塞模式
                    socketChannel.configureBlocking(false);
                    //将该通道注册到选择器上
                    socketChannel.register(selector,SelectionKey.OP_READ);
                }else if(key.isReadable()){
                    //获取当前选择器上“读就绪”状态的通道
                    SocketChannel channel = (SocketChannel) key.channel();

                    //读取数据
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

                    int len = 0;
                    while ((len = channel.read(byteBuffer))  > 0){

                        byteBuffer.flip();
                        System.out.println(new String(byteBuffer.array(),0,len));
                        byteBuffer.clear();
                    }

                }
                //取消选择键SelectionKey
                keyIterator.remove();

            }

        }
    }
}
