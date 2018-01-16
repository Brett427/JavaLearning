import sun.awt.windows.ThemeReader;

import java.util.concurrent.locks.ReentrantLock;

public class fair_lock implements Runnable{

    public static ReentrantLock lock =new ReentrantLock(true);
    public void run()
    {
        while(true)
        {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"获得锁");

            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args)
    {
        fair_lock f1 =new fair_lock();
        Thread t1 =new Thread(f1,"t1");
        Thread t2 =new Thread(f1,"t2");
        t1.start();
        t2.start();

    }
}
