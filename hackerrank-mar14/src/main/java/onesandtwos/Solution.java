package onesandtwos;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	private static final BigInteger TWO = BigInteger.valueOf(2);

	public static double lg(double x) {
		return Math.log(x) / Math.log(2);
	}

	private static int findR(int a, int b) {
		int c = a + 2 * b + 1;
		for (int r = 1; r <= b; r++) {
			if (r >= lg(c - 2 * r)) {
				return r;
			}
		}
		throw new IllegalStateException("a = " + a + ", b = " + b);
	}

	private static int findK(int b) {
		for (int k = 1; k <= b; k++) {
			if (lg(b - k) + 1 < k) {
				return k;
			}
		}
		throw new IllegalStateException("b = " + b);
	}

	public static BigInteger calculateBig(int a, int b) {
		BigInteger result = BigInteger.ZERO;

		BigInteger bigA = BigInteger.valueOf(a);

		if (a > 0 && b > 0) {
			if (bigA.compareTo(TWO.pow(b).subtract(BigInteger.ONE)) >= 0) {
				result = TWO.pow(b).add(bigA);
			} else {
				int r = findR(a, b);
				int n = b - r;
				BigInteger bigN = BigInteger.valueOf(n);
				result = TWO.pow(r).add(bigN.add(bigA).multiply(bigN.add(BigInteger.ONE))).add(bigN);
			}
		} else if (a > 0) {
			result = bigA;
		} else if (b > 0) {
			int k = findK(b);
			int n = b - k;
			BigInteger bigN = BigInteger.valueOf(n);
			result = bigN.multiply(bigN.add(BigInteger.valueOf(3))).divide(TWO).add(TWO.pow(k - 1));
		}

		return result;
	}

	public static int calculateBruteForce(int a, int b) {
		Set<BigInteger> expressions = new HashSet<BigInteger>();

		// Two, multiply and add
		for (int i = 1; i <= b; i++) {
			BigInteger value = TWO.pow(i);
			expressions.add(value);
			for (int j = a; j >= 1; j--) {
				expressions.add(value.add(BigInteger.valueOf(j)));
			}
			for (int j = b - i; j >= 1; j--) {
				BigInteger otherValue = value.add(TWO.multiply(BigInteger.valueOf(j)));
				expressions.add(otherValue);
				for (int k = a; k >= 1; k--) {
					expressions.add(otherValue.add(BigInteger.valueOf(k)));
				}
			}
		}

		// Ones
		for (int i = 1; i <= a; i++) {
			expressions.add(BigInteger.valueOf(i));
		}

		addMoreCases(b, 0, expressions);

		return expressions.size();
	}

	public static void addMoreCases(int b, int subSum, Set<BigInteger> expressions) {
		for (int i = 1; i <= b; i++) {
			subSum += (int) Math.pow(2, i);
			expressions.add(BigInteger.valueOf(subSum));
			if (b - i > 0) {
				addMoreCases(b - i, subSum, expressions);
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while (t-- > 0) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();

			System.out.println(calculateBig(a, b).mod(BigInteger.valueOf(1000000007)).intValue());
		}
	}

}
