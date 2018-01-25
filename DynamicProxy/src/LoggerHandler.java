import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//可以复用的中间类.告诉代理类加的方法写在什么地方,专门添加日志用
public class LoggerHandler implements InvocationHandler {

    private Subject realSubject;
    //这里用的是接口,所以可以复用.
    public LoggerHandler(Subject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在代理真实对象前我们可以添加一些自己的操作
        System.out.println("before rent house");
        System.out.println("Method:" + method);
        //当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
        method.invoke(realSubject, args);
        //　　在代理真实对象后我们也可以添加一些自己的操作
        System.out.println("after rent house");
        return null;
    }
}
