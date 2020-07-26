package lesson01;

public class Demo {

	public static void main(String[] args) {
		int[] arr = {1,2,5,7,11,15,16};
		int target = 18;
		twoSum(arr, target);
	}
	
	public static void twoSum(int[] arr, int target) {
		for (int i = 0; i < arr.length-1; i++) {
			if (arr[i] + arr[i+1] == target) {
//				System.out.println(arr[i]+";;;"+(i+1));
//				System.out.println(arr[i+1]+";;;"+(i+2));
				System.out.println((i+1)+"\t"+(i+2));
				System.out.println(i+2);
			}
		}
	}
}