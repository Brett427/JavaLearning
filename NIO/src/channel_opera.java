import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class channel_opera {

    //使用通道写入文本
    public void channerwrite() throws Exception{
        String[] info ={"java","www","wkkn","mmmm"};
        File file =new File("1.txt");
        OutputStream outputStream =new FileOutputStream(file);
        //InputStream inputStream =new FileInputStream(file);
        //Scanner scanner =new Scanner(inputStream);
        FileOutputStream fileOutputStream =new FileOutputStream(file);
        FileChannel channel =null;
        //outputstream 对象中没有getChannel.
        channel =fileOutputStream.getChannel();   //得到输出的文件通道
        ByteBuffer buffer =ByteBuffer.allocate(1024);// 开辟缓冲
        for(int i=0;i<info.length;i++)
        {
            buffer.put(info[i].getBytes());   //缓冲区中写入数据
        }
        buffer.flip(); //重设缓冲区,准备输出
        channel.write(buffer);//  输出
        channel.close();
        outputStream.close();
    }//使用输出通道将内容全部放到缓存中,一次性写入到文件



    //使用通道进行读写操作
    public void readwrite() throws Exception
    {

        File file1 =new File("1.txt");
        File file2 =new File("2.txt");
        FileInputStream inputStream =null;
        FileOutputStream outputStream =null;
        inputStream =new FileInputStream(file1);
        outputStream =new FileOutputStream(file2);
        FileChannel fin =null;  //输入的通道对象
        FileChannel fout =null; //输出的通道对象

        fin = inputStream.getChannel(); //输入文件通道
        fout =outputStream.getChannel(); //输出文件通道

        ByteBuffer byteBuffer =ByteBuffer.allocate(1024);
        int temp=0;
        while((temp=fin.read(byteBuffer))!=-1)
        {
            byteBuffer.flip();
            fout.write(byteBuffer);
            byteBuffer.clear();
        }
        fin.close();
        fout.close();
        inputStream.close();
        outputStream.close();
    }

    //通道之间的数据传递
    //将数据从源通道传输到FileChannel中
    void mytrasnform() throws Exception
    {
        File file =new File("1.txt");
        File file2 = new File("2.txt");
        FileOutputStream outputStream1 =new FileOutputStream(file);
        FileInputStream inputStream = new FileInputStream(file2);
        FileChannel fromChannel =outputStream1.getChannel();
        FileChannel toChannel  =inputStream.getChannel();
        long position = 0;
        long count = fromChannel.size();
        toChannel.transferFrom(fromChannel,position,count);
    }

    void  mytransto() throws  Exception
    {
        File file =new File("1.txt");
        File file2 = new File("2.txt");
        FileOutputStream outputStream1 =new FileOutputStream(file);
        FileInputStream inputStream = new FileInputStream(file2);
        FileChannel fromChannel =outputStream1.getChannel();
        FileChannel toChannel  =inputStream.getChannel();
        long position = 0;
        long count = fromChannel.size();
        fromChannel.transferTo(position,count,toChannel);
    }
}
