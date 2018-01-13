import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ddate {

    //两种构造方法
    public void  create()
    {
        //第一种
        Date date =new Date();
        //第二种 ,里面是毫秒数
        Date date1 =new Date(1023);
    }
    //常用api
    public void api()
    {
        Date date =new Date();
        //返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数
        System.out.println(date.getTime());
        //获取当前时间
        System.out.println(date.toString());
    }

    //使用 SimpleDateFormat 格式化日期
    //SimpleDateFormat 允许你选择任何用户自定义日期时间格式来运行。
    public void f()
    {
        Date date =new Date();
        //这一行代码确立了转换的格式，其中 yyyy 是完整的公元年，MM 是月份，dd 是日期，HH:mm:ss 是时、分、秒。
        //注意:有的格式大写，有的格式小写，例如 MM 是月份，mm 是分；HH 是 24 小时制，而 hh 是 12 小时制。
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        System.out.println(simpleDateFormat.format(date));
    }

    //printf 格式化对象
    public void pf()
    {
        Date date = new Date();

        //c的使用
        System.out.printf("全部日期和时间信息：%tc%n",date);
        //f的使用
        System.out.printf("年-月-日格式：%tF%n",date);
        //d的使用
        System.out.printf("月/日/年格式：%tD%n",date);
        //r的使用
        System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n",date);
        //t的使用
        System.out.printf("HH:MM:SS格式（24时制）：%tT%n",date);
        //R的使用
        System.out.printf("HH:MM格式（24时制）：%tR",date);
    }


    //解析字符串为时间
    //1818-11-11 Parses as Wed Nov 11 00:00:00 CST 1818
    public void pparse()
    {
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");

        String input = "1818-11-11";

        System.out.print(input + " Parses as ");

        Date t;

        try {
            t = ft.parse(input);
            System.out.println(t);
        } catch (Exception e) {
            System.out.println("Unparseable using " + ft);
        }
    }


    //Calendar类
    //设置和获取日期数据的特定部分,比如说小时，日，或者分钟,还能在日期的这些部分加上或者减去值 使用Calendar类
    // 。
    public void can()
    {
        //创建一个代表系统当前日期的Calendar对象
        Calendar c = Calendar.getInstance();//默认是当前日期
        //创建一个指定日期的Calendar对象
        //使用Calendar类代表特定的时间，需要首先创建一个Calendar的对象，然后再设定该对象中的年月日参数来完成。
        Calendar c1 = Calendar.getInstance();
        c1.set(2009, 6 - 1, 12);
        Calendar c2 = Calendar.getInstance();
        // 获得年份
        int year = c1.get(Calendar.YEAR);
        // 获得月份
        int month = c1.get(Calendar.MONTH) + 1;
        // 获得日期
        int date = c1.get(Calendar.DATE);
        // 获得小时
        int hour = c1.get(Calendar.HOUR_OF_DAY);
        // 获得分钟
        int minute = c1.get(Calendar.MINUTE);
        // 获得秒
        int second = c1.get(Calendar.SECOND);
        // 获得星期几（注意（这个与Date类是不同的）：1代表星期日、2代表星期1、3代表星期二，以此类推）
        int day = c1.get(Calendar.DAY_OF_WEEK);
    }
}
