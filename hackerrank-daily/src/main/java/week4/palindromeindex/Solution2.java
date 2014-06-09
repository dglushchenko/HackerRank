package week4.palindromeindex;

import java.util.Scanner;

public class Solution2 {

	private static boolean isPalindrome(String s, int skipIndex) {
		int left = 0;
		int right = s.length() - 1;
		while (left < right) {
			if (left == skipIndex) {
				left++;
				continue;
			}
			if (right == skipIndex) {
				right--;
				continue;
			}
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public static int solve(String s) {
		int left = 0;
		int right = s.length() - 1;
		int index = -1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				break;
			}
			left++;
			right--;
		}
		if (left != right) {
			if (isPalindrome(s, left)) {
				index = left;
			} else if (isPalindrome(s, right)) {
				index = right;
			}
		}
		return index;
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
