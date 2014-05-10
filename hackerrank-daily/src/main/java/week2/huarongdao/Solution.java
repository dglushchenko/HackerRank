package week2.huarongdao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	private static final int NOT_MOVABLE_BLOCK = 0;
	private static final int MOVABLE_BLOCK = 1;
	private static final int EMPTY_SLOT = 2;
	private static final int CAO_CAO = 3;
	private static final int EXIT = 4;

	private static void print(int[][] board, int n, int m) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(board[i][j]);
				if (j < m - 1) {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static class Coordinate {
		private int x;
		private int y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
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
			Coordinate other = (Coordinate) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

	}

	private static boolean isValid(int[][] board, int n, int m, Map<Coordinate, Integer> counts, Coordinate coordinate, int count) {
		if (coordinate.x < 0 || coordinate.x > n - 1) {
			return false;
		}
		if (coordinate.y < 0 || coordinate.y > m - 1) {
			return false;
		}
		if (board[coordinate.x][coordinate.y] == NOT_MOVABLE_BLOCK) {
			return false;
		}
		Integer coordinateCount = counts.get(coordinate);
		if (coordinateCount != null && coordinateCount >= count) {
			return false;
		}
		
		return true;
	}
	
	private static int findPath(int[][] board, int n, int m, int fromX, int fromY, int toX, int toY) {
		Map<Coordinate, Integer> counts = new HashMap<Coordinate, Integer>();
		Queue<Coordinate> queue = new LinkedList<Coordinate>();
		Coordinate from = new Coordinate(fromX, fromY);
		Coordinate to = new Coordinate(toX, toY);
		queue.add(from);
		counts.put(from, 0);
		while (!queue.isEmpty()) {
			Coordinate coordinate = queue.poll();
			if (coordinate.equals(to)) {
				return counts.get(coordinate);
			}
			Coordinate left = new Coordinate(coordinate.x - 1, coordinate.y);
			Coordinate right = new Coordinate(coordinate.x + 1, coordinate.y);
			Coordinate up = new Coordinate(coordinate.x, coordinate.y - 1);
			Coordinate down = new Coordinate(coordinate.x, coordinate.y + 1);
			int count = counts.get(coordinate) + 1;
			if (isValid(board, n, m, counts, left, count)) {
				queue.add(left);
				counts.put(left, count);
			}
			if (isValid(board, n, m, counts, right, count)) {
				queue.add(right);
				counts.put(right, count);
			}
			if (isValid(board, n, m, counts, up, count)) {
				queue.add(up);
				counts.put(up, count);
			}
			if (isValid(board, n, m, counts, down, count)) {
				queue.add(down);
				counts.put(down, count);
			}
		}
		return -1;
	}

	public static int solve(int[][] board, int n, int m, int k, int ex, int ey, int sx, int sy, int tx, int ty) {
		int emptyCount = findPath(board, n, m, ex, ey, sx, sy);
		if (emptyCount < 0 || emptyCount > k) {
			emptyCount = k;
		}

		int caocaoCount = findPath(board, n, m, sx, sy, tx, ty);
		if (caocaoCount < 0 || caocaoCount > k) {
			caocaoCount = k;
		}
		
		return (emptyCount + 1) + (caocaoCount - 2) * 5;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		int q = in.nextInt();
		int[][] board = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				board[i][j] = in.nextInt();
			}
		}
		for (int i = 0; i < q; i++) {
			int ex = in.nextInt();
			int ey = in.nextInt();
			int sx = in.nextInt();
			int sy = in.nextInt();
			int tx = in.nextInt();
			int ty = in.nextInt();
			board[ex - 1][ey - 1] = EMPTY_SLOT;
			board[sx - 1][sy - 1] = CAO_CAO;
			board[tx - 1][ty - 1] = EXIT;
			System.out.println(solve(board, n, m, k, ex - 1, ey - 1, sx - 1, sy - 1, tx - 1, ty - 1));
		}
	}

}
