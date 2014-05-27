package week3.thelovelettermystery;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			String s = in.next();
			int result = 0;
			for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
				int left = s.charAt(i); 
				int right = s.charAt(j);
				result += Math.abs(left - right);
			}
			System.out.println(result);
		}
	}
	
}
