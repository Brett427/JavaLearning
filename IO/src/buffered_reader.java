import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// BufferedReader类
public class buffered_reader {
    public void shi_li_hua()
    {
        //BufferedReader中定义的构造方法只能接收字符输入流的实例,
        // 所以必须使用字符输入流和字节输入流的转换类InputStreamReader
        //将字节输入流System.in 变为字符流.
        BufferedReader buf = null;
        buf = new BufferedReader(new InputStreamReader(System.in));
    }

    //键盘输入数据的标准形式
    public void shuru()
    {
        BufferedReader buf =new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        try {
            str = buf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("输入的内容是"+str);
    }


}
