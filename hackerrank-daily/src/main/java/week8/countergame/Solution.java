package week8.countergame;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

	public static String solve(BigInteger n) {
		int bitCount = n.bitCount();
		int lowestSetBit = n.getLowestSetBit();
		int count = bitCount + lowestSetBit;
		return count % 2 == 0 ? "Louise" : "Richard";
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			int t = in.nextInt();
			while (t-- > 0) {
				BigInteger n = in.nextBigInteger();
				System.out.println(solve(n));
			}
		} finally {
			in.close();
		}
	}

}
