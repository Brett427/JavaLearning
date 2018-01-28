import redis.clients.jedis.Jedis;

import java.util.List;

public class PageExample {

    public static void main(String[] args)
    {
        Jedis jedis =new Jedis("127.0.0.1",6379);
        int pageNo= 6;
        int pageSize =6;
        jedis.del("a");
        for(int i=1;i<=30;i++)
        {
            jedis.rpush("a",i+"");
        }

        int start = pageSize*(pageNo-1);
        int end = start+pageSize-1;

        List<String> results =jedis.lrange("a",start,end);
        for(String str :results)
        {
            System.out.println(str);
        }
    }
}
