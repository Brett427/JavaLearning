import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//专门输入数据类
public class scanner {
    /*
    * public Scanner(File scoure) // 构造函数,从文件中接收内容
    * public Scanner(InputStream scorce)//构造函数,从指定字节输入流接收内容.
    * public boolean hasNext(Pattern pattern) 判断输入的数据是否符合指定的正则标准
    * public boolean hasNextInt() 判断输入是否是整数
    * public boolean hasNextFloat() 判断输入是否是小数
    * public String next()  // 接收内容
    * public int nextInt() // 接收数字
    * public float nextFloat() //接收小数
    * public Scanner useDelimiter(String pattern)   设置读取的分割符
    *
    * */


    //基本数据输入
    void shujushuru()
    {
        Scanner scanner =new Scanner(System.in);
        String str = scanner.next();
        System.out.println("输入的数据是"+str);
    }

    //修改读入数据的分隔符为换行符,默认是空格
    void bian()
    {
        Scanner scanner =new Scanner(System.in);
        scanner.useDelimiter("\n");
        String str = scanner.next();
        System.out.println(str);
    }

    //日期格式数据输入
    void dateshuru()
    {
        Scanner scanner = new Scanner(System.in);
        String str = null;
        Date date =null;
        if(scanner.hasNext("^\\d{4}-\\d{2}-\\{2}$"))
        {
            str = scanner.next("^\\d{4}-\\d{2}-\\{2}$");
            try
            {
                date=new SimpleDateFormat("yyyyy-MM-dd").parse(str);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    //从文件中得到数据
    //从文件中得到数据,直接将File 类的实例传入Scanner的构造方法即可
    void file11()
    {
        File f =new File("1.txt");
        Scanner scanner =null;
        try {
            scanner = new Scanner(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuffer str = new StringBuffer();
        while(scanner.hasNext())
        {
            str.append(scanner.next()).append("\n");
        }
    }
}
