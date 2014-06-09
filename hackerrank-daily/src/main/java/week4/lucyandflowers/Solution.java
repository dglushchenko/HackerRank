package week4.lucyandflowers;

import java.util.Scanner;

public class Solution {

	public static final int MOD = 1000000009;
	
	public static void fillCatalanNumbers(long[] catalanNumbers) {
		catalanNumbers[0] = 1;
		for (int i = 1; i < catalanNumbers.length; i++) {
			long catalanNumber = 0;
			for (int j = 0; j < i; j++) {
				catalanNumber = (catalanNumber + ((catalanNumbers[j] * catalanNumbers[i - j - 1]) % MOD)) % MOD;
			}
			catalanNumbers[i] = catalanNumber;
		}
	}
	
	public static void fillBinomial(long[][] binomial, int N) {
        // base cases
        for (int k = 1; k <= N; k++) binomial[0][k] = 0;
        for (int n = 0; n <= N; n++) binomial[n][0] = 1;

        // bottom-up dynamic programming
        for (int n = 1; n <= N; n++)
            for (int k = 1; k <= N; k++)
                binomial[n][k] = (binomial[n-1][k-1] + binomial[n-1][k]) % MOD;
	}

	public static long numberOfCombinations(long[][] binomial, int N, int K) {
        return binomial[N][K];
	}	
	
	public static long solve(long[] catalanNumbers, long[][] binomial, int n) {
		long result = 0;
		for (int i = 1; i <= n; i++) {
			result = (result + ((catalanNumbers[i] * numberOfCombinations(binomial, n, i)) % MOD)) % MOD;
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int max = 0;
		int[] nArray = new int[t];
		for (int i = 0; i < t; i++) {
			nArray[i] = in.nextInt();
			max = Math.max(max, nArray[i]);
		}
		long[] catalanNumbers = new long[max + 1];
		fillCatalanNumbers(catalanNumbers);
		long[][] binomial = new long[max + 1][max + 1];
		fillBinomial(binomial, max);
		for (int i = 0; i < t; i++) {
			System.out.println(solve(catalanNumbers, binomial, nArray[i]));
		}
	}

}
