import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
    static AtomicInteger i =new AtomicInteger(10);

    public static class  AddThread implements Runnable
    {
        @Override
        public void run()
        {
            for(int k=0;k<1000;k++)
            {
                i.incrementAndGet();
                System.out.println(i);
                System.out.println(i +" "+Thread.currentThread().getId());
            }
        }
    }

    public static void main(String[] args) throws Exception
    {
        Thread[] ts =new Thread[10];
        for(int k=0;k<10;k++)
        {
            ts[k]=new Thread(new AddThread());
        }

        for(int k=0;k<10;k++)
        {
            ts[k].start();
        }
//        for(int k=0;k<10;k++)
//        {
//            ts[k].join();
//        }
        System.out.println(i);
    }
}
