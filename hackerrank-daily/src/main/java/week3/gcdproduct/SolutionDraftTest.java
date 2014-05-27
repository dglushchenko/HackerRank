package week3.gcdproduct;

import org.junit.Assert;
import org.junit.Test;

public class SolutionDraftTest {

	private static final int MAX_VALUE = 15000000;
	
	@Test(timeout=5000)
	public void testSolveSquare() {
		Assert.assertEquals(1, SolutionDraft.solve(1, 1));
		Assert.assertEquals(1, SolutionDraft.solve(1, MAX_VALUE));
		Assert.assertEquals(2, SolutionDraft.solve(2, 2));
		Assert.assertEquals(2, SolutionDraft.solve(2, 3));
		Assert.assertEquals(6, SolutionDraft.solve(3, 3));
		Assert.assertEquals(96, SolutionDraft.solve(4, 4));
	}

	@Test(timeout=5000)
	public void testSolveRectangle() {
		Assert.assertEquals(4, SolutionDraft.solve(2, 4));
	}
	
	@Test(timeout=5000)
	public void testSolveTen() {
		Assert.assertEquals(781791477, SolutionDraft.solve(10, 10));
	}

	@Test//(timeout=5000)
	public void testSolveOneHundred() {
		//int limit = 12;
		//Assert.assertEquals(Solution.solveSlow(limit, limit), Solution.solve(limit, limit));
		//Assert.assertEquals(398402093, Solution.solveSlow(100, 100));
		Assert.assertEquals(767613723, SolutionDraft.solve(12, 12));
	}

	@Test(timeout=5000)
	public void testSolveCompare() {
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				System.out.println(i + ", " + j);
				Assert.assertEquals(SolutionDraft.solveSlow(i, j), SolutionDraft.solve(i, j));
			}
		}
	}
	
	@Test//(timeout=5000)
	public void testSolvePerformanceSoft() {
		//System.out.println("[70000, 70000]: " + SolutionDraft.solveSlow(70000, 70000));
		//System.out.println("[70000, 71234]: " + SolutionDraft.solveSlow(70000, 71234));
		Assert.assertEquals(718313503, SolutionDraft.solve(70000, 70000));
		Assert.assertEquals(404470827, SolutionDraft.solve(70000, 71234));
	}

	@Test//(timeout=5000)
	public void testSolvePerformance() {
		Assert.assertEquals(594545695, SolutionDraft.solve(MAX_VALUE, MAX_VALUE));
	}

	@Test
	public void testSolveRectangleCompare() {
		Assert.assertEquals(SolutionDraft.solveSlow(1, 2), SolutionDraft.solve(1, 2));
	}
	
	@Test
	public void testIpow() {
		Assert.assertEquals(4, SolutionDraft.ipow(2, 2, 1000000007));
		Assert.assertEquals(256, SolutionDraft.ipow(2, 8, 1000000007));
		//Assert.assertEquals(256, Solution.ipow(15000000, 15000000, 1000000007));
	}
}
