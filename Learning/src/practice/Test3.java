package practice;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//10个线程同时跑，main线程获取最先返回的结果。另外怎么用
public class Test3 {
    public static ExecutorService executorService = Executors.newCachedThreadPool();
    private static CountDownLatch cdl = new CountDownLatch(3);
    private static final Random random = new Random();
    private volatile static int result;

    public  void test(){
        Future<Integer>[] futures=new Future[10];
        for (int i = 0 ;i<10;i++)
            futures[i]=executorService.submit(new ThreadTest());
        for (int i = 0 ;i<10;i++) {
            int finalI = i;
            executorService.execute(()->{
                try {
                    Integer integer = futures[finalI].get();
                    System.out.println(integer);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });
        }
    }
    public static void main(String[] args) {
        new Test3().test();
        try {
            cdl.await();
            System.out.println("main 线程打印：" + result);
        } catch (InterruptedException e) {
        }
        executorService.shutdown();

    }

    class ThreadTest implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("开始插入数据");
            int randomNum = random.nextInt(10000);
            Thread.sleep(randomNum);
            cdl.countDown();
            synchronized (Test3.class){
                result = randomNum;
            }
            return randomNum;
        }
    }
}