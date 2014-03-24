package thebouncingflyingball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static class Point {
		private int x;
		private int y;
		private int z;

		public Point(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public Point(Point p) {
			this(p.x, p.y, p.z);
		}

		@Override
		public String toString() {
			return "(" + x + ", " + y + ", " + z + ")";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			result = prime * result + z;
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
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			if (z != other.z)
				return false;
			return true;
		}

	}

	// (x - x1) / (x2 - x1) = (y - y1) / (y2 - y1) = (z - z1) / (z2 - z1)
	private static boolean areCollinear(Point a, Point b, Point c) {
		if (b.equals(c)) {
			return false;
		}

		double x = ((double) a.x - b.x) / (c.x - b.x);
		double y = ((double) a.y - b.y) / (c.y - b.y);
		double z = ((double) a.z - b.z) / (c.z - b.z);

		return x == y && x == z;
	}

	public static int[] calculate(Point machine, int dx, int dy, int dz, int l, int w, int h, Point sergey, Point chen) {
		int[] counts = new int[] { 0, 0 };

		Point ball = new Point(machine);
		Point previousBall = null;
		Point firstBall = new Point(machine);
		Point secondBall = null;

		boolean xForward = true;
		boolean yForward = true;
		boolean zForward = true;
		int index = 1;
		boolean secondBallRecorded = false;
		while (index++ <= 100) {

			// X
			int x;
			if (xForward) {
				x = ball.x + dx;
			} else {
				x = ball.x - dx;
			}

			if (x > l) {
				ball.x = 2 * l - x;
				xForward = !xForward;
			} else if (x < 0) {
				ball.x = -x;
				xForward = !xForward;
			} else {
				ball.x = x;
			}

			// Y
			int y;
			if (yForward) {
				y = ball.y + dy;
			} else {
				y = ball.y - dy;
			}

			if (y > w) {
				ball.y = 2 * w - y;
				yForward = !yForward;
			} else if (y < 0) {
				ball.y = -y;
				yForward = !yForward;
			} else {
				ball.y = y;
			}

			// Z
			int z;
			if (zForward) {
				z = ball.z + dz;
			} else {
				z = ball.z - dz;
			}

			if (z > h) {
				ball.z = 2 * h - z;
				zForward = !zForward;
			} else if (z < 0) {
				ball.z = -z;
				zForward = !zForward;
			} else {
				ball.z = z;
			}

			// System.out.println(ball);

			if (sergey.equals(ball) || (previousBall != null && areCollinear(sergey, ball, previousBall))) {
				counts[0] = counts[0] + 1;
				break;
			} else if (chen.equals(ball) || (previousBall != null && areCollinear(chen, ball, previousBall))) {
				counts[1] = counts[1] + 1;
				break;
			}

			if (!secondBallRecorded) {
				secondBall = new Point(ball);
				secondBallRecorded = true;
			} else {
				if (firstBall.equals(previousBall) && secondBall.equals(ball)) {
					break;
				}
			}

			previousBall = new Point(ball);
		}
		// System.out.println("---------------------");

		return counts;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while (t-- > 0) {
			int l = scanner.nextInt();
			int w = scanner.nextInt();
			int h = scanner.nextInt();
			Point sergey = new Point(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
			Point chen = new Point(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
			Point machine = new Point(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
			int n = scanner.nextInt();

			int sergeyCount = 0;
			int chenCount = 0;
			Set<Point> exclusions = new HashSet<Point>();
			for (int dx = 0 - n; dx <= n; dx++) {
				for (int dy = 0 - n; dy <= n; dy++) {
					for (int dz = 0 - n; dz <= n; dz++) {
						if (dx == 0 && dy == 0 && dz == 0) {
							continue;
						}

						/*
						 * if (exclusions.contains(new Point(dx, dy, dz))) {
						 * continue; }
						 */

						int[] counts = calculate(machine, dx, dy, dz, l, w, h, sergey, chen);
						sergeyCount += counts[0];
						chenCount += counts[1];

						System.out.println(new Point(dx, dy, dz) + ": [" + counts[0] + ", " + counts[1] + "]");

						for (int i = -n; i <= n; i++) {
							exclusions.add(new Point(dx + i, dy + i, dz + i));
						}
					}
				}
			}

			/*
			 * if (sergey.x > h || sergey.y > l || sergey.z > w) { sergeyCount =
			 * 0; }
			 * 
			 * if (chen.x > h || chen.y > l || chen.z > w) { chenCount = 0; }
			 */

			System.out.println(sergeyCount + " " + chenCount);
		}
	}

}
