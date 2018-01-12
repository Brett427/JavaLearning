

import java.io.*;

public class zijieliu_zifuliu {
    //向文件中写入字符串
    public void  write_zifu()
    {
        //找到一个文件
        File f = new File("1.txt");
        try {//实例化操作流
            OutputStream outputStream = new FileOutputStream(f);
            String s = "Hello,World";
            // 只能写入byte[]
            byte[] bytes =s.getBytes();
            outputStream.write(bytes);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //往文件中追加新内容
    public void append()
    {
        File f =new File("1.txt");
        try {
            // 使用另一种实例化outputstream的方式
            OutputStream outputStream =new FileOutputStream(f,true);
            String s = "\r\nSYSU"; // \r\n 表示换行
            byte[] bs = s.getBytes();
            outputStream.write(bs);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //从文件中读取内容
    public void readfile()
    {
        File f = new File("1.txt");
        try {
            InputStream inputStream =new FileInputStream(f);
            byte[] bytes =new byte[(int) f.length()];
            int len = inputStream.read(bytes);
            inputStream.close();
            System.out.println(new java.lang.String(bytes,0,len));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //字符流
    public void writer_write()
    {
        File f = new File("1.txt");
        try {
            Writer writer1 = new FileWriter(f);
            String s = "wkn";
            writer1.write(s);
            writer1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //追加
    public void writer_append()
    {
        File f = new File("1.txt");
        try {
            Writer writer = new FileWriter(f,true);
            String s = "sysu";
            writer.write(s);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 字符输出
    public void Reader_read()
    {
        File file =new File("1.txt");
        try {
            Reader reader =new FileReader(file);
            char c[] =new char[1024];
            reader.read(c);
            for(int i=0;i<file.length();i++)
            {
                System.out.println(c[i]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
