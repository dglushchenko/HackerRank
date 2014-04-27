package week1.psequences;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

	@Test
	public void testFindNumberOfSequences() {
		Assert.assertEquals(3, Solution.findNumberOfSequences(2, 2));
		Assert.assertEquals(5, Solution.findNumberOfSequences(3, 2));
		Assert.assertEquals(5, Solution.findNumberOfSequences(2, 3));
		Assert.assertEquals(1, Solution.findNumberOfSequences(2, 1));
		Assert.assertEquals(27, Solution.findNumberOfSequences(2, 10));
		Assert.assertEquals(22, Solution.findNumberOfSequences(3, 4));
		Assert.assertEquals(21, Solution.findNumberOfSequences(4, 3));
		Assert.assertEquals(1, Solution.findNumberOfSequences(1000, 1));
		Assert.assertEquals(1, Solution.findNumberOfSequences(2, 1));
	}

	//4446
	/*@Test
	public void testFindNumberOfSequencesPerformance() {
		long start = System.currentTimeMillis();
		Assert.assertEquals(824068420, Solution.findNumberOfSequences(1000, 1000000));
		System.out.println(System.currentTimeMillis() - start);
	}*/
}
