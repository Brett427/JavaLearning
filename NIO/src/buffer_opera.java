import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

public class buffer_opera {

    void operta()
    {
        IntBuffer buf = IntBuffer.allocate(10);//开辟10个大小缓冲区

        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        // 0 10 10

        int temp[] ={5,7,9}; //定义整型数组
        buf.put(temp); // 向缓冲区写入数据

        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        //3 10 10

        buf.flip();   //重设缓冲区
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        // 0 3 10

        System.out.println("缓冲区中的内容");
        while(buf.hasRemaining())
        {
            int x = buf.get();
            System.out.print(x+" , ");
        }
        //输出了 5 7 9
    }
    //通过flip()方法将Buffer从写模式切换到读模式。在读模式下，可以读取之前写入到buffer的所有数据。

    //往buffer中写数据的两种方式
    void write() throws Exception
    {
        File f = new File("1.txt");
        FileOutputStream fileOutputStream =new FileOutputStream(f);
        FileChannel channel =fileOutputStream.getChannel();
        ByteBuffer byteBuffer =ByteBuffer.allocate(48);
        channel.read(byteBuffer);//   往buffer中写数据
        //或者第二种方法,直接put
        //byteBuffer.put();
    }


    //创建子缓冲区
    void zihuanchongqu()
    {
        IntBuffer buffer = IntBuffer.allocate(10);
        IntBuffer sub =null;
        for(int i=0;i<10;i++)
        {
            buffer.put(2*1+1); //往缓冲区中加入元素
        }
        buffer.position(2);//主缓冲区指针设置在第三个元素上.
        buffer.limit(6); //主缓冲区limit 设为6
        sub = buffer.slice(); //使用slice 方法开辟子缓冲区.
        for(int i=0;i<sub.capacity();i++)
        {
            int temp = sub.get(i);   //取得元素
            sub.put(temp-1); //修改子缓冲区内容
        }

        buffer.flip();// 重设缓冲区
        buffer.limit(buffer.capacity());
        while(buffer.hasRemaining())
        {
            int x = buffer.get();
            System.out.println(x);
        }
    }


}
