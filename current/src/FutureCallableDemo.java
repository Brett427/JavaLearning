import java.util.concurrent.*;
//单纯使用Future 和Callable. Demo2 则使用FutureTask.
public class FutureCallableDemo {

    public static void main(String[] args) throws Exception
    {

        Callable<String> realData =new RealData("a");
        //如果申请了FutureTask,即加了下面这句,那么往线程池中必须submit FutureTask类作为Runnable.
//      FutureTask<String> future = new FutureTask<>(realData);
        //如果没有加上面这句,直接submit Callable到线程池,申请一个Future接收就好.
        ExecutorService es = Executors.newFixedThreadPool(1);
        // 执行FutureTask
        Future<String> future = es.submit(realData);

        //Thread.sleep(300);// 模拟做一些额外的事情
        System.out.println(future.get());// 在需要的时候通过get()方法获得需要的数据.

    }

    static class RealData implements Callable<String>
    {
        private String para;

        public RealData(String para)
        {
            this.para=para;
        }
        @Override
        public String call() throws Exception {
            StringBuffer sb =new StringBuffer();
            for(int i=0;i<10;i++)
            {
                sb.append(para);
                Thread.sleep(100);
            }
            return sb.toString();
        }// 上述代码实现了Callable接口,它的call()方法会构造我们需要的真实数据并返回,这里用sleep进行模拟.
    }




}
