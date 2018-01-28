import redis.clients.jedis.Jedis;
import redis.clients.jedis.SortingParams;

import java.util.List;

public class sortExample {
    //list数字升序和降序排序
    private static void sort1()
    {
        Jedis jedis =new Jedis("127.0.0.1",6379);
        jedis.flushDB();
        jedis.lpush("mylist","1");
        jedis.lpush("mylist","0");
        jedis.lpush("mylist","4");
        jedis.lpush("mylist","6");
        jedis.lpush("mylist","3");
        List<String> mylist =jedis.sort("mylist"); //默认是升序

        SortingParams sortingParams =new SortingParams();
        sortingParams.desc(); //改为降序.

        System.out.println(mylist); // 升序输出
        System.out.println(jedis.sort("mylist",sortingParams)); //传递参数后,降序输出.
    }
    //list字母升序和降序排序
    private static void sort2()
    {
        Jedis jedis =new Jedis("127.0.0.1",6379);
        jedis.flushDB();
        jedis.lpush("mylistA","as");
        jedis.lpush("mylistA","aa");
        jedis.lpush("mylistA","fd");
        jedis.lpush("mylistA","tr");
        jedis.lpush("mylistA","3gdf");

        SortingParams sortingParams =new SortingParams();
        sortingParams.alpha();//加上后对字母升序排序
        sortingParams.desc();//不加是升序,加上后对字母降序排序.

        System.out.println(jedis.sort("mylistA",sortingParams));
    }

    //list结合hash的排序
    private static void sort3()
    {
        Jedis jedis =new Jedis("127.0.0.1",6379);
        jedis.flushDB();
        jedis.lpush("userlist", "33");
        jedis.lpush("userlist", "22");
        jedis.lpush("userlist", "55");
        jedis.lpush("userlist", "11");
        jedis.lpush("userlist", "66");

        jedis.hset("user:66", "name", "66");
        jedis.hset("user:55", "name", "55");
        jedis.hset("user:33", "name", "33");
        jedis.hset("user:22", "name", "22");
        jedis.hset("user:11", "name", "11");
        jedis.hset("user:11", "add", "beijing");
        jedis.hset("user:22", "add", "shanghai");
        jedis.hset("user:33", "add", "guangzhou");
        jedis.hset("user:55", "add", "chongqing");
        jedis.hset("user:66", "add", "xi'an");

        jedis.hset("hhh:post:66", "name", "66");
        jedis.hset("hhh:post:55", "name", "55");
        jedis.hset("hhh:post:33", "name", "33");

        SortingParams sortingParams =new SortingParams();
        // 符号 "->" 用于分割哈希表的键名(key name)和索引域(hash field)，格式为 "key->field" 。
        //        SORT
        //        根据给定的选项，对输入的列表、集合或者有序集合进行排序，然后返回或者春初排序的结果。
        //        GET ：外部数据，用作命令的返回值；
        //        ASC|DESC ：正序、反序；
        //        ALPHA ：安装字母顺序；
        sortingParams.by("user:*->name");
        sortingParams.get("user:*->add");
        sortingParams.get("user:*->name");

        List<String> strings =jedis.sort("userlist",sortingParams);

        for(String item: strings)
        {
            System.out.println(item);
            System.out.println("***");
        }
    }
    //SET 结合string 的排序
    private static void sort4() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.flushDB();
        jedis.sadd("tom:friend:list", "123");
        jedis.sadd("tom:friend:list", "456");
        jedis.sadd("tom:friend:list", "789");
        jedis.sadd("tom:friend:list", "101");

        // 好友对应的成绩
        jedis.set("score:uid:123", "1000");
        jedis.set("score:uid:456", "6000");
        jedis.set("score:uid:789", "100");
        jedis.set("score:uid:101", "5999");

        // 好友的详细信息
        jedis.set("uid:123", "{'uid':123,'name':'lucy'}");
        jedis.set("uid:456", "{'uid':456,'name':'jack'}");
        jedis.set("uid:789", "{'uid':789,'name':'jay'}");
        jedis.set("uid:101", "{'uid':101,'name':'jolin'}");

        SortingParams sortingParameters = new SortingParams();
        sortingParameters.get("#");
        sortingParameters.desc();
        sortingParameters.get("uid:*");
        sortingParameters.get("score:uid:*");
        sortingParameters.by("score:uid:*");
        // 对应的redis 命令是./redis-cli sort tom:friend:list by score:uid:* get # get
        // uid:* get score:uid:*
        List<String> result = jedis.sort("tom:friend:list", sortingParameters);
        for (String item : result) {
            System.out.println("item..." + item);
        }
    }

    public List<String> get_latest_comments(int start, int num_items){
        //获取最新评论
        //LPUSH latest.comments <ID>
        //-我们将列表裁剪为指定长度，因此Redis只需要保存最新的5000条评论：
        //LTRIM latest.comments 0 5000
        //们做了限制不能超过5000个ID，因此我们的获取ID函数会一直询问Redis。只有在start/count参数超出了这个范围的时候，才需要去访问数据库。
        Jedis jedis = new Jedis("127.0.0.1",6379);
        List<String> id_list = jedis.lrange("latest.comments",start,start+num_items-1) ;

        if(id_list.size()<num_items){
            //id_list = SQL.EXECUTE("SELECT ... ORDER BY time LIMIT ...");
        }
        return id_list;
    }

    public static void main(String[] args)
    {
        sort3();
    }
}
