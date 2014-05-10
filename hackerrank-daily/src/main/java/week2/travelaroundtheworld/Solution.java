package week2.travelaroundtheworld;

import java.util.Scanner;

// TODO Works for small set only
public class Solution {

	public static int solve(int n, long c, int[] a, int[] b) {
		int count = 0;
		long tank = 0;
		for (int i = 0; i < n; i++) {
			boolean isOk = true;
			tank = 0;
			for (int j = i;;) {
				tank += a[j];
				tank = Math.min(tank, c);
				tank -= b[j];
				if (tank < 0) {
					isOk = false;
					break;
				}
				if (j < n - 1) {
					j++;
				} else {
					j = 0;
				}
				if (j == i) {
					break;
				}
			}
			if (!isOk) {
				tank = 0;
				for (int j = i;;) {
					tank += a[j];
					tank = Math.min(tank, c);
					tank -= b[j];
					if (tank < 0) {
						isOk = false;
						break;
					}
					if (j > 0) {
						j--;
					} else {
						j = n - 1;
					}
					if (j == i) {
						break;
					}
				}
			}
			if (isOk) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long c = in.nextLong();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			b[i] = in.nextInt();
		}
		System.out.println(solve(n, c, a, b));
	}

}
