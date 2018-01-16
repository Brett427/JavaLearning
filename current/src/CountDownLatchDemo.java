import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo implements Runnable {

    //表示有10个线程完成任务,等待在CountDownLatch上的线程才能继续执行.
    static final CountDownLatch end =new CountDownLatch(10);
    static final CountDownLatchDemo demo =new CountDownLatchDemo();

    public void run()
    {
        try {
            Thread.sleep(new Random().nextInt(10)*1000);
            System.out.println("check comlete");
            end.countDown();//通知 CountDownLatch, 一个线程已经完成了任务.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0;i<10;i++)
        {
            executorService.submit(demo);
        }
        //等待检查
        end.await();//要求主线程等待所有10个检查任务全部完成后,主线程才能继续执行.
        System.out.println("Fire!");
        executorService.shutdown();
    }
}
