public class Hello {

    private String name;
    private Integer age;
    private String xingbie;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getXingbie() {
        return xingbie;
    }

    public void setXingbie(String xingbie) {
        this.xingbie = xingbie;
    }

    public Hello(String name, Integer age, String xingbie) {
        this.name = name;
        this.age = age;
        this.xingbie = xingbie;
    }

    public Hello() {
    }

    public String method1(String a)
    {
        System.out.println(a);
        System.out.println("1111");
        return "11";
    }

    public void method2()
    {
        System.out.println("222");
    }


    @Override
    public String toString() {
        return "Hello{" +
                "name=123'" + name + '\'' +
                ", age=" + age +
                ", xingbie='" + xingbie + '\'' +
                '}';
    }
}
