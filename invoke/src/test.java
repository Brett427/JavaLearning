import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class test {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //三种反射方式
        /************************************/
        try {
            Class<?> h2 =Class.forName("Hello");
            //找到了封装的Class类对象.
            h2.getConstructors();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /*************************************/
        Class<?> h = Hello.class;
        //找到了封装的Class类对象.
        h.getConstructors();
        try {
            Object obj =h.newInstance();
            // obj 是一个hello的对象.
            System.out.println(obj.toString());
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        /*************************************/
        Hello hello =new Hello();
        Class<?> c = hello.getClass();
        //找到了封装的Class类对象.

        try {//找到有三个参数的构造函数
            Constructor c1 =c.getConstructor();
            try {
                Hello hhh = (Hello) c1.newInstance();//实例化对象
                System.out.println(hhh.toString());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.println(c.isInstance(hello));


        //反射方法
        Hello hello1 =new Hello();
        Class<?> t = hello.getClass();//找到了封装的Class类对象.
        try {
            Method m = t.getMethod("method1",String.class);//method1 是方法的名字
            try {
                try {
                    Hello hello2 = (Hello) t.newInstance();
                    Object re =   m.invoke(hello2,"sss");
                    System.out.println(re);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //反射作用域
        Hello hello3 =new Hello();
        Class<?> t3 = hello.getClass();//找到了封装的Class类对象.
        Field f = t3.getDeclaredField("name");
        f.setAccessible(true); //要先设置这个
        f.set(hello3,"123");
        System.out.println(hello3.toString());
    }
}
