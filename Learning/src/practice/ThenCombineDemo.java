package practice;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThenCombineDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        //异步任务1
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {

//            System.out.println("future1:" + Thread.currentThread().getName());
            return "hello";
        }, executorService);

        //异步任务2
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {

            System.out.println("future2:" + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future2 end");
            return "itheima";
        }, executorService).thenCombineAsync(future1,(f1,f2)-> {
            System.out.println("thenCombine");
            return f1 + f2;
        },executorService);

//        TimeUnit.SECONDS.sleep(3); //如果让主线程执行的时间大于线程2执行的，则可以打印出“thenCombine”
        System.out.println("main end");
        executorService.shutdown();
        //当多个异步任务【全部】执行完毕后，触发后续的任务处理
//        CompletableFuture<String> future = future1.thenCombineAsync(future2, (f1, f2) -> {
//
//            System.out.println(Thread.currentThread().getName());
//            return f1 + " " + f2;
//        },executorService);
//
//        System.out.println(future.get());

        executorService.shutdown();
    }
}
