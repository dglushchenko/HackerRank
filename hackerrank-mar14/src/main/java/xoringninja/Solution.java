package xoringninja;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		while (scanner.hasNextLine()) {
			int length = scanner.nextInt();
			BigInteger orOfAll = BigInteger.ZERO;
			for (int i = 0; i < length; i++) {
				orOfAll.or(BigInteger.valueOf(scanner.nextInt()));
			}
			
			BigInteger result = orOfAll.shiftLeft(length - 1).mod(BigInteger.valueOf(1000000007));
			System.out.println(result);
		}
	}

}
