package lesson01.thread.thread02;
public class ThreadJoinDemo {

    public static void main(String[] args) throws Exception {
        Thread threadA = new ThreadA();
        Thread threadB = new ThreadB(threadA);
        threadA.setName("threadA");
        threadB.setName("threadB");
        threadA.start();
        threadB.start();
        threadB.join();//main线程等B线程执行完毕，才会继续执行。
        System.out.println("全部线程执行完毕");
    }
}

class ThreadA extends Thread {

    @Override
    public void run() {
        System.out.println("当前线程是：" + Thread.currentThread());
        try {
            Thread.sleep(3 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ThreadB extends Thread {

    private Thread thread;

    ThreadB(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        System.out.println("当前线程是：" + Thread.currentThread());
        try {
            thread.join();
       /**
       *join的含义是等待线程终止。
             * 也就是说，threadB线程中如果调用threadA的join方法，则threadB在threadA执行完毕之前会发生阻塞，
             * 一直等待threadA执行完毕，threadB才会继续向下执行。
       */
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("线程" + thread.getName() +"执行完毕");
    }
}
