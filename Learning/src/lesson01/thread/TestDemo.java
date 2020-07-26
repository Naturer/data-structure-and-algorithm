package lesson01.thread;

public class TestDemo {
	public static void main(String[] args) throws InterruptedException {
		MyThread myThread = new MyThread();
		System.out.println("before");
		myThread.start();
		synchronized (myThread) {
			myThread.wait();
			myThread.notify();
		}
//		myThread.wait();
		System.out.println("after");
		synchronized (myThread) {
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