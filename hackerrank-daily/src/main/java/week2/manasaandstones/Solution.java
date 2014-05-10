package week2.manasaandstones;

import java.util.Scanner;

// Fixed late, issue: check for uniqueness
public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			if (a > b) {
				int tmp = a;
				a = b;
				b = tmp;
			}
			StringBuilder sb = new StringBuilder();
			int previousNumber = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				int number = i * b + (n - i - 1) * a;
				if (number != previousNumber) {
					sb.append(number);
					if (i < n - 1) {
						sb.append(" ");
					}
				}
				previousNumber = number;
			}
			System.out.println(sb.toString());
		}
	}

}
