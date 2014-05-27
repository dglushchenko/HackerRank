package week3.astonesgame;

import java.util.Scanner;

public class Solution {

	private static int lg(int n) {
		int k = 0;
		
		while (n > 1) {
			n /= 2;
			k++;
		}
		
		return k;
	}
	
	private static int pow(int k) {
		int n = 1;
		
		for (int i = 1; i <= k; i++) {
			n *= 2;
		}
		
		return n;
	}
	
	public static int solve(int n) {
		int lg = lg(n);
		int pow = pow(lg);
		int result;
		if (n == 1) {
			result = 1;
		} else if (n == pow * 2 - 1) {
			result = 0;
		} else if (lg % 2 == 0) {
			result = pow / 2;
		} else {
			result = pow - 1;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			System.out.println(solve(n));
		}
	}
	
}
