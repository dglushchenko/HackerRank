package sherlockandsquares;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner.nextInt();
		while (scanner.hasNextLine()) {
			int from = scanner.nextInt();
			int to = scanner.nextInt();
			double fromSqrt = Math.sqrt(from);
			double toSqrt = Math.sqrt(to);
			int fromNumber = (int) Math.ceil(fromSqrt);
			int toNumber = (int) Math.floor(toSqrt);
			System.out.println(toNumber - fromNumber + 1);
		}
	}
	
}