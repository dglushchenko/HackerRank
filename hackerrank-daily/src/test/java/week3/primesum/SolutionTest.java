package week3.primesum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSolve() {
		Assert.assertEquals(true, Solution.solve(10, 2));
		Assert.assertEquals(false, Solution.solve(1, 6));
		Assert.assertEquals(false, Solution.solve(1, 1));
		Assert.assertEquals(false, Solution.solve(1, 2));
		Assert.assertEquals(false, Solution.solve(1, 3));
		Assert.assertEquals(true, Solution.solve(2, 1));
		Assert.assertEquals(true, Solution.solve(3, 1));
		Assert.assertEquals(false, Solution.solve(4, 1));
	}

	@Test
	public void testSolveOld() {
		long n = 1000;
		long k = 1000;

		Map<Long, Set<Long>> dp = Solution.generateDp(n);
		for (long i = 0; i < n; i++) {
			Set<Long> set = dp.get(i);
			if (set != null) {
				ArrayList<Long> list = new ArrayList<Long>(set);
				Collections.sort(list);
				/*StringBuilder sb = new StringBuilder();
				sb.append(i).append(": [");
				for (long number : list) {
					if (number <= 2) {
						sb.append(number).append(", ");
					}
				}
				sb.append("]");
				System.out.println(sb.toString());*/
			}
		}
		Assert.assertEquals(false, Solution.solve(n, k, dp));
	}

	@Test
	public void testSolveCompare() {
		long n = 1000;
		long k = 1000;
		Map<Long, Set<Long>> dp = Solution.generateDp(n);
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				Assert.assertEquals(Solution.solve(i, j, dp), Solution.solve(i, j));
			}
		}
	}
	
	@Test
	public void testIsPrime() {
		Assert.assertEquals(false, Solution.isPrime(1L));
		Assert.assertEquals(true, Solution.isPrime(2L));
		Assert.assertEquals(true, Solution.isPrime(3L));
		Assert.assertEquals(false, Solution.isPrime(4L));
		Assert.assertEquals(true, Solution.isPrime(5L));
		Assert.assertEquals(false, Solution.isPrime(6L));
		Assert.assertEquals(true, Solution.isPrime(7L));
		Assert.assertEquals(false, Solution.isPrime(8L));
		Assert.assertEquals(false, Solution.isPrime(9L));
		Assert.assertEquals(false, Solution.isPrime(10L));
		
		Assert.assertEquals(false, Solution.isPrime(1000000000000L));
		Assert.assertEquals(true, Solution.isPrime(100000000003L));
		Assert.assertEquals(true, Solution.isPrime(999999999989L));
		Assert.assertEquals(false, Solution.isPrime(999999999990L));
		Assert.assertEquals(false, Solution.isPrime(999999999991L));
		Assert.assertEquals(false, Solution.isPrime(999999999992L));
		Assert.assertEquals(false, Solution.isPrime(999999999993L));
	}

	@Test(timeout=5000)
	public void testIsPrimePerformance() {
		for (int i = 0; i < 2500; i++) {
			Assert.assertEquals(true, Solution.isPrime(999999999989L));
			Assert.assertEquals(false, Solution.isPrime(999999999990L));
		}
	}
	@Test
	public void testSolvePerformance() {
		Assert.assertEquals(false, Solution.solve(1000000000000L, 1000000000000L));
	}
}
