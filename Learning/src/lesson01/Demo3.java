package lesson01;

public class Demo3 {

	public static void main(String[] args) {
		int[] a = { 10, 9, 2, 5, 3, 7, 101, 18 };
		int findLongest = findLongest(a, a.length);
		System.out.println(findLongest);
	}

	public static int findLongest(int[] A, int n) {
		int[] B = new int[n + 1];
		B[1] = A[0];
		int len = 1, start = 0, end = len, mid;
		int aaa;
		for (int i = 1; i < n; i++) {
			if (A[i] > B[len]) {
				len++;
				B[len] = A[i];
			} else {
				start = 1;
				end = len;
				while (start <= end) {
					mid = (start + end) / 2;
					if (B[mid] < A[i])
						start = mid + 1;
					else
						end = mid - 1;
				}
				B[start] = A[i];
			}
		}
		return len;
	}
}
