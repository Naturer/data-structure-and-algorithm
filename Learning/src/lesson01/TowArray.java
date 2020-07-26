package lesson01;

public class TowArray {
	public static void main(String[] args) {
		int[][] arr = { { 12, 23, 45 }, { 52, 32, 12 } };

		/*
		 * ���ַ��������ά���� for(int i=0;i<arr.length;i++) { for(int
		 * j=0;j<arr[0].length;j++) { System.out.print(arr[i][j]+"\t"); }
		 * System.out.println(); }
		 */

		for (int[] temp : arr) {
			for (int a : temp) {
				System.out.print(a + "\t");
			}
			System.out.println();
		}
	}
}