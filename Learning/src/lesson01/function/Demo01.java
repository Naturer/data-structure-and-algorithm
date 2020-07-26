package lesson01.function;

public class Demo01 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
//		System.out.println(f(40l));
//		System.out.println(f2(40l));
		System.out.println(System.currentTimeMillis()-start);
	}
	
	public static long f(long n) {
		if (n == 1) {
			return 1;
		}else if (n == 2) {
			return 2;
		}else {
			return f(n - 1) + f(n - 2);
		}
	}
	public static long f2(long n) {
		long first = 1;
		long second = 2;
		long third = 0;
		for (int i = 3; i <= n; i++) {
			third = first + second;
			first = second;
			second = third;
		}
		return third;
	}
}
