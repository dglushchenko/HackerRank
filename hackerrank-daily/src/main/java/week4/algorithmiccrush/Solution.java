package week4.algorithmiccrush;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static long solve(int n, int m, long[][] queries) {
		Map<Integer, Long> change = new HashMap<Integer, Long>();
		for (long[] query : queries) {
			int from = (int) query[0];
			int to = (int) query[1] + 1;
			long value = query[2];
			Long changeValuePlus = change.get(from);
			if (changeValuePlus == null) {
				changeValuePlus = 0L;
			}
			changeValuePlus += value;
			change.put(from, changeValuePlus);
			Long changeValueMinus = change.get(to);
			if (changeValueMinus == null) {
				changeValueMinus = 0L;
			}
			changeValueMinus -= value;
			change.put(to, changeValueMinus);
		}

		List<Integer> changeKeys = new ArrayList<Integer>(change.keySet());
		Collections.sort(changeKeys);

		long max = 0;
		long value = 0;
		for (int number : changeKeys) {
			value += change.get(number);
			max = Math.max(max, value);
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		long[][] queries = new long[m][3];
		for (int i = 0; i < m; i++) {
			queries[i][0] = in.nextLong();
			queries[i][1] = in.nextLong();
			queries[i][2] = in.nextLong();
		}
		System.out.println(solve(n, m, queries));
	}

}
