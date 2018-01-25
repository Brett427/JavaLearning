import redis.clients.jedis.Jedis;

public class test {
    public static void main(String[] args)
    {
        Jedis jedis =new Jedis("127.0.0.1",6379);
        jedis.set("hello","world");
        String value =jedis.get("hello");
        System.out.println(value);
    }
}
