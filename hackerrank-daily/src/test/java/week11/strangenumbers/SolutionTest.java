package week11.strangenumbers;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

	@Test
	public void testGenerate() {
		long[] numbers = Solution.generate();
		System.out.println(Arrays.toString(numbers));
	}

	@Test
	public void testSolve() {
		long[] numbers = Solution.generate();
		Assert.assertEquals(10, Solution.solve(7, 25, numbers));
		Assert.assertEquals(1, Solution.solve(45, 50, numbers));
		Assert.assertEquals(26, Solution.solve(1, 100, numbers));
		Assert.assertEquals(0, Solution.solve(99, 103, numbers));
		Assert.assertEquals(96, Solution.solve(0, 1000000, numbers));
	}

	@Test
	public void testSolveBig() {
		long[] numbers = Solution.generate();
		for (int i = 0; i < 200; i++) {
			Solution.solve(0, 1000000000000000000L, numbers);
		}
	}


}
