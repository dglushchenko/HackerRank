package week3.samandsubstrings;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

	public static int solve(String s) {
		int length = s.length();
		int[] digits = new int[length];
		BigInteger magicNumber = BigInteger.ZERO;
		for (int i = 0; i < length; i++) {
			digits[i] = Integer.valueOf("" + s.charAt(i));
			magicNumber = magicNumber.multiply(BigInteger.TEN).add(BigInteger.ONE);
		}
		BigInteger sum = BigInteger.ZERO;
		for (int i = 0; i < length; i++) {
			sum = sum.add(BigInteger.valueOf(digits[i]).multiply(BigInteger.valueOf(i + 1)).multiply(magicNumber));
			magicNumber = magicNumber.divide(BigInteger.TEN);
		}

		return sum.mod(BigInteger.valueOf(1000000007L)).intValue();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		System.out.println(solve(s));
	}

}
