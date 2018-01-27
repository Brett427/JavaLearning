import redis.clients.jedis.Jedis;

import java.util.List;

public class ListExample {
    public static void main(String[] args)
    {
        Jedis jedis =new Jedis("127.0.0.1",6379);
        jedis.del("messages");
        jedis.rpush("messages","hello how are you");
        jedis.rpush("messages","i am fine");
        jedis.rpush("messages","thank you");

        //取出所有数据
        List<String> values =jedis.lrange("messages",0,-1);
        System.out.println(values);
        // 数组长度
        System.out.println(jedis.llen("messages"));

        // 修改单个的值
        System.out.println(jedis.lset("messages",0,"hhhhhh"));

        //获取指定下标的值
        System.out.println(jedis.lindex("messages",0));

        // 删除指定下标的值
        System.out.println(jedis.lrem("messages",0,"hhhhhh")); //既给坐标又给值.
        //删除区间之外的值.
        System.out.println(jedis.ltrim("messages",0,1));
        //列表出栈.
        jedis.lpop("messages");


    }
}
