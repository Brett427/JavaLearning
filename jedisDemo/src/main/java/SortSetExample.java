import redis.clients.jedis.Jedis;

import java.util.Set;

public class SortSetExample {
    public static void main(String[] args)
    {
        Jedis jedis =new Jedis("127.0.0.1",6379);
        jedis.zadd("hackers", 1940, "Alan Kay");
        jedis.zadd("hackers", 1953, "Richard Stallman");
        jedis.zadd("hackers", 1965, "Yukihiro Matsumoto");
        jedis.zadd("hackers", 1916, "Claude Shannon");
        jedis.zadd("hackers", 1969, "Linus Torvalds");
        jedis.zadd("hackers", 1912, "Alan Turing");
        Set<String> setValues = jedis.zrange("hackers", 0, -1);
        System.out.println(setValues);
        Set<String> setValues2 = jedis.zrevrange("hackers", 0, -1);
        System.out.println(setValues2);

        // 清空数据
        System.out.println(jedis.flushDB());
        // 添加数据
        jedis.zadd("zset", 10.1, "hello");
        jedis.zadd("zset", 10.0, ":");
        jedis.zadd("zset", 9.0, "zset");
        jedis.zadd("zset", 11.0, "zset!");
        // 元素个数
        System.out.println(jedis.zcard("zset"));
        // 元素下标
        System.out.println(jedis.zscore("zset", "zset"));
        // 集合子集
        System.out.println(jedis.zrange("zset", 0, -1));
        // 删除元素
        System.out.println(jedis.zrem("zset", "zset!"));
        System.out.println(jedis.zcount("zset", 9.5, 10.5));
        // 整个集合值
        System.out.println(jedis.zrange("zset", 0, -1));


        jedis.zadd("zhongsou:hackers", 1940, "Alan Kay");
        jedis.zadd("zhongsou:hackers", 1953, "Richard Stallman");
        jedis.zadd("zhongsou:hackers", 1943, "Jay");
        jedis.zadd("zhongsou:hackers", 1920, "Jellon");
        jedis.zadd("zhongsou:hackers", 1965, "Yukihiro Matsumoto");
        jedis.zadd("zhongsou:hackers", 1916, "Claude Shannon");
        jedis.zadd("zhongsou:hackers", 1969, "Linus Torvalds");
        jedis.zadd("zhongsou:hackers", 1912, "Alan Turing");

        Set<String> hackers = jedis.zrange("zhongsou:hackers", 0, -1);
        System.out.println(hackers);

        Set<String> hackers2 = jedis.zrevrange("zhongsou:hackers", 0, -1);
        System.out.println(hackers2);

        // 区间操作,我们请求Redis返回score介于负无穷到1920年之间的元素（两个极值也包含了）。
        Set<String> hackers3 = jedis.zrangeByScore("zhongsou:hackers", "-inf",
                "1920");
        System.out.println(hackers3);

        // ZREMRANGEBYSCORE 这个名字虽然不算好，但他却非常有用，还会返回已删除的元素数量。
        long num = jedis.zremrangeByScore("zhongsou:hackers", "-inf", "1920");
        System.out.println(num);

        jedis.flushAll();

    }

}
