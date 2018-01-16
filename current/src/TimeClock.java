import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

// 限时等待可重入锁
public class TimeClock implements Runnable{

    public static ReentrantLock lock =new ReentrantLock();

    public void run()
    {
        try
        {   //try 接收两个参数,时长和单位.
            if(lock.tryLock(5, TimeUnit.SECONDS))
            {
                Thread.sleep(3000);
            }
            else
            {
                System.out.println("get lock failed");
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally {
            if(lock.isHeldByCurrentThread())
            {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args)
    {
        TimeClock m1 =new TimeClock();
        Thread t1 =new Thread(m1);
        Thread t2 =new Thread(m1);
        t1.start();
        t2.start();
    }
}
