import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo {

    static ThreadLocal<SimpleDateFormat> t1 =new ThreadLocal<>();

    public static class ParseDate implements Runnable
    {
        int i=0;
        Date date =new Date();
        public ParseDate(int i)
        {
            this.i=i;
        }
        public void run()
        {
            if(t1.get()==null)
            {
                t1.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            }
            try {
                Date t=  t1.get().parse("2015-03-29 19:29:"+i%60);
                System.out.println(i+" : "+t);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args)
    {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for(int i=0;i<1000;i++)
        {
            es.execute(new ParseDate(i));
        }
    }
}
