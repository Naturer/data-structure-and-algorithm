package 线程;

public class VolatileExample {
    int              x = 0;
    boolean v = false;

    public void writer() {
        x = 42;
        v = true;
    }

    public void reader() {
        if (v == true) {
            // 这里x会是多少呢
            System.out.println(x);
        }
        System.out.println(x);
        System.out.println(v);
    }

    public static void main(String[] args) {
        VolatileExample a = new VolatileExample();
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                a.writer();
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override 
            public void run() {
                a.reader();
            }
        });
        t2.start();
        t1.start();
    }
}