package practice;

import java.util.concurrent.TimeUnit;

public class JoinTest {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(()->{
            int i = 5;
            while (i-- > 0){
                System.out.println(1);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(()->{
            int i = 10;
            while (i-- > 0){
                System.out.println(2);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();

        for (int i = 0; i <= 2; i++) {
            if (i == 1){
                System.out.println("启动t1.join()");
                t1.join();
                System.out.println("完成t1.join()");
            }
            if (i == 2){
                System.out.println("启动t2.join()");
                t2.join();
                System.out.println("完成t2.join()");
            }
        }

        System.out.println("end");
    }
}
