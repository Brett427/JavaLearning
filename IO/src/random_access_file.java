import java.io.File;
import java.io.RandomAccessFile;

public class random_access_file {
    public static void main(String[] args) throws Exception
    {
        //写操作
        File f =new File("2.txt");//指定要操作的文件
        RandomAccessFile rdf =new RandomAccessFile(f,"rw");// 读写方式打开文件,会自动创建新文件
        String name ="wkn     ";
        int age = 23;
        rdf.writeBytes(name);
        rdf.write(23);
        rdf.close();

        //读操作
        File f1 =new File("2.txt");
        RandomAccessFile rdf2 =new RandomAccessFile(f1,"r");
        byte[] b =new byte[8];
        for(int i=0;i<b.length;i++)
        {
            b[i]=rdf2.readByte();
        }
        String name1 =new String(b);
        System.out.printf(name1);
    }
}
