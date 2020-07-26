package lesson01.thread;

import java.util.ArrayList;

public class MyTest {

	public static int syncCount = 0;
	public static int count = 0;
	
	public static void main(String[] args) {
		ArrayList<Thread> threadList = new ArrayList<Thread>();
		for (int i = 0; i < 100; i++) {
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					for (int j = 0; j < 10000; j++) {
						synchronized (MyTest.class) {
							syncCount++;
						}
						count++;
					}
				}
			});
			threadList.add(thread);
			thread.start();
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = 0; i < threadList.size(); i++) {
			try {
//				threadList.get(i).start();//为什么start放在这里，count的值就是1000000？？
//				threadList.get(i).join();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("syncCount = "+syncCount+", count = "+count);
	}
}
