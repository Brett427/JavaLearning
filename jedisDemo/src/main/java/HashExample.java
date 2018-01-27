import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HashExample {
    public static void main(String[] args)
    {
        Jedis jedis =new Jedis("127.0.0.1",6379);
        Map<String,String> pairs =new HashMap<String, String>();
        pairs.put("name","corning");
        pairs.put("age","23");
        pairs.put("xingbie","nan");
        jedis.hmset("kid",pairs);

        //结果是泛型的list
        List<String> nameAndAge =jedis.hmget("kid","name","age");
        for(String i:nameAndAge)
        {
            System.out.println(i); //输出 corning  23
        }
        jedis.hdel("kid","xingbie");//删除xingbie 域

        System.out.println(jedis.hlen("kid")); //返回kid中的域的个数
        System.out.println(jedis.exists("kid"));// 是否存在键kid
        System.out.println(jedis.hkeys("kid"));// 返回 kid的所有域的名字
        System.out.println(jedis.hvals("kid")); //返回所有值

        //遍历
        Iterator<String> iter = jedis.hkeys("kid").iterator();
        while(iter.hasNext())
        {
            String key =iter.next();
            System.out.println(jedis.hget("kid",key));
        }

        //清空数据
        //jedis.flushDB()
        //添加数据
        jedis.hset("hash","key1","val1");
        jedis.hset("hash","key2","val2");
        jedis.hset("hash","key3","5"); //Value 设置的时候都是字符串,但是可以增加数字
        jedis.hset("hash","key4","val4");
        //判断某个值是否存在
        jedis.hexists("hash","key1");

        //获取指定的值
        jedis.hget("hash","key1");
        System.out.println(jedis.hincrBy("hash","key3",5));
    }
}
