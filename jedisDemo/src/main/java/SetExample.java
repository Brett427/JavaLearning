import redis.clients.jedis.Jedis;

import java.util.Set;

public class SetExample {
    public static void main(String[] args)
    {
        Jedis jedis =new Jedis("127.0.0.1",6379);
        jedis.sadd("set","1");
        jedis.sadd("set","2");
        jedis.sadd("set","3");
        jedis.sadd("set","4");
        jedis.sadd("set","5");
        jedis.sadd("set","6");

        Set<String> set =jedis.smembers("set");
        System.out.println(set);

        jedis.srem("set","4"); //删除4
        System.out.println(jedis.smembers("set"));
        //是否存在
        System.out.println(jedis.sismember("set","3"));

        //返回集合中元素的数量
        System.out.println(jedis.scard("sname"));
        //移除一个随机元素
        jedis.spop("set");

        //jedis.flushDB();

        jedis.sadd("set1","1");
        jedis.sadd("set1","2");
        jedis.sadd("set1","3");
        jedis.sadd("set1","4");
        jedis.sadd("set1","5");
        jedis.sadd("set2","2");
        jedis.sadd("set2","3");
        jedis.sadd("set2","4");
        jedis.sadd("set2","5");
        jedis.sadd("set2","6");
        // 返回交集
        System.out.println(jedis.sinter("set1","set2"));
        // 返回并集
        System.out.println(jedis.sunion("set1","set2"));
        // 返回差集
        System.out.println(jedis.sdiff("set1","set2"));
        System.out.println(jedis.sdiff("set2","set1"));
        jedis.close();
    }
}
