package week1.psequences;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

	/*public static int findNumberOfSequences(int n, int p) {
		BigInteger result = BigInteger.ZERO;		
		for (int i = 1; i <= p; i++) {
			int k = p / i;
			result = result.add(BigInteger.valueOf(k).pow(n - 1));
		}
		
		return result.mod(BigInteger.valueOf(1000000007)).intValue();
	}*/
	
	/*public static int findNumberOfSequences(int n, int p) {
		//BigInteger result = BigInteger.ZERO;
		
		int r = count(n, p, p);
		return r;
		
		//return result.mod(BigInteger.valueOf(1000000007)).intValue();
	}
	
	private static int count(int n, int p, int k) {
		if (n == 0) {
			return 1;
		}
		int sum = 0;
		for (int i = 1; i <= k; i++) {
			sum += count(n - 1, p, p / i);
		}
		return sum;
	}*/
	
	public static int findNumberOfSequences(int n, int p) {
		int[] values = new int[p + 1];
		int[] tmp = new int[p + 1];
		
		for (int i = 1; i <= p; i++) {
			values[i] = 1;
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= p; j++) {
				int subsum = 0;
				for (int k = p / j; k >= 1; k--) {
					subsum = (subsum + values[k]) % 1000000007;
				}
				tmp[j] = subsum;
			}
			System.arraycopy(tmp, 0, values, 0, tmp.length);
			//values = tmp;
			/*for (int j = p; j >= 1; j--) {
				values[j] = tmp[j];
				tmp[j] = 0;
			}*/			
		}

		BigInteger count = BigInteger.ZERO;
		for (int i = 1; i <= p; i++) {
			count = count.add(BigInteger.valueOf(values[i]));
		}
		return count.mod(BigInteger.valueOf(1000000007)).intValue();
	}

	/*public static int findNumberOfSequences(int n, int p) {
		BigInteger[] values = new BigInteger[p + 1];
		BigInteger[] tmp = new BigInteger[p + 1];
		
		for (int i = 1; i <= p; i++) {
			values[i] = BigInteger.ONE;
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = p; j >= 1; j--) {
				BigInteger subsum = BigInteger.ZERO;
				for (int k = p / j; k >= 1; k--) {
					subsum = subsum.add(values[k]);
				}
				tmp[j] = subsum;
			}
			for (int j = p; j >= 1; j--) {
				values[j] = tmp[j];
				tmp[j] = BigInteger.ZERO;
			}			
		}

		BigInteger count = BigInteger.ZERO;
		for (int i = 1; i <= p; i++) {
			count = count.add(values[i]);
		}
		return count.mod(BigInteger.valueOf(1000000007)).intValue();
	}*/

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int p = in.nextInt();

		System.out.println(findNumberOfSequences(n, p));
	}

}
