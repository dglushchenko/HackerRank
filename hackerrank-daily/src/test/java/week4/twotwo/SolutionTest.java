package week4.twotwo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

	@Test//(timeout=5000)
	public void testSolveForSmall() {
		String[] powersOfTwo = Solution.generatePowersOfTwo(Solution.MAX_POWER);
		for (int j = 0; j < 100; j++) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 420; i++) {
				sb.append("3255866422304616344765552632188114158762089024568314531443485259650408807528140659922574316831813618526821245406949824436469141432675471230646169947427163108444901161872077421124549944292877941762189949285100879873872435565174053364826112");
			}
			String string = sb.toString();
			
			int count = 0;
			count = Solution.solveForSmall(string, powersOfTwo, string.length());
			Assert.assertEquals(55860, count);
		}
	}
	
	@Test//(timeout=5000)
	public void testSolveForBig() {
		String[] powersOfTwo = Solution.generatePowersOfTwo(Solution.MAX_POWER);
		Map<Integer, Set<String>> powersOfTwoIndex = Solution.generatePowersOfTwoIndexes(powersOfTwo, Solution.THRESHOLD);

		for (int j = 0; j < 100; j++) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 420; i++) {
				sb.append("3255866422304616344765552632188114158762089024568314531443485259650408807528140659922574316831813618526821245406949824436469141432675471230646169947427163108444901161872077421124549944292877941762189949285100879873872435565174053364826112");
			}
			String string = sb.toString();
			
			int count = 0;
			count = Solution.solveForSmall(string, powersOfTwo, Solution.THRESHOLD);
			if (string.length() >= Solution.THRESHOLD) {
				count += Solution.solveForBig(string, powersOfTwoIndex, Solution.THRESHOLD);
			}
			Assert.assertEquals(55860, count);
		}
	}
	
	@Test//(timeout=5000)
	public void testSolveForBigRandom() {
		long min = Long.MAX_VALUE;
		long max = Long.MIN_VALUE;
		long avg = 0;
		final long t = 100;
		String[] powersOfTwo = Solution.generatePowersOfTwo(Solution.MAX_POWER);
		for (int k = 0; k < t; k++) {
			long start = System.currentTimeMillis();
			Map<Integer, Set<String>> powersOfTwoIndex = Solution.generatePowersOfTwoIndexes(powersOfTwo, Solution.THRESHOLD);
	
			long smallDuration = 0;
			long bigDuration = 0;
			long stringDuration = 0;
			
			for (int j = 0; j < 100; j++) {
				long stringStart = System.currentTimeMillis();
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < 100000; i++) {
					sb.append((int) (Math.random() * 10));
				}
				String string = sb.toString();
				stringDuration += System.currentTimeMillis() - stringStart;
				
				int count = 0;
				long smallStart = System.currentTimeMillis();
				count = Solution.solveForSmall(string, powersOfTwo, Solution.THRESHOLD);
				smallDuration += System.currentTimeMillis() - smallStart;
				if (string.length() >= Solution.THRESHOLD) {
					long bigStart = System.currentTimeMillis();
					count += Solution.solveForBig(string, powersOfTwoIndex, Solution.THRESHOLD);
					bigDuration += System.currentTimeMillis() - bigStart;
				}
				//Assert.assertEquals(55860, count);
			}
			long finish = System.currentTimeMillis();
			long duration = finish - start;
			System.out.println(k + ": " + smallDuration + " + " + bigDuration + " + " + stringDuration + " = " + duration);
			//Assert.assertTrue(duration < 5000);
			min = Math.min(min, duration);
			max = Math.max(max, duration);
			avg += duration;
		}
		System.out.println("min: " + min + ", max: " + max + ", avg: " + (avg / t));
	}
	
	/*@Test
	public void testIndexString() {
		Map<Integer, List<Integer>> index = Solution.indexString("123123123", 3);
		System.out.println(index);
	}*/
	
	@Test(timeout=5000)
	public void testFindPower() {
		int maxPower = 800;
		List<String> powersOfTwo = new ArrayList<String>();
		BigInteger powerOfTwo = BigInteger.ONE;
		String maxString = "1";
		int max = 0;
		int maxP = 0;
		for (int i = 0; i < maxPower; i++) {
			String string = powerOfTwo.toString();
			powersOfTwo.add(string);
			int count = 0;
			for (String s : powersOfTwo) {
				int fromIndex = 0;
				while (true) {
					int indexOf = string.indexOf(s, fromIndex);
					if (indexOf == -1) {
						break;
					}
					count++;
					fromIndex = indexOf + 1;
				}
			}
			if (count > max) {
				max = count;
				maxString = string;
				maxP = i;
			}
			powerOfTwo = powerOfTwo.multiply(BigInteger.valueOf(2L));
		}
		System.out.println("string: " + maxString);
		System.out.println("length: " + maxString.length());
		System.out.println("count: " + max);
		System.out.println("power: " + maxP);
	}
	
}
