package week11.treepruning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void updateWeights(Map<Integer, Long> ownWeigths, Map<Integer, Long> subtreeWeigths, Map<Integer, Integer> parents, int n) {
		for (int id = 1; id <= n; id++) {
			long weight = ownWeigths.get(id);
			subtreeWeigths.put(id, weight);
			if (id > 1) {
				int parentId = parents.get(id);
				while (true) {
					long parentWeight = subtreeWeigths.get(parentId);
					subtreeWeigths.put(parentId, parentWeight + weight);
					if (parentId == 1) {
						break;
					}
					parentId = parents.get(parentId);
				}
			}
		}
	}

	private static int findMinWeightNode(Map<Integer, Long> ownWeights, Map<Integer, Long> subtreeWeigths, int n) {
		int minId = 1;
		long minSubtreeWeight = Long.MAX_VALUE;
		long minOwnWeight = Long.MAX_VALUE;
		for (int id = 1; id <= n; id++) {
			long ownWeight = ownWeights.get(id);
			long subtreeWeight = subtreeWeigths.get(id);
			if (subtreeWeight < minSubtreeWeight && ownWeight <= 0) {
				minSubtreeWeight = subtreeWeight;
				minOwnWeight = ownWeight;
				minId = id;
			}
		}
		return minSubtreeWeight < 0 ? minId : 0;
	}

	private static void prune(Map<Integer, Long> ownWeights, Map<Integer, Long> subtreeWeigths, Map<Integer, List<Integer>> children, Map<Integer, Integer> parents, int minId) {
		long weight = subtreeWeigths.get(minId);

		// down
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(minId);
		while (!queue.isEmpty()) {
			int id = queue.remove();
			ownWeights.put(id, 0L);
			subtreeWeigths.put(id, 0L);
			List<Integer> childrenList = children.get(id);
			if (childrenList == null) {
				continue;
			}
			for (int childId : childrenList) {
				queue.add(childId);
			}
		}

		// up
		if (minId > 1) {
			int parentId = parents.get(minId);
			while (true) {
				long parentWeight = subtreeWeigths.get(parentId);
				subtreeWeigths.put(parentId, parentWeight - weight);
				if (parentId == 1) {
					break;
				}
				parentId = parents.get(parentId);
			}
		}
	}

	public static long solve(Map<Integer, Long> ownWeigths, Map<Integer, List<Integer>> children, Map<Integer, Integer> parents, int n, int k) {
		Map<Integer, Long> subtreeWeigths = new HashMap<Integer, Long>();
		updateWeights(ownWeigths, subtreeWeigths, parents, n);
		int count = 0;
		while (count < k) {
			int minId = findMinWeightNode(ownWeigths, subtreeWeigths, n);
			if (minId == 0) {
				break;
			}
			prune(ownWeigths, subtreeWeigths, children, parents, minId);
			count++;
		}

		return subtreeWeigths.get(1);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			int n = in.nextInt();
			int k = in.nextInt();

			Map<Integer, Long> ownWeigths = new HashMap<Integer, Long>();
			Map<Integer, List<Integer>> children = new HashMap<Integer, List<Integer>>();
			Map<Integer, Integer> parents = new HashMap<Integer, Integer>();

			for (int i = 0; i < n; i++) {
				ownWeigths.put(i + 1, in.nextLong());
			}

			for (int i = 0; i < n - 1; i++) {
				int from = in.nextInt();
				int to = in.nextInt();
				if (from > to) {
					int tmp = from;
					from = to;
					to = tmp;
				}
				List<Integer> childrenList = children.get(from);
				if (childrenList == null) {
					childrenList = new ArrayList<Integer>();
				}
				childrenList.add(to);
				children.put(from, childrenList);
				parents.put(to, from);
			}
			System.out.println(solve(ownWeigths, children, parents, n, k));
		} finally {
			in.close();
		}
	}

}
