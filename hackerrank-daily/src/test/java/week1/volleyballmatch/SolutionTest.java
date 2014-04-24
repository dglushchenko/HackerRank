package week1.volleyballmatch;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

	@Test
	public void testCountSequences() {
		Assert.assertEquals(0, Solution.countSequences(0, 0));
		Assert.assertEquals(0, Solution.countSequences(0, 1));
		Assert.assertEquals(0, Solution.countSequences(1, 2));
		Assert.assertEquals(0, Solution.countSequences(24, 25));
		Assert.assertEquals(0, Solution.countSequences(25, 25));
		Assert.assertEquals(0, Solution.countSequences(25, 26));
		Assert.assertEquals(0, Solution.countSequences(24, 17));
		
		Assert.assertEquals(1, Solution.countSequences(0, 25));
		Assert.assertEquals(25, Solution.countSequences(1, 25));
		Assert.assertEquals(2925, Solution.countSequences(3, 25));
		Assert.assertEquals(2925, Solution.countSequences(25, 3));
		Assert.assertEquals(345545146, Solution.countSequences(100000, 99998));
	}
	
}
