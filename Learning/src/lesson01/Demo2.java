package lesson01;

public class Demo2 {

	public static void main(String[] args) {
//		String word1 = "intention";
//		String word2 = "execution";
		String word1 = "horse";
		String word2 = "ros";
		int minDistance = minDistance(word1, word2);
		System.out.println(minDistance);
	}

	public static int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();

		// dp[i][j] 代表最小操作数（步骤），从 word1[0..i-1]转化为 word2[0..j-1].
		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			dp[i][0] = i;
		}

		for (int i = 0; i <= n; i++) {
			dp[0][i] = i;
		}
		for (int[] temp : dp) {
			for (int a : temp) {
				System.out.print(a + "\t");
			}
			System.out.println();
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
				}
			}
		}
		System.out.println("======");
		for (int i = 0; i <= n; i++) {
			dp[0][i] = i;
		}
		for (int[] temp : dp) {
			for (int a : temp) {
				System.out.print(a + "\t");
			}
			System.out.println();
		}

		return dp[m][n];
	}
}
