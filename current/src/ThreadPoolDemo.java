import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolDemo {
    public static class Mytask implements Runnable{
        public void run()
        {
            System.out.println(System.currentTimeMillis()+"Thread ID"+Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[])
    {
        Mytask task =new Mytask();
        // ExecutorService继承Executor
        ExecutorService es = Executors.newFixedThreadPool(5);
        for(int i=0;i<10;i++)
        {
            Future t = es.submit(task);
        }
        es.shutdown();
    }

}
