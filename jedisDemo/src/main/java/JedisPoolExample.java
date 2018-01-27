import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisPoolExample {
    public static void main(String[] args)
    {
        JedisPool jedisPool =new JedisPool("127.0.0.1",6379);
        Jedis jedis1 =jedisPool.getResource();
        jedis1.set("corning","123");
        jedis1.close();

    }
}
