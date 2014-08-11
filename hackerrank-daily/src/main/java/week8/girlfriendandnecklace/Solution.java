package week8.girlfriendandnecklace;

import java.util.Scanner;

public class Solution {

	private static final long[][] FIRST = new long[][] { { 0, 0, 1 }, { 1, 0, 0 }, { 0, 1, 1 } };

	private static final int MOD = 1000000007;

	private static final int MATRIX_SIZE = 3;

	private static final int NUMBER_OF_MATRIXES = 64;

	private static long[][][] matrixes = new long[NUMBER_OF_MATRIXES][MATRIX_SIZE][MATRIX_SIZE];

	private static long[][] multilply(long[][] a, long[][] b) {
		long[][] result = new long[MATRIX_SIZE][MATRIX_SIZE];
		for (int i = 0; i < MATRIX_SIZE; i++) {
			for (int j = 0; j < MATRIX_SIZE; j++) {
				for (int k = 0; k < MATRIX_SIZE; k++) {
					result[i][j] = (result[i][j] + (a[i][k] % MOD) * (b[k][j] % MOD)) % MOD;
				}
			}
		}
		return result;
	}

	private static void generateMatrixes() {
		matrixes[0] = FIRST;
		//print(matrixes[0]);
		for (int i = 1; i < NUMBER_OF_MATRIXES; i++) {
			matrixes[i] = multilply(matrixes[i - 1], matrixes[i - 1]);
			//print(matrixes[i]);
		}
	}

	private static void print(long[][] matrix) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < MATRIX_SIZE; i++) {
			for (int j = 0; j < MATRIX_SIZE; j++) {
				sb.append(matrix[i][j]);
				if (j + 1 < MATRIX_SIZE) {
					sb.append(", ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static int solve(long n) {
		long mask = 1;
		int shift = 0;
		long[][] result = new long[3][3];
		boolean first = true;
		while (shift < 64) {
			mask = 1L << shift;
			if ((mask & n) == mask) {
				if (first) {
					result = matrixes[shift];
					first = false;
				} else {
					result = multilply(result, matrixes[shift]);
				}
			}
			shift++;
		}
		//print(result);
		return (int) ((result[2][0] + result[2][1] + result[2][2]) % MOD);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			int t = in.nextInt();
			generateMatrixes();
			while (t-- > 0) {
				long n = in.nextLong();
				System.out.println(solve(n));
			}
		} finally {
			in.close();

		}

	}

}
