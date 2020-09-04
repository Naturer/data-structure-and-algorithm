package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class Practice {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        m1();
//        m2();
    }

    private static void m2() {
        throw new AbstractMethodError();
    }

    //使用Callable创建线程
    private static void m1() throws ExecutionException, InterruptedException {
        MyCallable1 myCallable = new MyCallable1();
        FutureTask futureTask = new FutureTask(myCallable);
        futureTask.run();
        futureTask.run();
        Thread thread = new Thread(futureTask,"name");
        thread.start();
        String o = (String) futureTask.get();
        System.out.println(o);
        System.out.println("1212");
    }


}
class MyCallable1 implements Callable {

    @Override
    public Object call() throws Exception {
//        Thread.currentThread().setName("My callable Thread.");
        TimeUnit.SECONDS.toMillis(1);
        TimeUnit.SECONDS.sleep(2);
        System.out.println(Thread.currentThread().getName()+"===="+"线程执行");
        return "hello";
    }
}
