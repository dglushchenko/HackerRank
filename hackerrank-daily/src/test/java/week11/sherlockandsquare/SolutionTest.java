package week11.sherlockandsquare;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

	@Test(timeout=4000)
	public void testSolve() {
		Assert.assertEquals(4, Solution.solve(0));
		Assert.assertEquals(6, Solution.solve(1));
		Assert.assertEquals(10, Solution.solve(2));
		Assert.assertEquals(18, Solution.solve(3));
		Assert.assertEquals(979545353, Solution.solve(900));
		Assert.assertEquals(281250004, Solution.solve(1000000000));
		Assert.assertEquals(470084120, Solution.solve(1000000));
	}
	
	@Test(timeout=4000)
	public void testSolveTime() {
		for (int t = 0; t < 100000; t++) {
			Solution.solve(t * 10000);
		}
	}
	
	@Test
	public void print() {
		for (int t = 0; t < 100; t++) {
			System.out.println(Solution.solve(t));
		}
	}
	
}
