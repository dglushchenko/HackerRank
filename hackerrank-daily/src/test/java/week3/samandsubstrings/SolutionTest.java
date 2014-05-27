package week3.samandsubstrings;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSolve() {
		Assert.assertEquals(23, Solution.solve("16"));
		Assert.assertEquals(164, Solution.solve("123"));
		
		Assert.assertEquals(1, Solution.solve("1"));
		Assert.assertEquals(13, Solution.solve("11"));
		Assert.assertEquals(136, Solution.solve("111"));
	}

	@Test
	public void testSolvePerformance() {
		int numberOfDigits = 100000;
		StringBuilder sb = new StringBuilder();
		sb.append("1");
		for (int i = 0; i < numberOfDigits; i++) {
			int k = new Double(10 * Math.random()).intValue();
			sb.append(k);
		}
		Assert.assertEquals(867301508, Solution.solve(sb.toString()));
	}

}
