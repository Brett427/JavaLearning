import java.util.concurrent.locks.ReentrantLock;

public class reentertLock implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();
    public static int i= 0;
    @Override
    public void run() {
        for(int j=0;j<1000;j++)
        {
            lock.lock();
            try{
                i++;
            }finally {
                lock.unlock();
            }
        }
        System.out.println("123");
    }
    public static void main(String[] args) throws Exception
    {
        reentertLock r1 =new reentertLock();
        Thread t1 =new Thread(r1);
        Thread t2 =new Thread(r1);
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println(i);
    }
}
