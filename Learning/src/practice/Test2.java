package practice;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//怎么实现一次打印出10个数据，并且执行完，再执行其他的任务呢？？
public class Test2 {
    public static ExecutorService executorService = Executors.newCachedThreadPool();
    private static CountDownLatch cdl = new CountDownLatch(1);
    private static final Random random = new Random();

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
        new Test2().test();
        System.out.println("执行其他任务");
        executorService.shutdown();

    }

    class ThreadTest implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("开始插入数据");
            int randomNum = random.nextInt(10000);
            Thread.sleep(randomNum);
            cdl.countDown();
            return randomNum;
        }
    }
}