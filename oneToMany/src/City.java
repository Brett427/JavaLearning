/**
 * Created by brett on 2017/7/14.
 */
public class City {
    private int cid;
    private String name;
    private Provience pro;
    public City(int cid,String name)
    {
        this.cid = cid;
        this.name = name;
    }
    public int getCid()
    {
        return this.cid;
    }
    public String getName()
    {
        return this.name;
    }
    public void setCid(int cid)
    {
        this.cid=cid;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public void setPro(Provience pro)
    {
        this.pro=pro;
    }
    public Provience getPro()
    {
        return this.pro;
    }
}
