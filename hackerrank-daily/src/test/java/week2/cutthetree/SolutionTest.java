package week2.cutthetree;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import week2.cutthetree.Solution.Relation;

public class SolutionTest {

	/*@Test(timeout = 5000)
	public void testSolve() {
		Assert.assertEquals(400, Solution.solve(new LinkedList<String>(Arrays.asList(new String[] { "1 2", "2 3", "2 5", "4 5", "5 6" })), new int[] { 100, 200, 100, 500, 100, 600 }, 1600));

		Assert.assertEquals(1, Solution.solve(new LinkedList<String>(Arrays.asList(new String[] { "1 2", "2 3" })), new int[] { 1, 1, 1 }, 3));
		Assert.assertEquals(1, Solution.solve(new LinkedList<String>(Arrays.asList(new String[] { "2 1", "2 3" })), new int[] { 1, 1, 1 }, 3));
		Assert.assertEquals(1, Solution.solve(new LinkedList<String>(Arrays.asList(new String[] { "1 2", "3 2" })), new int[] { 1, 1, 1 }, 3));
		Assert.assertEquals(1, Solution.solve(new LinkedList<String>(Arrays.asList(new String[] { "2 1", "3 2" })), new int[] { 1, 1, 1 }, 3));

		Assert.assertEquals(999, Solution.solve(new LinkedList<String>(Arrays.asList(new String[] { "1 2", "2 3" })), new int[] { 1, 1, 1001 }, 1003));
	}*/

	/*@Test//(timeout = 5000)
	public void testSolveOriginal() {
		Assert.assertEquals(400, Solution.solve(new LinkedList<Relation>(Arrays.asList(new Relation[] { new Relation(1, 2), new Relation(2, 3), new Relation(2, 5), new Relation(4, 5), new Relation(5, 6) })), new int[] { 100, 200, 100, 500, 100, 600 }, 1600));
	}*/
	
	/*@Test(timeout = 5000)
	public void testSolveNotInOrder() {
		Assert.assertEquals(0, Solution.solve(new LinkedList<String>(Arrays.asList(new String[] { "1 2", "3 4", "2 3" })), new int[] { 1, 1, 1, 1 }, 4));
		Assert.assertEquals(0, Solution.solve(new LinkedList<String>(Arrays.asList(new String[] { "1 2", "3 4", "5 6", "4 5", "3 2" })), new int[] { 1, 1, 1, 1, 1, 1 }, 6));
		Assert.assertEquals(1, Solution.solve(new LinkedList<String>(Arrays.asList(new String[] { "1 4", "3 2", "2 5", "4 3" })), new int[] { 1, 1, 1, 1, 1 }, 5));
	}

	@Test(timeout = 5000)
	public void testSolveStar() {
		Assert.assertEquals(3, Solution.solve(new LinkedList<String>(Arrays.asList(new String[] { "1 2", "1 3", "1 4", "1 5" })), new int[] { 1, 1, 1, 1, 1 }, 5));
	}*/

	/*@Test(timeout = 5000)
	public void testSolvePerformance() {
		int n = 100000;
		List<Relation> relations = new LinkedList<Relation>();
		for (int i = 0; i < n - 1; i++) {
			relations.add(new Relation(i + 1, i + 2));
		}
		int[] values = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			values[i] = 1001;
			sum += values[i];
		}
		Assert.assertEquals(0, Solution.solve(relations, values, sum));
	}

	@Test(timeout = 5000)
	public void testSolvePerformanceBigFirst() {
		int n = 100000;
		List<Relation> relations = new LinkedList<Relation>();
		for (int i = 0; i < n - 1; i++) {
			relations.add(new Relation(i + 2, i + 1));
		}
		int[] values = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			values[i] = 1001;
			sum += values[i];
		}
		Assert.assertEquals(0, Solution.solve(relations, values, sum));
	}

	@Test//(timeout = 10000)
	public void testSolvePerformanceShuffle() {
		int n = 100000;
		List<Relation> relations = new LinkedList<Relation>();
		for (int i = 0; i < n - 1; i++) {
			relations.add(new Relation(i + 2, i + 1));
		}
		Collections.shuffle(relations);
		int[] values = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			values[i] = 1001;
			sum += values[i];
		}
		Assert.assertEquals(0, Solution.solve(relations, values, sum));
	}*/
	
}
