package week2.cutthetree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	private static class Node {
		private int index;
		private int number;
		private List<Node> nodes = new ArrayList<Node>();
		private Map<Node, Integer> sums = new HashMap<Node, Integer>();

		public Node(int index, int number, Map<Integer, Node> indexToNodeMap) {
			this.index = index;
			this.number = number;
			indexToNodeMap.put(index, this);
		}

		public boolean addEdge(int fromIndex, int toIndex, int fromNumber, int toNumber, Map<Integer, Node> indexToNodeMap) {
			Node from = indexToNodeMap.get(fromIndex);
			Node to = indexToNodeMap.get(toIndex);
			if (from == null && to == null) {
				return false;
			}
			if (from == null) {
				from = new Node(fromIndex, fromNumber, indexToNodeMap);
			}
			if (to == null) {
				to = new Node(toIndex, toNumber, indexToNodeMap);
			}
			to.nodes.add(from);
			from.nodes.add(to);
			return true;
		}

		public int findSum(Node except) {
			Integer savedSum = sums.get(except);
			if (savedSum != null) {
				return savedSum;
			}

			int sum = number;
			for (Node relation : nodes) {
				if (relation == except) {
					continue;
				}
				int relationSum = relation.findSum(this);
				sums.put(relation, relationSum);
				sum += relationSum;
			}
			sums.put(except, sum);
			return sum;
		}

		@Override
		public String toString() {
			return "Node [index=" + index + ", number=" + number + "]";
		}

	}

	/**
	 * @author YC14DG1
	 *
	 */
	public static class Relation {
		private int from;
		private int to;

		public Relation(int from, int to) {
			this.from = from;
			this.to = to;
		}

		@Override
		public String toString() {
			return "Relation [from=" + from + ", to=" + to + "]";
		}
		
	}

	public static int solve(List<Relation> relations, Map<Integer, List<Integer>> relationsMap, int[] values, int sum) {
		long start = System.currentTimeMillis();
		Map<Integer, Node> indexToNodeMap = new HashMap<Integer, Node>();
		int rootIndex = relations.get(0).from;
		Node root = new Node(rootIndex, values[rootIndex - 1], indexToNodeMap);
		List<Relation> relationsLeft = new LinkedList<Relation>(relations);
		System.out.println("prep: " + (System.currentTimeMillis() - start));
		long addTime = 0;
		long removeTime = 0;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int fromIndex = node.index;
			List<Integer> toIndexes = relationsMap.get(fromIndex);
			if (toIndexes != null) {
				for (int toIndex : toIndexes) {
					long addStart = System.currentTimeMillis();
					root.addEdge(fromIndex, toIndex, values[fromIndex - 1], values[toIndex - 1], indexToNodeMap);
					long oneAddTime = System.currentTimeMillis() - addStart;
					addTime += oneAddTime;
				}
			}
		}
		
		
		while (!relationsLeft.isEmpty()) {
			ListIterator<Relation> iterator = relationsLeft.listIterator();
			while (iterator.hasNext()) {
				Relation relation = iterator.next();
				long addStart = System.currentTimeMillis();
				boolean addEdge = root.addEdge(relation.from, relation.to, values[relation.from - 1], values[relation.to - 1], indexToNodeMap);
				long oneAddTime = System.currentTimeMillis() - addStart;
				System.out.println(relation);
				addTime += oneAddTime;
				if (addEdge) {
					long removeStart = System.currentTimeMillis();
					iterator.remove();
					removeTime += System.currentTimeMillis() - removeStart;
				}
			}
		}
		System.out.println("addTime: " + addTime);
		System.out.println("removeTime: " + removeTime);
		int min = Integer.MAX_VALUE;
		for (Relation relation : relations) {
			Node fromNode = indexToNodeMap.get(relation.from);
			Node toNode = indexToNodeMap.get(relation.to);
			int relationSum = fromNode.findSum(toNode);
			min = Math.min(min, Math.abs(2 * relationSum - sum));
		}
		return min;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] values = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			values[i] = in.nextInt();
			sum += values[i];
		}
		List<Relation> relations = new LinkedList<Relation>();
		Map<Integer, List<Integer>> relationsMap = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < n - 1; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			relations.add(from < to ? new Relation(from, to) : new Relation(to, from));
			List<Integer> toList = relationsMap.get(from);
			if (toList == null) {
				toList = new ArrayList<Integer>();
			}
			toList.add(to);
			List<Integer> fromList = relationsMap.get(to);
			if (fromList == null) {
				fromList = new ArrayList<Integer>();
			}
			fromList.add(from);
		}
		System.out.println(solve(relations, relationsMap, values, sum));
	}

}
