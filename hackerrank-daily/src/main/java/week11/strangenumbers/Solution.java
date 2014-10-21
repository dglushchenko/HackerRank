package week11.strangenumbers;

import java.util.Scanner;

public class Solution {
	
	private static final int SIZE = 301;

	private static int length(long number) {
		return String.valueOf(number).length();
	}
	
	public static long[] generate() {
		long[] numbers = new long[SIZE];
		int writeIndex = 0;
		for (int number = 0; number <= 9; number++) {
			numbers[writeIndex++] = number;
		}
		int readIndex = 1;
		while (true) {
			long number = numbers[readIndex++];
			if (number == 0 || writeIndex >= SIZE) {
				break;
			}
			for (int expectedNewLength = 2; expectedNewLength <= 18; expectedNewLength++) {
				long newNumber = number * expectedNewLength;
				int newLength = length(newNumber);
				if (expectedNewLength == newLength && newNumber <= 1000000000000000000L) {
					numbers[writeIndex++] = newNumber;
				}
			}
		}
		return numbers;
	}
	
	public static int solve(long l, long r, long[] numbers) {
		int count = 0;
		
		for (int i = 0; i < SIZE; i++) {
			if (numbers[i] >= l && numbers[i] <= r) {
				count++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			long[] numbers = generate();
			
			int t = in.nextInt();
			while (t-- > 0) {
				long l = in.nextLong();
				long r = in.nextLong();
				System.out.println(solve(l, r, numbers));
			}
		} finally {
			in.close();
		}
	}

}
