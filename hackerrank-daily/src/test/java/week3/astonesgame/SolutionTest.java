package week3.astonesgame;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSolve() {
		Assert.assertEquals(1, Solution.solve(1));
		Assert.assertEquals(7, Solution.solve(10));
		Assert.assertEquals(2, Solution.solve(6));
		Assert.assertEquals(7, Solution.solve(8));
		Assert.assertEquals(32768, Solution.solve(123456));
		Assert.assertEquals(1, Solution.solve(2));
		Assert.assertEquals(0, Solution.solve(3));
	}
	
}
