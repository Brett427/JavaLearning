import java.util.concurrent.*;
//自定义线程池并执行
public class RejectThreadPoolDemo {

    public static class Mytask implements Runnable
    {
        public void run()
        {
            System.out.println(System.currentTimeMillis()+Thread.currentThread().getId());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public static void main(String[] args) throws Exception
    {
        Mytask mytask =new Mytask();
        //自定义一个线程池
        ExecutorService es = new ThreadPoolExecutor(5,5,0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>(10),Executors.defaultThreadFactory(),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println(r.toString()+"is discard");
                    }
                });

        for(int i=0;i<Integer.MAX_VALUE;i++)
        {
            es.submit(mytask);
            Thread.sleep(100);
        }

    }
}
