package thread;

/**
 * InheritableThreadLocal，子线程可以获取主线程，即main线程的副本值。
 */
public class InheritableThreadLocalDemo {

    private static InheritableThreadLocal<String> local = new InheritableThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        local.set("Main");
        new ThreadA().start();
        new ThreadB().start();
        Thread.sleep(1000);
        System.out.println(local.get());
    }

    static class ThreadA extends Thread{

        public void run() {
            local.set("ThreadA");
            System.out.println(local.get());
        }
    }

    static class ThreadB extends ThreadA{

        public void run() {
            local.set("ThreadB");
            System.out.println(local.get());
        }
    }
}
