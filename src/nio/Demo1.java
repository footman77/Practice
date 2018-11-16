package nio;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @author footman77
 * @create 2018-10-22 14:02
 */
public class Demo1 {

    @Test
    public void test01(){
        String str = "helloworld!";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        buffer.put(str.getBytes());

        buffer.flip();
        byte[] dst = new byte[buffer.limit()];
        buffer.get(dst);
        System.out.println(new String(dst,0,dst.length));


    }

    @Test
    public void test02(){

        ByteBuffer direct = ByteBuffer.allocateDirect(1024);

    }
}
