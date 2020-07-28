package 线程;

public class Test {
    static volatile int j = 0;

    public static void main(String[] args) {

        test1();
    }

    private static void test1() {
        for (int a = 0; a < 50; a++) {
            j = 0;
            do {
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
            } while (j == 150);
            System.out.println(j);
        }
    }
}
