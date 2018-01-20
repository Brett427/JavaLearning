import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
//使用FutureTask
public class FutureCallableDemo2 {

    public static void main(String[] args)
    {
        Callable<Integer> callable = new Callable<Integer>()
        {
            public Integer call() throws Exception
            {
                return new Random().nextInt(100);  //表示返回的数据.
            }
        };
        FutureTask<Integer> future = new FutureTask<Integer>(callable);
        //如果有FutureTask类,则必须放入FutureTask.
        new Thread(future).start();
        try {
            Thread.sleep(5000);// 可能做一些事情
            System.out.println(future.get());
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
