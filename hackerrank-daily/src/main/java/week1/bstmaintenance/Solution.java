package week1.bstmaintenance;

import java.util.Scanner;

public class Solution {

	private static class Node {
		private int number;
		// Indexes:
		// 0 - parent
		// 1 - left
		// 2 - right
		private Node[] relations = new Node[3];

		public Node(int number) {
			this.number = number;
		}

		public int add(int number) {
			if (number > this.number) {
				if (relations[2] == null) {
					Node node = new Node(number);
					node.relations[0] = this;
					relations[2] = node;
					return depthSum(node, this, 1);
				} else {
					return relations[2].add(number);
				}
			} else {
				if (relations[1] == null) {
					Node node = new Node(number);
					node.relations[0] = this;
					relations[1] = node;
					return depthSum(node, this, 1);
				} else {
					return relations[1].add(number);
				}
			}
		}

		private int depthSum(Node from, Node to, int depth) {
			if (to == null) {
				return 0;
			} else {
				int result = depth;
				for (int i = 0; i < 3; i++) {
					if (to.relations[i] == from) {
						continue;
					}
					if (to.relations[i] != null) {
						result += depthSum(to, to.relations[i], depth + 1);
					}
				}
				return result;
			}
		}
		
		@Override
		public String toString() {
			return "Node [this: " + number + ", relations: [" + 
				"0: " + (relations[0] == null ? "null" : relations[0].number) + 
				", 1: " + (relations[1] == null ? "null" : relations[1].number) + 
				", 2: " + (relations[2] == null ? "null" : relations[2].number) + "]";
		}

	}

	public static void solve(Scanner in) {
		int n = in.nextInt();
		Node root = new Node(in.nextInt());
		long result = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(result).append("\n");
		while (n-- > 1) {
			result += root.add(in.nextInt());
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		solve(in);
	}

}
