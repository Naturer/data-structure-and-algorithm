package 线程;

public class VolatileExample {
    int     x = 0;
    boolean v = false;
    static boolean     check = false;

    public synchronized void writer() {
        x = 42;
        v = true;
        System.out.println(111);
    }

    public synchronized void reader() {
        if (v == true) {
            // 这里x会是多少呢
            System.out.println(x);
            if (x == 0) {
                check = true;
            }
        }
//        System.out.println(x + "____2");
//        System.out.println(v + "____3");
    }

    public static void main(String[] args) {
//        m1();
//        m2();
        m3();
    }

    private static void m3() {
        VolatileExample a = new VolatileExample();
        new Thread(a::writer).start();
    }

    private static void m1() {
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

    private static void m2() {
        do {
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
        //            try {
        //                t1.join();
        //                t2.join();
        //            } catch (InterruptedException e) {
        //                e.printStackTrace();
        //            }
//            try {
//                Thread.sleep(500l);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("___");
        } while (!check);
    }
}