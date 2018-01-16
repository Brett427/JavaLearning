import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static class Soldier implements Runnable
    {
        private String soldier;
        private final CyclicBarrier cyclic;

        Soldier(CyclicBarrier cyclic, String soldiername)
        {
            this.cyclic=cyclic;
            this.soldier =soldiername;
        }

        public void run()
        {
            try {
                // 每一个都要等待,直到所有的都完成.
                cyclic.await();
                dowork();
                cyclic.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

        }

        void dowork()
        {
            try {
                Thread.sleep(Math.abs(new Random().nextInt()%10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println( soldier+"任务完成");
        }
    }

    public static class BarrierRun implements Runnable
    {
        boolean flag;
        int N;
        public BarrierRun(boolean flag,int N)
        {
            this.flag=flag;
            this.N =N;
        }
        public void run()
        {
            if(flag)
            {
                System.out.println(N+"任务完成");
            }
            else
            {
                System.out.println(N+"集合完毕");
                flag=true;
            }
        }
    }

    public static void main(String[] args) throws Exception
    {
        final int N=10;
        Thread[] threads =new Thread[N];
        boolean flag = false;
        CyclicBarrier cyclicBarrier =new CyclicBarrier(N,new BarrierRun(flag,N));// 创建了一个屏障
        System.out.println("集合队伍");
        for(int i=0;i<N;i++)
        {
            System.out.println(i+"报道");
            threads[i]=new Thread(new Soldier(cyclicBarrier," "+i));//每一个线程都传进去屏障.
            threads[i].start();
        }
    }
}
