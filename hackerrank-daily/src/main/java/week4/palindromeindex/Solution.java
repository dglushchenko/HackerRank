package week4.palindromeindex;

import java.util.Scanner;

public class Solution {

	public static int solve(String s) {
		int leftCurrent = 0;
		int rightCurrent = s.length() - 1;
		int left = -1;
		int right = -1;
		boolean wasDifferent = false;
		while (leftCurrent < rightCurrent) {
			if (s.charAt(leftCurrent) != s.charAt(rightCurrent)) {
				if (!wasDifferent) {
					left = leftCurrent;
					right = rightCurrent;
					leftCurrent++;
					wasDifferent = true;
					continue;
				} else {
					return right;
				}
			}
			leftCurrent++;
			rightCurrent--;
		}
		return wasDifferent ? left : -1;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			String s = in.next();
			int index = solve(s);
			System.out.println(index);
		}
	}

}
