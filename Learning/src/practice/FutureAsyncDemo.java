package practice;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureAsyncDemo {

    static ExecutorService executorService = Executors.newFixedThreadPool(100);

    //计算文章得分
    public static int getArticleScore(String aName){

        //开启一个异步任务
        Future<Integer> futureA = executorService.submit(new CalculateArticleScoreA());
        Future<Integer> futureB = executorService.submit(new CalculateArticleScoreB());
        Future<Integer> futureC = executorService.submit(new CalculateArticleScoreC());


        doSomeThings();

        //获取异步任务的执行结果
        Integer a = null;
        try {
            a = futureA.get();
        } catch (InterruptedException e) {
            futureA.cancel(true);
            e.printStackTrace();
        } catch (ExecutionException e) {
            futureA.cancel(true);
            e.printStackTrace();
        }

        Integer b = null;
        try {
            b = futureB.get();
        } catch (InterruptedException e) {
            futureB.cancel(true);
            e.printStackTrace();
        } catch (ExecutionException e) {
            futureB.cancel(true);
            e.printStackTrace();
        }

        Integer c = null;
        try {
            c = futureC.get();
        } catch (InterruptedException e) {
            futureC.cancel(true);
            e.printStackTrace();
        } catch (ExecutionException e) {
            futureC.cancel(true);
            e.printStackTrace();
        }
        Future<Integer> futureD = executorService.submit(()->{
            TimeUnit.SECONDS.sleep(1);
            System.out.println("futureD");
            return 1;
        });


//        try {
//            futureD.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
        System.out.println("000000000000");

        executorService.shutdown();

        return a+b+c;

    }

    private static void doSomeThings() {

        System.out.println(" main do some things");
    }

    private static class CalculateArticleScoreA implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            //业务操作
            Random random = new Random();

            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName()+"A");
            return random.nextInt(100);
        }
    }

    private static class CalculateArticleScoreB implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            //业务操作
            Random random = new Random();

            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName()+"B");
            return random.nextInt(100);
        }

    }

    private static class CalculateArticleScoreC implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            //业务操作
            Random random = new Random();

            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName()+"C");
            return random.nextInt(100);
        }

    }

    public static void main(String[] args) {

        System.out.println(getArticleScore("demo"));
        System.exit(0);
    }
}
