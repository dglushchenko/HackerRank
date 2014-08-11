package week8.johnandgcdlist;

import java.util.Scanner;

public class Solution {

	private static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	private static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	public static int[] solve(int[] array) {
		int[] result = new int[array.length + 1];
		result[0] = array[0];
		result[array.length] = array[array.length - 1];
		for (int i = 0; i < array.length - 1; i++) {
			int a = array[i];
			int b = array[i + 1];
			result[i + 1] = lcm(a, b);
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			int t = in.nextInt();
			while (t-- > 0) {
				int n = in.nextInt();
				int[] array = new int[n];
				for (int i = 0; i < n; i++) {
					array[i] = in.nextInt();
				}
				int[] result = solve(array);
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < result.length; i++) {
					sb.append(result[i]);
					if (i + 1 < result.length) {
						sb.append(" ");
					}
				}
				System.out.println(sb.toString());
			}
		} finally {
			in.close();
		}
	}

}
