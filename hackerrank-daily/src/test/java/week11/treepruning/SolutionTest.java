package week11.treepruning;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSolveSample() {
		int n = 5;
		int k = 2;

		Map<Integer, Long> ownWeigths = new HashMap<Integer, Long>();
		ownWeigths.put(1, 1L);
		ownWeigths.put(2, 1L);
		ownWeigths.put(3, -1L);
		ownWeigths.put(4, -1L);
		ownWeigths.put(5, -1L);

		Map<Integer, List<Integer>> children = new HashMap<Integer, List<Integer>>();
		children.put(1, Arrays.asList(new Integer[] { 2, 4 }));
		children.put(2, Arrays.asList(new Integer[] { 3 }));
		children.put(4, Arrays.asList(new Integer[] { 5 }));

		Map<Integer, Integer> parents = new HashMap<Integer, Integer>();
		parents.put(2, 1);
		parents.put(3, 2);
		parents.put(4, 1);
		parents.put(5, 4);

		Assert.assertEquals(2L, Solution.solve(ownWeigths, children, parents, n, k));
	}

	@Test
	public void testSolveOnePositive() {
		int n = 1;
		int k = 1;

		Map<Integer, Long> ownWeigths = new HashMap<Integer, Long>();
		ownWeigths.put(1, 1L);

		Map<Integer, List<Integer>> children = new HashMap<Integer, List<Integer>>();
		Map<Integer, Integer> parents = new HashMap<Integer, Integer>();

		Assert.assertEquals(1L, Solution.solve(ownWeigths, children, parents, n, k));
	}

	@Test
	public void testSolveOneZero() {
		int n = 1;
		int k = 1;

		Map<Integer, Long> ownWeigths = new HashMap<Integer, Long>();
		ownWeigths.put(1, 0L);

		Map<Integer, List<Integer>> children = new HashMap<Integer, List<Integer>>();
		Map<Integer, Integer> parents = new HashMap<Integer, Integer>();

		Assert.assertEquals(0L, Solution.solve(ownWeigths, children, parents, n, k));
	}


	@Test
	public void testSolveOneNegative() {
		int n = 1;
		int k = 1;

		Map<Integer, Long> ownWeigths = new HashMap<Integer, Long>();
		ownWeigths.put(1, -1L);

		Map<Integer, List<Integer>> children = new HashMap<Integer, List<Integer>>();
		Map<Integer, Integer> parents = new HashMap<Integer, Integer>();

		Assert.assertEquals(0L, Solution.solve(ownWeigths, children, parents, n, k));
	}

	@Test
	public void testSolveThreeNegative() {
		int n = 3;
		int k = 3;

		Map<Integer, Long> ownWeigths = new HashMap<Integer, Long>();
		ownWeigths.put(1, -1L);
		ownWeigths.put(2, -1L);
		ownWeigths.put(3, -1L);

		Map<Integer, List<Integer>> children = new HashMap<Integer, List<Integer>>();
		children.put(1, Arrays.asList(new Integer[] { 2 }));
		children.put(2, Arrays.asList(new Integer[] { 3 }));

		Map<Integer, Integer> parents = new HashMap<Integer, Integer>();
		parents.put(2, 1);
		parents.put(3, 2);

		Assert.assertEquals(0L, Solution.solve(ownWeigths, children, parents, n, k));
	}

	@Test
	public void testSolveThreeLeafsNegative() {
		int n = 3;
		int k = 3;

		Map<Integer, Long> ownWeigths = new HashMap<Integer, Long>();
		ownWeigths.put(1, 1L);
		ownWeigths.put(2, -1L);
		ownWeigths.put(3, -1L);

		Map<Integer, List<Integer>> children = new HashMap<Integer, List<Integer>>();
		children.put(1, Arrays.asList(new Integer[] { 2, 3 }));

		Map<Integer, Integer> parents = new HashMap<Integer, Integer>();
		parents.put(2, 1);
		parents.put(3, 1);

		Assert.assertEquals(1L, Solution.solve(ownWeigths, children, parents, n, k));
	}

	@Test
	public void testSolveThreeLeafsNegativeBiggerWeight() {
		int n = 3;
		int k = 3;

		Map<Integer, Long> ownWeigths = new HashMap<Integer, Long>();
		ownWeigths.put(1, 1L);
		ownWeigths.put(2, -2L);
		ownWeigths.put(3, -2L);

		Map<Integer, List<Integer>> children = new HashMap<Integer, List<Integer>>();
		children.put(1, Arrays.asList(new Integer[] { 2, 3 }));

		Map<Integer, Integer> parents = new HashMap<Integer, Integer>();
		parents.put(2, 1);
		parents.put(3, 1);

		Assert.assertEquals(1L, Solution.solve(ownWeigths, children, parents, n, k));
	}

	@Test
	public void testSolveThreeLeafsNegativeOneBiggerWeight() {
		int n = 3;
		int k = 3;

		Map<Integer, Long> ownWeigths = new HashMap<Integer, Long>();
		ownWeigths.put(1, 1L);
		ownWeigths.put(2, 2L);
		ownWeigths.put(3, -2L);

		Map<Integer, List<Integer>> children = new HashMap<Integer, List<Integer>>();
		children.put(1, Arrays.asList(new Integer[] { 2, 3 }));

		Map<Integer, Integer> parents = new HashMap<Integer, Integer>();
		parents.put(2, 1);
		parents.put(3, 1);

		Assert.assertEquals(3L, Solution.solve(ownWeigths, children, parents, n, k));
	}

	@Test
	public void testSolveThreeLeafsNegativeLimitOne() {
		int n = 3;
		int k = 1;

		Map<Integer, Long> ownWeigths = new HashMap<Integer, Long>();
		ownWeigths.put(1, 1L);
		ownWeigths.put(2, -1L);
		ownWeigths.put(3, -1L);

		Map<Integer, List<Integer>> children = new HashMap<Integer, List<Integer>>();
		children.put(1, Arrays.asList(new Integer[] { 2, 3 }));

		Map<Integer, Integer> parents = new HashMap<Integer, Integer>();
		parents.put(2, 1);
		parents.put(3, 1);

		Assert.assertEquals(0L, Solution.solve(ownWeigths, children, parents, n, k));
	}

	@Test
	public void testSolveThreeLeafsOneNegativeLeaf() {
		int n = 3;
		int k = 3;

		Map<Integer, Long> ownWeigths = new HashMap<Integer, Long>();
		ownWeigths.put(1, 1L);
		ownWeigths.put(2, 1L);
		ownWeigths.put(3, -1L);

		Map<Integer, List<Integer>> children = new HashMap<Integer, List<Integer>>();
		children.put(1, Arrays.asList(new Integer[] { 2, 3 }));

		Map<Integer, Integer> parents = new HashMap<Integer, Integer>();
		parents.put(2, 1);
		parents.put(3, 1);

		Assert.assertEquals(2L, Solution.solve(ownWeigths, children, parents, n, k));
	}

	@Test
	public void testSolveThreeLeafsRootAndOneNegativeLeaf() {
		int n = 3;
		int k = 3;

		Map<Integer, Long> ownWeigths = new HashMap<Integer, Long>();
		ownWeigths.put(1, -1L);
		ownWeigths.put(2, 2L);
		ownWeigths.put(3, -1L);

		Map<Integer, List<Integer>> children = new HashMap<Integer, List<Integer>>();
		children.put(1, Arrays.asList(new Integer[] { 2, 3 }));

		Map<Integer, Integer> parents = new HashMap<Integer, Integer>();
		parents.put(2, 1);
		parents.put(3, 1);

		Assert.assertEquals(1L, Solution.solve(ownWeigths, children, parents, n, k));
	}

	@Test
	public void testSolveThreeLeafsRootNegative() {
		int n = 3;
		int k = 3;

		Map<Integer, Long> ownWeigths = new HashMap<Integer, Long>();
		ownWeigths.put(1, -1L);
		ownWeigths.put(2, 2L);
		ownWeigths.put(3, 1L);

		Map<Integer, List<Integer>> children = new HashMap<Integer, List<Integer>>();
		children.put(1, Arrays.asList(new Integer[] { 2, 3 }));

		Map<Integer, Integer> parents = new HashMap<Integer, Integer>();
		parents.put(2, 1);
		parents.put(3, 1);

		Assert.assertEquals(2L, Solution.solve(ownWeigths, children, parents, n, k));
	}

	@Test
	public void testSolveRootAndLeafNegative() {
		int n = 3;
		int k = 3;

		Map<Integer, Long> ownWeigths = new HashMap<Integer, Long>();
		ownWeigths.put(1, -1L);
		ownWeigths.put(2, 1L);
		ownWeigths.put(3, -1L);

		Map<Integer, List<Integer>> children = new HashMap<Integer, List<Integer>>();
		children.put(1, Arrays.asList(new Integer[] { 2 }));
		children.put(2, Arrays.asList(new Integer[] { 3 }));

		Map<Integer, Integer> parents = new HashMap<Integer, Integer>();
		parents.put(2, 1);
		parents.put(3, 2);

		Assert.assertEquals(0L, Solution.solve(ownWeigths, children, parents, n, k));
	}

	@Test
	public void testSolveRootAndLeafNegativeRootSmaller() {
		int n = 3;
		int k = 3;

		Map<Integer, Long> ownWeigths = new HashMap<Integer, Long>();
		ownWeigths.put(1, -2L);
		ownWeigths.put(2, 3L);
		ownWeigths.put(3, -1L);

		Map<Integer, List<Integer>> children = new HashMap<Integer, List<Integer>>();
		children.put(1, Arrays.asList(new Integer[] { 2 }));
		children.put(2, Arrays.asList(new Integer[] { 3 }));

		Map<Integer, Integer> parents = new HashMap<Integer, Integer>();
		parents.put(2, 1);
		parents.put(3, 2);

		Assert.assertEquals(1L, Solution.solve(ownWeigths, children, parents, n, k));
	}

	@Test
	public void testSolveRootAndLeafNegativeLeafSmaller() {
		int n = 3;
		int k = 3;

		Map<Integer, Long> ownWeigths = new HashMap<Integer, Long>();
		ownWeigths.put(1, -1L);
		ownWeigths.put(2, 3L);
		ownWeigths.put(3, -2L);

		Map<Integer, List<Integer>> children = new HashMap<Integer, List<Integer>>();
		children.put(1, Arrays.asList(new Integer[] { 2 }));
		children.put(2, Arrays.asList(new Integer[] { 3 }));

		Map<Integer, Integer> parents = new HashMap<Integer, Integer>();
		parents.put(2, 1);
		parents.put(3, 2);

		Assert.assertEquals(2L, Solution.solve(ownWeigths, children, parents, n, k));
	}

}
