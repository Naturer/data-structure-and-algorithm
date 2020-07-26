
public class Demo1 {

	public static void main(String[] args) {
	    int ii = 1;
	    for (; ii <= 3; ii++) {
	        
	    }
	    System.out.println(ii);
	    System.out.println(("1").equals("1") && (("1").equals("1") || ("1").equals("12")));
		int count = 0;
		for (int i = 2,j; i <= 100; i++) {
			int k = i/2;
			for (j = 2; j <= k; j++) {
				if (i % j == 0) {
					break;
				}
			}
			if (j > k) {
				count = count + i;
			}
		}
		System.out.println(count);// 1060
	}
}
