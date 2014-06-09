package week4.algorithmiccrush;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSolve() {
		long[][] queries = new long[5][3];
		queries[0][0] = 1;
		queries[0][1] = 2;
		queries[0][2] = 100;
		queries[1][0] = 2;
		queries[1][1] = 5;
		queries[1][2] = 100;
		queries[2][0] = 3;
		queries[2][1] = 4;
		queries[2][2] = 100;
		Assert.assertEquals(200, Solution.solve(5, 3, queries));
	}

	@Test
	public void testSolveOne() {
		long[][] queries = new long[5][3];
		queries[0][0] = 1;
		queries[0][1] = 5;
		queries[0][2] = 100;
		Assert.assertEquals(100, Solution.solve(5, 3, queries));
	}

	@Test
	public void testSolveOnes() {
		long[][] queries = new long[3][3];
		queries[0][0] = 1;
		queries[0][1] = 1;
		queries[0][2] = 1;
		queries[1][0] = 2;
		queries[1][1] = 2;
		queries[1][2] = 1;
		queries[2][0] = 3;
		queries[2][1] = 3;
		queries[2][2] = 1;
		Assert.assertEquals(1, Solution.solve(3, 3, queries));
	}

	@Test
	public void testSolvePairs() {
		long[][] queries = new long[2][3];
		queries[0][0] = 1;
		queries[0][1] = 2;
		queries[0][2] = 1;
		queries[1][0] = 2;
		queries[1][1] = 3;
		queries[1][2] = 1;
		Assert.assertEquals(2, Solution.solve(3, 2, queries));
	}

	@Test
	public void testSolveAlone() {
		long[][] queries = new long[1][3];
		queries[0][0] = 1;
		queries[0][1] = 1;
		queries[0][2] = 1;
		Assert.assertEquals(1, Solution.solve(1, 1, queries));
	}

	@Test
	public void testSolvePerformance() {
		int n = 10000000;
		int m = 200000;
		long[][] queries = new long[m][3];
		for (int i = 0; i < m; i++) {
			queries[i][0] = i + 1;
			queries[i][1] = i + 1;
			queries[i][2] = 1;
		}
		Assert.assertEquals(1, Solution.solve(n, m, queries));
	}

}
