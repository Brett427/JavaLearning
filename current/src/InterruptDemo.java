public class InterruptDemo {
    public static class Thread3 extends Thread{
        public void run(){
            while(true){
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("Someone interrupted me.");
                }
                else{
                    System.out.println("Thread is Going...");
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread3 t = new Thread3();
        t.start();
        Thread.sleep(3000);
        t.interrupt();
        System.out.println(Thread.interrupted());
        //Thread.interrupted()等于 Thread.currentThread().isInterrupted().
    }
}
