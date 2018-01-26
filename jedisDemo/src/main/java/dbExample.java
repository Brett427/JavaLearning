import redis.clients.jedis.Jedis;

public class dbExample {
    public static void main(String[] args)
    {
        Jedis jedis =new Jedis("127.0.0.1",6379);
        System.out.println(jedis.select(0)); //返回OK
        System.out.println(jedis.dbSize());
        // 返回匹配指定模式的所有key
        System.out.println(jedis.keys("*"));
        System.out.println(jedis.randomKey());


        // 删除当前数据库中所有key,此方法不会失败。慎用
        //jedis.flushDB();


        // 删除所有数据库中的所有key，此方法不会失败。更加慎用
        //jedis.flushAll();
    }
}
