package week11.sherlockandsquare;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

	private static final BigInteger MOD = BigInteger.valueOf(1000000007);
	
	/*public static int solve(int n) {
		BigInteger result = BigInteger.valueOf(2);

		result = result.modPow(BigInteger.valueOf(n + 1), MOD).add(BigInteger.valueOf(2));
		
		return result.mod(MOD).intValue();
	}*/
	
	public static long pow(long base, long exp, int mod)	{
	    long result = 1;
	    while (exp != 0) {
	        if (exp % 2 == 1) {
	            result = (result * base) % mod;
	        }
	        exp >>= 1;
	        base = (base * base) % mod;
	    }
	    return (int) result;
	}

	public static int solve(int n) {
		return ((int) pow(2L, n + 1L, 1000000007) + 2) % 1000000007;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			int t = in.nextInt();
			while (t-- > 0) {
				int n = in.nextInt();
				System.out.println(solve(n));
			}
		} finally {
			in.close();
		}
	}

}
