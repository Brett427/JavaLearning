import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureCallableDemo {

    public static class RealData implements Callable<String>
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
    public static class FutureMain
    {
        public static void main(String[] args) throws Exception
        {
           //构造FutureTask
            RealData realData =new RealData("a");
            FutureTask<String> future = new FutureTask<String>(realData);
            ExecutorService es = Executors.newFixedThreadPool(1);
            // 执行FutureTask
            es.submit(realData);

            Thread.sleep(3000);// 模拟做一些额外的事情
            System.out.println(future.get());// 在需要的时候通过get()方法获得需要的数据.
        }
    }
}
