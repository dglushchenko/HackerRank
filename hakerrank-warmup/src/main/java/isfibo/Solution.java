package isfibo;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;


public class Solution {

	private static Collection<Long> fibos;

	private static void fillFibos() {
		fibos = new HashSet<Long>();
		long fiboNMinusOne = 1;
		long fiboNMinusTwo = 1;
		fibos.add(1L);
		for (int i = 3; i <= 50; i++) {
			long fiboN = fiboNMinusOne + fiboNMinusTwo;
			fibos.add(fiboN);
			fiboNMinusTwo = fiboNMinusOne;
			fiboNMinusOne = fiboN;
		}
	}

	private static boolean isFibo(long number) {
		return fibos.contains(number);
	}

	public static void main(String[] args) {
		fillFibos();
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			long number = Long.valueOf(line);
			if (isFibo(number)) {
				System.out.println("IsFibo");
			} else {
				System.out.println("IsNotFibo");
			}
		}
		
	}
	
}
