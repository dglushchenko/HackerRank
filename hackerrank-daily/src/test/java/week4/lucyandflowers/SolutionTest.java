package week4.lucyandflowers;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSolve() {
		int max = 100;
		long[] catalanNumbers = new long[max + 1];
		Solution.fillCatalanNumbers(catalanNumbers);
		long[][] binomial = new long[max + 1][max + 1];
		Solution.fillBinomial(binomial, max);
		Assert.assertEquals(345940295, Solution.solve(catalanNumbers, binomial, max));
	}

	@Test
	public void testSolvePerformance() {
		int max = 5000;
		long[] catalanNumbers = new long[max + 1];
		Solution.fillCatalanNumbers(catalanNumbers);
		long[][] binomial = new long[max + 1][max + 1];
		Solution.fillBinomial(binomial, max);
		for (int i = 0; i < 5000; i++) {
			Assert.assertEquals(579989027, Solution.solve(catalanNumbers, binomial, max));
		}
	}
	

	@Test
	public void testFillCatalanNumbers() {
		int max = 100;
		BigInteger[] bigCatalanNumbers = new BigInteger[max + 1];
		SolutionBig.fillCatalanNumbers(bigCatalanNumbers);
		long[] catalanNumbers = new long[max + 1];
		Solution.fillCatalanNumbers(catalanNumbers);
		Assert.assertEquals(catalanNumbers[max], bigCatalanNumbers[max].mod(BigInteger.valueOf(Solution.MOD)).intValue());
	}
	
	@Test
	public void testNumberOfCombinations() {
		int max = 100;
		BigInteger[] bigFactorials = new BigInteger[max + 1];
		SolutionBig.fillFactorials(bigFactorials);
		long[][] binomial = new long[max + 1][max + 1];
		Solution.fillBinomial(binomial, max);
		Assert.assertEquals(Solution.numberOfCombinations(binomial, max, max - 1), SolutionBig.numberOfCombinations(bigFactorials, max, max - 1).mod(BigInteger.valueOf(Solution.MOD)).intValue());
	}
}
