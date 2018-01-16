import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDeom {

    private static Lock lock =new ReentrantLock();
    private static ReentrantReadWriteLock readwriteLock =new ReentrantReadWriteLock();
    private static Lock readLock = readwriteLock.readLock();
    private static Lock writeLock =readwriteLock.writeLock();

    private int value;
    //模拟读操作
    public Object handleRead(Lock lock) throws Exception
    {
        try
        {
            lock.lock();
            Thread.sleep(1000);
            return value;
        }
        finally {
            lock.unlock();
        }
    }

    public void handlewrite(Lock lock,int index) throws Exception
    {
        try
        {
            lock.lock();
            Thread.sleep(1000);
            value=index;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args)
    {
        final ReadWriteLockDeom demo =new ReadWriteLockDeom();
        Runnable readRunnable =new Runnable() {
            @Override
            public void run() {
                try
                {
                    demo.handleRead(readLock);
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        };

        Runnable writeRunnable =new Runnable() {
            @Override
            public void run() {
                try
                {
                    demo.handlewrite(writeLock,new Random().nextInt());
                    demo.handlewrite(lock,new Random().nextInt());
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        };
        for(int i=0;i<20;i++)
        {
            new Thread(readRunnable).start();
        }

        for(int i=20;i<22;i++)
        {
            new Thread(writeRunnable).start();
        }
    }
}
