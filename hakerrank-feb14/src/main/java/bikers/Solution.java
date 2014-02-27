package bikers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	private static int numberOfBikes;
	private static int numberOfBikers;
	private static int numberOfPairs;
	private static List<Point> bikes = new ArrayList<Point>();
	private static List<Point> bikers = new ArrayList<Point>();

	private static class Point {
		private int x;
		private int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
	}

	private static void parseInput(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));

			String input = br.readLine();

			String[] mainValues = input.split(" ");
			numberOfBikers = Integer.valueOf(mainValues[0]);
			numberOfBikes = Integer.valueOf(mainValues[1]);
			numberOfPairs = Integer.valueOf(mainValues[2]);

			int bikersCounter = numberOfBikers;
			while ((input = br.readLine()) != null) {
				String[] pointValues = input.split(" ");
				if (pointValues.length < 2) {
					break;
				}
				Point point = new Point(Integer.valueOf(pointValues[0]),
						Integer.valueOf(pointValues[1]));
				if (bikersCounter-- > 0) {
					bikers.add(point);
				} else {
					bikes.add(point);
				}
			}

		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	private static double distance(Point a, Point b) {
		return Math.sqrt(Math.pow(a.getX() - b.getX(), 2.0)
				+ Math.pow(a.getY() - b.getY(), 2));
	}

	private static void mock() {
		numberOfBikers = 3;
		numberOfBikes = 3;
		numberOfPairs = 2;
		bikers.add(new Point(0, 1));
		bikers.add(new Point(0, 2));
		bikers.add(new Point(0, 3));
		bikes.add(new Point(100, 1));
		bikes.add(new Point(200, 2));
		bikes.add(new Point(300, 3));
	}

	public static void main(String[] args) {
		//parseInput(args);
		mock();
		double[][] map = new double[bikes.size()][bikers.size()];
		for (int i = 0; i < numberOfBikes; i++) {
			for (int j = 0; j < numberOfBikers; j++) {
				map[i][j] = distance(bikes.get(i), bikers.get(j));
			}
			//Arrays.sort(map[i]);
		}

		int k = 0;
		Set<Integer> usedBikes = new HashSet<Integer>();
		Set<Integer> usedBikers = new HashSet<Integer>();
		double max = Double.MIN_VALUE;
		while (k < numberOfPairs) {
			double min = Double.MAX_VALUE;
			int usedI = -1;
			int usedJ = -1;
			for (int i = 0; i < numberOfBikes; i++) {
				if (usedBikes.contains(i)) {
					continue;
				}
				for (int j = 0; j < numberOfBikers; j++) {
					if (usedBikers.contains(i)) {
						continue;
					}
					if (map[i][j] < min) {
						min = map[i][j];
						usedI = i;
						usedJ = j;
					}
				}
			}
			if (min > max) {
				max = min;
			}
			k++;
			usedBikes.add(usedI);
			usedBikers.add(usedJ);
		}

		System.out.println((int) Math.pow(max, 2));
	}

}
