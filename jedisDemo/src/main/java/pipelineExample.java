import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class pipelineExample {
    public static void main(String[] args)
    {
        Jedis jedis =new Jedis("127.0.0.1",6379);
        long start = System.currentTimeMillis();
        Pipeline p =jedis.pipelined();
        for(int i=0;i<10000;i++)
        {
            p.set("age2"+i,i+"");
            System.out.println(p.get("age2"+i));
        }
        p.sync();// 这段代码获取所有的response

        long end = System.currentTimeMillis();
        System.out.println("cost "+ (end-start)+"ms");
        jedis.close();
    }
}
