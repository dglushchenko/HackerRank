package expectation;

import java.math.BigInteger;

import org.junit.Test;
import static org.junit.Assert.*;


public class SolutionTest {

	@Test
	public void testIsDivisibleByThree() {
		assertTrue(Solution.isDivisibleByThree(BigInteger.valueOf(3)));
		assertTrue(Solution.isDivisibleByThree(BigInteger.valueOf(243)));
		assertTrue(Solution.isDivisibleByThree(BigInteger.valueOf(243243234)));
		assertFalse(Solution.isDivisibleByThree(BigInteger.valueOf(22222)));
		assertFalse(Solution.isDivisibleByThree(new BigInteger("31999999680000001279999997440000002559999998976")));
		assertTrue(Solution.isDivisibleByThree(new BigInteger("111111111111111111111111111111111111111111111111111111111111111111111111111111111")));
		assertFalse(Solution.isDivisibleByThree(new BigInteger("11111111111111111111111111111111111111111111111111111111111111111111111111111111")));
	}
	
	/*@Test
	public void testReduce() {
		BigInteger up = BigInteger.valueOf(243);
		BigInteger down = BigInteger.valueOf(243);
		Solution.reduce(up, down);
		assertEquals(1, up.intValue());
		assertEquals(1, down.intValue());
	}*/
	
}
