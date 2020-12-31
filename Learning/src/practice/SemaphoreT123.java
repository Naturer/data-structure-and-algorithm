package practice;

import java.util.concurrent.Semaphore;

public class SemaphoreT123 {

	public static void main(String[] args) {
		Print123Semaphore ps = new Print123Semaphore();
		
		// Lambda表达式来新建线程以及开启
        new Thread(()->ps.Print1()).start();
        
        new Thread(()->ps.Print2()).start();
        
        new Thread(()->ps.Print3()).start();
	}
	
}
	class Print123Semaphore{
		
		
		private Semaphore s1=new Semaphore(1);
		
		private Semaphore s2=new Semaphore(0);
		
		private Semaphore s3=new Semaphore(0);
		
		
		
		// 生成顺序
		public void Print1()
		{
			print("1",s1,s2);
		}
		
		
		public void Print2() {
			
			
			print("2",s2,s3);
		}
		
		public void Print3() {
			
			print("3",s3,s1);
		}
		
		// 首尾承接
		public void print(String name,Semaphore start,Semaphore end)
		{
			
			for(int i=0;i<10;i++) {
				
				try {
					
					start.acquire();
					
					System.out.println(Thread.currentThread().getName()+name);
					
					end.release();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		}
	}