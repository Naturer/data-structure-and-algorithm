package 线程;

public class AB线程轮流执行 {
    private static  int signal = 0;
    private static  boolean flag;
    static class ThreadA implements Runnable {
        @Override
        public void run() {
            while (signal < 100) {
                if (flag) {
                    System.out.println("threadA: " + signal);
                    synchronized (this){
                        signal++;
                    }
                    flag = false;
                }
            }
        }
    }
    static class ThreadB implements Runnable {
        @Override
        public void run() {
            while (signal < 100) {
                if (!flag) {
                    System.out.println("threadB: " + signal);
                    synchronized (this){
                        signal++;
                    }
                    flag = true;
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        Thread.sleep(1000);
        new Thread(new ThreadB()).start();
    }
}
