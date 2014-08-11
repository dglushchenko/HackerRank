package week8.johnandgcdlist;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSolve() {
		for (int i = 0; i < 10; i++) {
			int[] array = new int[1000];
			for (int j = 0; j < 1000; j++) {
				array[j] = (j % 2 == 0 ? 10000 : 9999);
			}
			Solution.solve(array);
		}
	}
	
}
