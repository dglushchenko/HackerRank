package week2.travelaroundtheworld;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

	@Test(timeout=5000)
	public void testSolve() {
		Assert.assertEquals(2, Solution.solve(3, 3, new int[] { 3, 1, 2 }, new int[] { 2, 2, 2 }));
		Assert.assertEquals(0, Solution.solve(3, 2, new int[] { 3, 3, 0 }, new int[] { 2, 2, 2 }));
		Assert.assertEquals(0, Solution.solve(3, 2, new int[] { 3, 1, 2 }, new int[] { 2, 2, 2 }));
	}

	//@Test(timeout=5000)
	public void testSolvePerformance() {
		int n = 100000;
		long c = 1000000000000000000L;
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = 1000000000 - i;
		}
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			b[i] = 1000000000 - i;
		}
		
		Assert.assertEquals(100000, Solution.solve(n, c, a, b));
	}

}
