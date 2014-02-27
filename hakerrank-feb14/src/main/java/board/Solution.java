package board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	private static int numberOfTestCases;
	private static TestCase[] testCases;

	private static class TestCase {
		private int m;
		private int n;
		private long[] costM;
		private long[] costN;

		public TestCase(int m, int n, long[] costM, long[] costN) {
			this.m = m;
			this.n = n;
			this.costM = costM;
			this.costN = costN;
		}

		public int getM() {
			return m;
		}

		public int getN() {
			return n;
		}

		public long[] getCostM() {
			return costM;
		}

		public long[] getCostN() {
			return costN;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			
			sb.append("[");
			sb.append(m).append(", ");
			sb.append(n).append(", ");
			sb.append(Arrays.toString(costM)).append(", ");
			sb.append(Arrays.toString(costN)).append("]");
			
			return sb.toString();
		}
	}

	private static void parseInput(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));

			String input = br.readLine();

			numberOfTestCases = Integer.valueOf(input);
			testCases = new TestCase[numberOfTestCases];

			int count = 0;
			while (count < numberOfTestCases) {
				input = br.readLine();
				String[] dimensions = input.split(" ");
				int m = Integer.valueOf(dimensions[0]);
				int n = Integer.valueOf(dimensions[1]);
				long[] costM = new long[m - 1];
				long[] costN = new long[n - 1];

				input = br.readLine();
				String[] costMString = input.split(" ");
				int i = 0;
				for (String s : costMString) {
					costM[i++] = Long.valueOf(s);
				}

				input = br.readLine();
				String[] costNString = input.split(" ");
				i = 0;
				for (String s : costNString) {
					costN[i++] = Long.valueOf(s);
				}
				testCases[count++] = new TestCase(m, n, costM, costN);
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	private static void mock() {
		numberOfTestCases = 1;
		testCases = new TestCase[] {new TestCase(2, 2, new long[] {2}, new long[] {1})};
	}

	public static void main(String[] args) {
		parseInput(args);
		//mock();
		for (TestCase testCase : testCases) {
			long[] costM = testCase.getCostM();
			long[] costN = testCase.getCostN();
			Arrays.sort(costM);
			Arrays.sort(costN);
			int i = costM.length - 1;
			int j = costN.length - 1;

			long sum = 0;
			int mSegments = 1;
			int nSegments = 1;
			while (i >= 0 || j >= 0) {
				long m = i < 0 ? -1 : costM[i];
				long n = j < 0 ? -1 : costN[j];
				long mSum = m * mSegments;
				long nSum = n * nSegments;
				if (m > n || (m == n && mSum > nSum)) {
					sum += m * mSegments;
					nSegments++;
					i--;
				} else {
					sum += n * nSegments;
					mSegments++;
					j--;
				}
			}
			System.out.println(sum % 1000000007);
		}
	}

}