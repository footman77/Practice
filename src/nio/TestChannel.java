package nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/**
 * @author footman77
 * @create 2018-10-23 15:18
 *
 * 一、通道（Channel）：用于源节点与目标节点的连接。在 Java NIO 中负责缓冲区中数据的传输。Channel 本身不存储数据，因此需要配合缓冲区进行传输。
 *
 * 二、通道的主要实现类
 * 	java.nio.channels.Channel 接口：
 * 		|--FileChannel
 * 		|--SocketChannel
 * 		|--ServerSocketChannel
 * 		|--DatagramChannel
 *
 * 三、获取通道
 * 1. Java 针对支持通道的类提供了 getChannel() 方法
 * 		本地 IO：
 * 		FileInputStream/FileOutputStream
 * 		RandomAccessFile
 *
 * 		网络IO：
 * 		Socket
 * 		ServerSocket
 * 		DatagramSocket
 *
 * 2. 在 JDK 1.7 中的 NIO.2 针对各个通道提供了静态方法 open()
 * 3. 在 JDK 1.7 中的 NIO.2 的 Files 工具类的 newByteChannel()
 *
 * 四、通道之间的数据传输
 * transferFrom()
 * transferTo()
 *
 * 五、分散(Scatter)与聚集(Gather)
 * 分散读取（Scattering Reads）：将通道中的数据分散到多个缓冲区中
 * 聚集写入（Gathering Writes）：将多个缓冲区中的数据聚集到通道中
 *
 * 六、字符集：Charset
 * 编码：字符串 -> 字节数组
 * 解码：字节数组  -> 字符串
 *
 */
public class TestChannel {

    @Test
    public void test06() throws IOException {
        Charset charset = Charset.forName("UTF-8");

        //编码器
        CharsetEncoder encoder = charset.newEncoder();

        //解码器
        CharsetDecoder decoder = charset.newDecoder();

        CharBuffer buffer = CharBuffer.allocate(1024);
        buffer.put("你好啊");
        buffer.flip();

        //编码
        ByteBuffer byteBuffer = encoder.encode(buffer);


        CharBuffer decode = decoder.decode(byteBuffer);
        System.out.println(decode.toString());

    }


    @Test
    public void test05(){
        SortedMap<String, Charset> charsets = Charset.availableCharsets();

        Set<Map.Entry<String, Charset>> entries = charsets.entrySet();
        for(Map.Entry<String,Charset> entry : entries){
            System.out.println(entry.getKey());
            System.out.println("-------------");
            System.out.println(entry.getValue());
        }
    }



    @Test
    public void test04(){

        try {
            RandomAccessFile file = new RandomAccessFile("1.txt", "rw");
            FileChannel channel = file.getChannel();

            ByteBuffer buf1 = ByteBuffer.allocate(100);
            ByteBuffer buf2 = ByteBuffer.allocate(1024);

            ByteBuffer[] buf = {buf1,buf2};
            channel.read(buf);

            for(ByteBuffer byteBuffer : buf){
                byteBuffer.flip();
            }


            System.out.println(new String(buf[0].array(), 0, buf[0].limit()));
            System.out.println("-----------------");
            System.out.println(new String(buf[1].array(), 0, buf[1].limit()));


            RandomAccessFile outFile = new RandomAccessFile("2.txt", "rw");
            FileChannel outFileChannel = outFile.getChannel();

            outFileChannel.write(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @Test
    public void test03(){
        FileChannel inChannel = null;
        FileChannel outChannel = null;

        try {
            inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.READ,StandardOpenOption.CREATE);

            inChannel.transferTo(0,inChannel.size(),outChannel);
//            outChannel.transferFrom(inChannel,0,inChannel.size());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if( outChannel != null){
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(inChannel != null){
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


    }



    //使用直接缓冲区完成文件的复制(内存映射文件),只有byteBuffer支持
    @Test
    public  void  test02(){

        long start = System.currentTimeMillis();


        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.READ,StandardOpenOption.CREATE);

            MappedByteBuffer inMappedBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outMappedBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());


            byte[] dst = new byte[inMappedBuffer.limit()];
            inMappedBuffer.get(dst);
            outMappedBuffer.put(dst);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inChannel != null){
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(outChannel != null){
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        long end = System.currentTimeMillis();
        System.out.println("耗费时间为：" + (end - start));

    }



    //利用通道完成文件的复制（非直接缓冲区）
    @Test
    public void test01(){

        long start = System.currentTimeMillis();

        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            inputStream = new FileInputStream("1.jpg");
            outputStream = new FileOutputStream("2.jpg");
            inChannel = inputStream.getChannel();
            outChannel = outputStream.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(1024);

            while (inChannel.read(buf) != -1){
                buf.flip();
                outChannel.write(buf);
                buf.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(outChannel != null){
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(inChannel != null){
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        long end = System.currentTimeMillis();
        System.out.println("耗费时间为：" + (end - start));
    }
}
