package 线程;

public class QQ {

    public static void main(String[] args) {
        Object oo = new Object();

        Thread thread1 = new MyThread("thread1 -- ", oo);
        thread1.start();

        synchronized (thread1) {
            for (int i = 0; i < 100; i++) {
                if (i == 20) {
                    try {
//                        oo.wait();
                        thread1.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " -- " + i);
            }
        }
    }

}

class MyThread extends Thread {

    private String name;
    private Object oo;

    public MyThread(String name, Object oo) {
        this.name = name;
        this.oo = oo;
    }

    @Override
    public void run() {
        synchronized (oo) {
            for (int i = 0; i < 100; i++) {
                System.out.println(name + i);
            }
            oo.notifyAll();
        }
    }

}
