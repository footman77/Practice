package nio;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @author footman77
 * @create 2018-10-23 23:29
 */
public class TestPipe {

    @Test
    public void test01() throws IOException {
        //获取管道
        Pipe pipe = Pipe.open();
        
        //将缓冲区中的数据写入管道
        Pipe.SinkChannel sinkChannel = pipe.sink();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("单项管道数据".getBytes());
        byteBuffer.flip();

        sinkChannel.write(byteBuffer);



        //读取缓冲区中数据
        Pipe.SourceChannel sourceChannel = pipe.source();
        byteBuffer.flip();
        sourceChannel.read(byteBuffer);
        System.out.println(new String(byteBuffer.array(),0,byteBuffer.limit()));

        sourceChannel.close();
        sinkChannel.close();
    }
}
