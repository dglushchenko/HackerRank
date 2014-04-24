package week1.maximizingxor;

import java.util.Scanner;

public class Solution {
	static int maxXor(int l, int r) {
		int max = 0;
		for (int i = l; i <= r; i++) {
			for (int j = l; j <= r; j++) {
				int current = i ^ j;
				if (current > max) {
					max = current;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int l = Integer.parseInt(in.nextLine());
		int r = Integer.parseInt(in.nextLine());

		System.out.println(maxXor(l, r));
	}
}