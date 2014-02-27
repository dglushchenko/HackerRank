package expectation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solution {

	private static final BigInteger ZERO = BigInteger.valueOf(0);
	private static final BigInteger TWO = BigInteger.valueOf(2);
	private static final BigInteger THREE = BigInteger.valueOf(3);
	private static final BigInteger TEN = BigInteger.valueOf(10);

	private static int k;
	private static int n;

	private static void parseInput(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));

			String input = br.readLine();
			String[] split = input.split(" ");
			k = Integer.valueOf(split[0]);
			n = Integer.valueOf(split[1]);

		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	public static boolean isDivisibleByThree(BigInteger value) {
		BigInteger sum = ZERO;
		while (value.compareTo(ZERO) > 0) {
			sum = sum.add(value.mod(TEN));
			value = value.divide(TEN);
		}

		return sum.mod(THREE).equals(ZERO);
	}

	public static void reduce(BigInteger up, BigInteger down) {
		for (int i = down.intValue(); i > 1; i--) {
			BigInteger bigI = BigInteger.valueOf(i);
			if (up.mod(bigI).equals(ZERO)) {
				up = up.divide(bigI);
				down = down.divide(bigI);
			}
		}
	}

	private static void mock() {
		k = 1;
		n = 1000;
	}

	// if k = 1: E(n) = (2 / 3) * (n - 2)
	// if k > 1: E(n) = (2 * (n - 2)) ^ (k + 1) / ((3 ^ (k + 1)) * (k + 1))
	/*
	 * public static void main(String[] args) { //parseInput(args); mock();
	 * 
	 * BigInteger up = TWO.multiply(BigInteger.valueOf(n).subtract(TWO));
	 * BigInteger down = THREE; if (isDivisibleByThree(up)) { up =
	 * up.divide(THREE); down = BigInteger.valueOf(1); }
	 * 
	 * if (k > 1) { up = up.pow(k + 1); down = down.pow(k +
	 * 1).multiply(BigInteger.valueOf(k + 1)); }
	 * 
	 * reduce(up, down);
	 * 
	 * System.out.println(up + " / " + down); }
	 */

	// (2 / 3) * (n ^ k - 2)
	/*
	 * public static void main(String[] args) { //parseInput(args); mock();
	 * 
	 * BigInteger up = TWO.multiply(BigInteger.valueOf(n).pow(k).subtract(TWO));
	 * BigInteger down = THREE; if (isDivisibleByThree(up)) { up =
	 * up.divide(THREE); down = BigInteger.valueOf(1); }
	 * 
	 * //reduce(up, down);
	 * 
	 * System.out.println(up + " / " + down); }
	 */

	// (2 / 3) ^ k * (n - 2)
	public static void main(String[] args) {
		// parseInput(args);
		mock();

		BigInteger up = TWO.pow(k)
				.multiply(BigInteger.valueOf(n).subtract(TWO));
		BigInteger down = THREE.pow(k);

		System.out.println(up + " / " + down);
	}
}
