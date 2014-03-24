package theindianjob;

import java.util.Scanner;

public class Solution {

	private static boolean isSubsetInRange(int[] set, int n, int fromSum, int toSum) {
		boolean[][] subset = new boolean[toSum + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			subset[0][i] = true;
		}

		for (int i = 1; i <= toSum; i++) {
			subset[i][0] = false;
		}

		for (int i = 1; i <= toSum; i++) {
			for (int j = 1; j <= n; j++) {
				subset[i][j] = subset[i][j - 1];
				if (i >= set[j - 1]) {
					subset[i][j] = subset[i][j] || subset[i - set[j - 1]][j - 1];
				}
			}
		}
		
		boolean result = false;
		for (int sum = toSum; sum >= fromSum; sum--) {
			if (subset[sum][n]) {
				result = true;
				break;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while (t-- > 0) {
			int length = scanner.nextInt();
			int g = scanner.nextInt();
			int[] time = new int[length];
			int sum = 0;
			for (int i = 0; i < length; i++) {
				time[i] = scanner.nextInt();
				sum += time[i];
			}

			boolean result = false;
			if (sum <= 2 * g) {
				result = isSubsetInRange(time, length, (sum - g) / 2, g);
			}
			System.out.println(result ? "YES" : "NO");
		}
	}

}
