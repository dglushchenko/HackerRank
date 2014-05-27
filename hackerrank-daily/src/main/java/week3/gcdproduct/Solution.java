package week3.gcdproduct;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static long pow(long base, long exp, int mod)	{
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

	public static int solve(int n, int m) {
		if (n > m) {
			int temp = n;
			n = m;
			m = temp;
		}
		
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
		for (int i = 1; i <= n; i++) {
			result = (result * pow(i, counts[i], mod)) % mod;
		}
		
		return (int) result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		System.out.println(solve(n, m));
	}

}
