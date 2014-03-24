package travellingsalesmaninagrid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	private static class Relation {
		private int from;
		private int to;

		public Relation(int from, int to) {
			this.from = from;
			this.to = to;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + from;
			result = prime * result + to;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Relation other = (Relation) obj;
			if (from == other.from && to == other.to || from == other.to && to == other.from)
				return true;
			return false;
		}

		@Override
		public String toString() {
			return "Relation [from=" + from + ", to=" + to + "]";
		}

	}

	
	private static void construct(List<int[][]> list) {
		int[][] array = new int[4][3];
		
		
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();

		int product = m * n;

		int result = 0;

		if (product % 2 == 0) {
			Map<Relation, Integer> graph = new HashMap<Relation, Integer>();
			for (int i = 1; i <= n * m; i++) {
				if (i % n == 0) {
					continue;
				}
				graph.put(new Relation(i, i + 1), scanner.nextInt());
			}

			for (int i = 1; i <= (n - 1) * m; i++) {
				graph.put(new Relation(i, i + m), scanner.nextInt());
			}

			for (Relation relation : graph.keySet()) {
				System.out.println(relation + ": " + graph.get(relation));
			}
		}

		System.out.println(result);
	}
}
