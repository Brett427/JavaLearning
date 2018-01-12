import java.io.File;
import java.io.IOException;

public class func {
    // 创建一个新文件
    public void createfile()
    {
        File f = new File("1.txt");
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void file_static()
    {
        System.out.println(File.pathSeparator);
        System.out.println(File.separator);
    }
    //删除一个指定的文件
    public void deletefile()
    {
        File f = new File("1.txt");
        if(f.exists())
        {
            f.delete();
        }
    }

    //创建一个文件夹
    public void create_folder()
    {
        File f = new File("/home/brett/Desktop/IO/test");
        f.mkdir();
    }

    //列出指定目录的所有文件
    public void list_all_files()
    {
        File f = new File("/home/brett/Desktop");
        String[] list =f.list();
        for(int i=0;i<list.length;i++)
        {
            System.out.println(list[i]);
        }
    }
    // 判断是否是目录
    public void is_directory()
    {
        File f = new File("/home/brett/Desktop");
        if(f.isDirectory())
        {
            System.out.println(f.getPath());
        }
    }

}
