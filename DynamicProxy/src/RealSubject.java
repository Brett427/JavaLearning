public class RealSubject implements Subject {

    @Override
    public void rent() {
        System.out.println("rent ");
    }

    @Override
    public void hello(String str) {
        System.out.println("hellooooo");
    }
}
