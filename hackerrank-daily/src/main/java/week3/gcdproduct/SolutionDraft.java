package week3.gcdproduct;

import java.math.BigInteger;
import java.util.Arrays;

public class SolutionDraft {

	private static int gcd(int a, int b) {
		return b > 0 ? gcd(b, a % b) : a;
	}

	private static long spow(long base, long exp, long mod) {
		long result = base;
		for (int i = 2; i <= exp; i++) {
			result = (result * base) % mod;
		}
		return result;
	}
	
	private static long pow(long base, long exp, long mod) {
		if (exp < 0) {
			throw new IllegalArgumentException(String.valueOf(exp));
		}
		return BigInteger.valueOf(base).pow((int) (exp % mod)).mod(BigInteger.valueOf(mod)).intValue();
	}
	
	public static long ipow(long base, long exp, int mod)	{
	    long result = 1;
	    while (exp != 0) {
	        if (exp % 2 == 1) {
	            result = (result * base) % mod;
	        }
	        exp >>= 1;
	        base = (base * base) % mod;
	    }
	    return result;
	}

	public static int solveSlow(int n, int m) {
		long result = 1;
		int mod = 1000000007;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				/*if (j % i == 0) {
					if (j / i == 2) {
						result = result * gcd(i, j) % mod;
						result = result * ((n - 1) / i) % mod;
					}
				} else {*/
					result = (result * gcd(i, j)) % mod;
				//}
			}
		}
		/*result = (result * result) % mod;
		for (int i = 1; i <= n; i++) {
			result = (result * i) % mod;
		}*/

		return (int) result;
	}

	public static int solve(int n, int m) {
		if (n > m) {
			int temp = n;
			n = m;
			m = temp;
		}
		
		long start = System.currentTimeMillis();
		long result = 1;
		int mod = 1000000007;
		int[] counts = new int[n + 1];
		Arrays.fill(counts, 1);
		int min = Math.min(m / 2, n);
		for (int i = min; i > 1; i--) {
			int k = n / i;
			int l = m / i;
			counts[i] = (k * l - (k - 1)) % mod;
			long index = i;
			long multiple = 2;
			int correction = 0;
			while (true) {
				index = i * multiple++;
				if (index <= min) {
					correction = (correction - counts[(int) index] + 1) % mod;
				} else {
					break;
				}
			}
			counts[i] = (counts[i] + correction) % mod;
			if (counts[i] < 0) {
				counts[i] += mod;
			}
		}
		System.out.println(System.currentTimeMillis() - start);
		start = System.currentTimeMillis();
		//System.out.println(Arrays.toString(counts));
		//BigInteger bigResult = BigInteger.ONE;
		for (int i = 1; i <= n; i++) {
			result = (result * ipow(i, counts[i], mod)/*pow(i, counts[i], mod)*/) % mod;
			//bigResult = bigResult.multiply(BigInteger.valueOf(i).pow((int) counts[i]));
		}
		//System.out.println("big: " + bigResult.mod(BigInteger.valueOf(mod)).intValue() + ", small: " + result);
		System.out.println(System.currentTimeMillis() - start);
		
		return (int) result;
	}

	public static void main(String[] args) {
		/*Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		System.out.println(solve(n, m));*/
		int max = 6;
		for (int i = 1; i <= max + 2; i++) {
			StringBuilder sb = new StringBuilder();
			int count = 0;
			for (int j = 1; j <= max; j++) {
				for (int k = /*j + */1; k <= max + 2; k++) {
					if (/*j != k && */gcd(j, k) == i) {
						sb.append("[" + j + ", " + k +"]");
						count++;
					}
				}
			}
			System.out.println(i + ": " + count + ": " + sb.toString());
		}
	}

}
