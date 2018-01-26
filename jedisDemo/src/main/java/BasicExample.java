import redis.clients.jedis.Jedis;

public class BasicExample {
    public static void main(String[] args)
    {
        Jedis jedis =new Jedis("127.0.0.1",6379);
        jedis.set("name","wkn");
        String ss =jedis.get("name");
        System.out.println(ss);

        jedis.append("name","brett");
        ss =jedis.get("name");
        System.out.println(ss);

        //直接覆盖
        jedis.set("name","wangkangning");
        System.out.println(jedis.get("name"));

        //删除key对应记录
        jedis.del("name");
        System.out.println(jedis.get("name"));

        jedis.mset("name","wkn","age","22");
        System.out.println(jedis.mget("name","age"));
    }
}
