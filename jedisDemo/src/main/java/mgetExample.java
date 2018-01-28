import redis.clients.jedis.Jedis;

import java.util.List;

public class mgetExample {
    public static void main(String[] args)
    {
        Jedis jedis =new Jedis("127.0.0.1",6379);
        jedis.lpush("ids","a");
        jedis.lpush("ids","b");
        jedis.lpush("ids","c");

        List<String> ids =jedis.lrange("ids",0,-1);

        jedis.set("a","{'name':'wangkangning','age':'20'}");
        jedis.set("b","{'name':'corning','age':'22'}");
        jedis.set("c","{'name':'mc','age':'21'}");

        List<String> list =jedis.mget(ids.toArray(new String[ids.size()]));
        System.out.println(list);
    }
}
