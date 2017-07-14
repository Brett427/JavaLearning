/**
 * Created by brett on 2017/7/14.
 */
public class test {
    public static void main(String args[])
    {
        Provience beijing =new Provience(1,"beijing");
        Provience henan = new Provience(2,"henan");
        City fengtai =new City(01,"fengtai");
        City dongcheng =new City(02,"dongcheng");
        City qinghua =new City(03,"qinghua");
        City jiaozuo =new City(04,"jiaozuo");
        City hebi =new City(05,"hebi");
        City xinxiang =new City(06,"xinxiang");
        City zhengzhou =new City(07,"zhengzhou");

        fengtai.setPro(beijing);
        dongcheng.setPro(beijing);
        qinghua.setPro(beijing);
        jiaozuo.setPro(henan);
        hebi.setPro(henan);
        xinxiang.setPro(henan);
        zhengzhou.setPro(henan);
        beijing.setCitys(new City[]{fengtai,dongcheng,qinghua});
        henan.setCitys(new City[]{jiaozuo,hebi,xinxiang,zhengzhou});

        for(int i=0;i<beijing.getCitys().length;i++)
        {
            System.out.println("beijing: City"+beijing.getCitys()[i].getCid()+" "+beijing.getCitys()[i].getName());
        }
        System.out.println(fengtai.getPro().getName());
    }
}
