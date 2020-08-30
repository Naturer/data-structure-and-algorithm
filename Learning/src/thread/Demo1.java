package thread;

/**
 * 需求：让线程A输出0，然后线程B输出1，再然后线程A输出2…以此类推
 */
public class Demo1 {
    static int a = 0;
    public static void main(String[] args) {
        Object lock = new Object();
        m(lock);
        m(lock);
    }

    private static void m(Object lock) {
        new Thread(()->{
            while(a < 30){
                synchronized (lock) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "___" + a);
                        a++;
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
