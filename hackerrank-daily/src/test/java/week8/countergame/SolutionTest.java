package week8.countergame;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

	private static final String RICHARD = "Richard";
	private static final String LOUISE = "Louise";

	@Test
	public void testSolve() {
		Assert.assertEquals(RICHARD, Solution.solve(BigInteger.valueOf(1L)));
		Assert.assertEquals(LOUISE, Solution.solve(BigInteger.valueOf(2L)));
		Assert.assertEquals(LOUISE, Solution.solve(BigInteger.valueOf(3L)));
		Assert.assertEquals(RICHARD, Solution.solve(BigInteger.valueOf(4L)));
		Assert.assertEquals(LOUISE, Solution.solve(BigInteger.valueOf(5L)));
		Assert.assertEquals(RICHARD, Solution.solve(BigInteger.valueOf(6L)));
		Assert.assertEquals(RICHARD, Solution.solve(BigInteger.valueOf(7L)));
		Assert.assertEquals(LOUISE, Solution.solve(BigInteger.valueOf(8L)));
		Assert.assertEquals(LOUISE, Solution.solve(BigInteger.valueOf(9L)));
		Assert.assertEquals(RICHARD, Solution.solve(BigInteger.valueOf(10L)));
		Assert.assertEquals(RICHARD, Solution.solve(BigInteger.valueOf(11L)));
		Assert.assertEquals(LOUISE, Solution.solve(BigInteger.valueOf(12L)));
		Assert.assertEquals(RICHARD, Solution.solve(BigInteger.valueOf(13L)));
		Assert.assertEquals(LOUISE, Solution.solve(BigInteger.valueOf(14L)));
		Assert.assertEquals(LOUISE, Solution.solve(BigInteger.valueOf(15L)));
	}

	@Test(timeout=4000)
	public void testSolveBig() {
		BigInteger n = new BigInteger("18446744073709551615");
		for (int i = 0; i < 10; i++) {
			Solution.solve(n.add(BigInteger.valueOf(i)));
		}
	}

}
