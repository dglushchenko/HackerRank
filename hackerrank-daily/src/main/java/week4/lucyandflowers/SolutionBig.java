package week4.lucyandflowers;

import java.math.BigInteger;
import java.util.Scanner;

public class SolutionBig {

	private static final int MOD = 1000000009;
	
	public static void fillCatalanNumbers(BigInteger[] catalanNumbers) {
		catalanNumbers[0] = BigInteger.ONE;
		for (int i = 1; i < catalanNumbers.length; i++) {
			BigInteger catalanNumber = BigInteger.ZERO;
			for (int j = 0; j < i; j++) {
				catalanNumber = catalanNumber.add(catalanNumbers[j].multiply(catalanNumbers[i - j - 1]));
			}
			catalanNumbers[i] = catalanNumber;
		}
	}
	
	public static void fillFactorials(BigInteger[] factorials) {
		factorials[0] = BigInteger.ONE;
		for (int i = 1; i < factorials.length; i++) {
			factorials[i] = factorials[i - 1].multiply(BigInteger.valueOf(i));
		}
	}
	
	public static BigInteger numberOfCombinations(BigInteger[] factorials, int n, int k) {
		return factorials[n].divide(factorials[n - k].multiply(factorials[k]));
	}
	
	private static int solve(BigInteger[] catalanNumbers, BigInteger[] factorials, int n) {
		BigInteger result = BigInteger.ZERO;
		for (int i = 1; i <= n; i++) {
			result = result.add(catalanNumbers[i].multiply(numberOfCombinations(factorials, n, i)));
		}
		return result.mod(BigInteger.valueOf(MOD)).intValue();
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
		BigInteger[] catalanNumbers = new BigInteger[max + 1];
		fillCatalanNumbers(catalanNumbers);
		BigInteger[] factorials = new BigInteger[max + 1];
		fillFactorials(factorials);
		for (int i = 0; i < t; i++) {
			System.out.println(solve(catalanNumbers, factorials, nArray[i]));
		}
	}

}
