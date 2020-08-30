package thread;

public class Test2 {
    static volatile int j = 0;

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 50; i++) {
                j++;
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 50; i++) {
                j++;
            }
        });
        Thread t3 = new Thread(()->{
            for (int i = 0; i < 50; i++) {
                j++;
            }
        });

        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(j);
    }
}