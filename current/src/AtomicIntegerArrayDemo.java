import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayDemo {
    static AtomicIntegerArray array =new AtomicIntegerArray(10);
    public static class  AddThread implements Runnable
    {
        public void run()
        {
            for(int k=0;k<1000;k++)
            {
                array.getAndIncrement(k%array.length());
            }
        }
    }

    public static void main(String args[]) throws Exception
    {
        Thread ts[] =new Thread[10];
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
        Thread.sleep(5000); //不让主线程sleep的话,可能输出的时候,其他线程还没有运行结束.这也是前面加join的意思.
        System.out.println(array);
    }
}
