package week1.volleyballmatch;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

	public static int countSequences(int a, int b) {
		if (b > a) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		if (a < 25) {
			return 0;
		}
		
		if (a == 25 && b > 23) {
			return 0;
		}
		
		if (a > 25 && a - b != 2) {
			return 0;
		}
		
		if (a == 25 && b == 0) {
			return 1;
		}

		/*int base = a + b - 1;
		BigInteger result = BigInteger.ONE;
		for (int i = 0; i < b; i++) {
			result = result.multiply(BigInteger.valueOf(base - i)).divide(BigInteger.valueOf(i + 1));
		}*/
		int base = a + b - 1;
		BigInteger up = BigInteger.ONE;
		BigInteger down = BigInteger.ONE;
		for (int i = 0; i < b; i++) {
			up = up.multiply(BigInteger.valueOf(base - i));
			down = down.multiply(BigInteger.valueOf(i + 1));
		}
		
		
		return up.divide(down).mod(BigInteger.valueOf(1000000007)).intValue();
	}


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();

		System.out.println(countSequences(a, b));
	}

}
