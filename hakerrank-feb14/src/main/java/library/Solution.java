package library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	private static int numberOfTestCases;
	private static TestCase[] testCases;

	private static class TestCase {
		public int numberOfShelves;
		public short[] shelves;
		public int numberOfQueries;
		public String[] queries;
	}

	private static void parseInput(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String input = br.readLine();
			numberOfTestCases = Integer.valueOf(input);
			testCases = new TestCase[numberOfTestCases];

			int count = 0;
			while (count < numberOfTestCases) {
				TestCase tc = new TestCase();
				input = br.readLine();
				tc.numberOfShelves = Integer.valueOf(input);
				tc.shelves = new short[tc.numberOfShelves];

				input = br.readLine();
				String[] shelves = input.split(" ");
				for (int i = 0; i < shelves.length; i++) {
					tc.shelves[i] = Short.valueOf(shelves[i]);
				}

				input = br.readLine();
				tc.numberOfQueries = Integer.valueOf(input);
				tc.queries = new String[tc.numberOfQueries];

				int queriesCount = 0;
				while (queriesCount < tc.numberOfQueries) {
					input = br.readLine();
					tc.queries[queriesCount++] = input;
				}

				testCases[count++] = tc;
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	private static void swap(short[] array, int from, int to) {
		if (from == to) {
			return;
		}

		short tmp = array[from];
		array[from] = array[to];
		array[to] = tmp;
	}

	public static int findKthSmallest(short[] array, int from, int to, int k) {
		if (from == to) {
			return from;
		}

		int mid = 2 * (to + from) / 3;
		if (mid > to) {
			mid = to;
		}
		int pivot = array[mid];

		swap(array, mid, to);

		int i = from;
		int j = to - 1;
		while (i < j) {
			if (array[i] <= pivot) {
				i++;
				continue;
			}
			if (array[j] > pivot) {
				j--;
				continue;
			}
			swap(array, i, j);
		}
		if (array[j] >= pivot) {
			swap(array, to, j);
			mid = j;
		} else {
			mid = to;
		}

		if (mid == k) {
			return mid;
		}
		if (k > mid) {
			return findKthSmallest(array, mid + 1, to, k);
		} else {
			return findKthSmallest(array, from, mid - 1, k);
		}
	}

	public static void main(String[] args) {
		parseInput(args);
		StringBuilder sb = new StringBuilder();
		for (TestCase tc : testCases) {
			for (String query : tc.queries) {
				if (query.startsWith("1")) {
					String[] split = query.split(" ");
					int index = Integer.valueOf(split[1]) - 1;
					short value = Short.valueOf(split[2]);
					tc.shelves[index] = value;
				}

				if (query.startsWith("0")) {
					String[] split = query.split(" ");
					int x = Integer.valueOf(split[1]);
					int y = Integer.valueOf(split[2]);
					int k = Integer.valueOf(split[3]);
					int length = y - x + 1;
					short[] array = new short[length];
					System.arraycopy(tc.shelves, x - 1, array, 0, length);
					int index = findKthSmallest(array, 0, array.length - 1,
							k - 1);
					sb.append(array[index]).append("\n");
				}
			}
		}
		System.out.println(sb.toString());
	}

}