import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class InputStreamDemo {
    public static void main() throws Exception
    {
        File f = new File("1.txt");
        OutputStream outputStream = new FileOutputStream(f);
        //或者
        OutputStream outputStream1=new FileOutputStream("1.txt");
        //所以两种构造方法.
    }
}
