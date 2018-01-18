import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicINtegerFieldUpdaterDemo {
    public static class User
    {
        private String name;
        public volatile int old;

        public User(String name,int old)
        {
            this.name=name;
            this.old=old;
        }

        public String getName() {
            return name;
        }

        public int getOld() {
            return old;
        }
    }

    private static AtomicIntegerFieldUpdater<User> a =AtomicIntegerFieldUpdater.newUpdater(User.class,"old");

    public static void main(String[] args)
    {
        User conna =new User("comna",10);
        System.out.println(a.getAndIncrement(conna));
        System.out.println(a.get(conna));
    }
}
