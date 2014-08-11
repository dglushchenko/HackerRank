package week8.girlfriendandnecklace;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSolve() {
		Assert.assertEquals(3, Solution.solve(2));
		Assert.assertEquals(4, Solution.solve(3));
		Assert.assertEquals(6, Solution.solve(4));
		Assert.assertEquals(9, Solution.solve(5));
		Assert.assertEquals(13, Solution.solve(6));
		Assert.assertEquals(19, Solution.solve(7));
		Assert.assertEquals(28, Solution.solve(8));
	}

	@Test
	public void testSolveBig() {
		Solution.solve(1000000000000000000L);
		//Solution.solve(10000000L);
	}
}
