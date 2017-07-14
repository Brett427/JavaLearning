/**
 * Created by brett on 2017/7/14.
 */
public class Provience {
    private int pid;
    private String name;
    private City citys[];
    public Provience(int pid,String name)
    {
        this.pid = pid;
        this.name = name;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public City[] getCitys(){
        return this.citys;
    }
    public void setCitys(City acitys[])
    {
       this.citys=acitys;
    }
}
