package lesson01.thread;

public class TestDemo1 {
	public static void main(String[] args) throws InterruptedException {
		MyThread myThread = new MyThread();
		System.out.println("before");
		myThread.start();
		System.out.println("after");
		for (int i = 0; i < 1000; i++) {
			System.out.println(i);
		}
	}

	static class MyThread extends Thread {
		public void run() {
			synchronized (this) {
				for (int i = 0; i < 3; i++) {
					System.out.println("number:" + i);
				}
			}
		}
	}
}