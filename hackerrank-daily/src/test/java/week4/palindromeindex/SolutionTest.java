package week4.palindromeindex;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSolve() {
		Assert.assertEquals(3, Solution.solve("aaab"));
		Assert.assertEquals(0, Solution.solve("baa"));
		Assert.assertEquals(-1, Solution.solve("a"));
		Assert.assertEquals(-1, Solution.solve("aa"));
		Assert.assertEquals(-1, Solution.solve("aaa"));
		Assert.assertEquals(-1, Solution.solve("aba"));
		Assert.assertEquals(0, Solution.solve("bcbc"));
	}

	@Test(timeout=5000)
	public void testSolvePerformancePalindrome() {
		int t = 20;
		int length = 100005;
		for (int i = 0; i < t; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < length; j++) {
				sb.append("a");
			}
			Assert.assertEquals(-1, Solution.solve(sb.toString()));
		}
	}

	@Test(timeout=5000)
	public void testSolvePerformanceNotPalindrome() {
		int t = 20;
		int length = 100005;
		long duration = 0;
		for (int i = 0; i < t; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < length / 2; j++) {
				sb.append("a");
			}
			sb.append("a").append("b");
			for (int j = 0; j < length / 2 - 1; j++) {
				sb.append("a");
			}
			long start = System.currentTimeMillis();
			Assert.assertEquals(length / 2 + 1, Solution.solve(sb.toString()));
			long finish = System.currentTimeMillis();
			duration += (finish - start);
		}
		System.out.println(duration);
	}

}
