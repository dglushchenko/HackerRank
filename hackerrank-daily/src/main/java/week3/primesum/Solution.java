package week3.primesum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	private static LinkedHashSet<Long> generatePrimes(long n) {
		LinkedHashSet<Long> primes = new LinkedHashSet<Long>();

		for (long number = 2; number < n; number++) {
			boolean isPrime = true;
			for (long prime : primes) {
				if (number % prime == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primes.add(number);
			}
		}
		
		return primes;
	}
	
	public static Map<Long, Set<Long>> generateDp(long n) {
		Map<Long, Set<Long>> dp = new HashMap<Long, Set<Long>>();

		long start = System.currentTimeMillis();
		LinkedHashSet<Long> primes = generatePrimes(n);
		System.out.println("primes: " + (System.currentTimeMillis() - start));

		start = System.currentTimeMillis();
		for (long number = 2; number <= n; number++) {
			Set<Long> numberList = new HashSet<Long>();
			for (long prime : primes) {
				long diff = number - prime;
				if (diff > 0) {
					Set<Long> steps = dp.get(diff);
					if (steps != null) {
						for (long step : steps) {
							numberList.add(step + 1);
						}
					}
				} else if (diff == 0) {
					numberList.add(1L);
				} else {
					break;
				}
			}
			dp.put(number, numberList);
		}
		System.out.println("dp: " + (System.currentTimeMillis() - start));
		return dp;
	}
	
	public static boolean solve(long n, long k, Map<Long, Set<Long>> dp) {
		if (n < 2) {
			return false;
		}
		Set<Long> steps = dp.get(n);
		if (steps != null && steps.contains(k)) {
			return true;
		}
		
		return false;
	}
	
	/*public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		long[][] input = new long[t][2];
		long maxN = Long.MIN_VALUE;
		for (int i = 0; i < t; i++) {
			input[i][0] = in.nextLong();
			input[i][1] = in.nextLong();
			maxN = Math.max(maxN, input[i][0]);
		}
		Map<Long, Set<Long>> dp = generateDp(maxN);
		for (int i = 0; i < t; i++) {
			System.out.println(solve(input[i][0], input[i][1], dp) ? "Yes" : "No");
		}
	}*/

	private static boolean isSumOfTwoPrimes(long n) {
		return n % 2 == 0 || isPrime(n - 2);
	}

	public static boolean isPrime(long n) {
		if (n == 1) {
			return false;
		}
		if (n == 2) {
			return true;
		}
		if (n % 2 == 0) {
			return false;
		}
		for (long i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static boolean solve(long n, long k) {
		if (k > n / 2) {
			return false;
		}
		
		if (k == 1 && !isPrime(n)) {
			return false;
		}
		
		if (k == 2 && !isSumOfTwoPrimes(n)) {
			return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t -- > 0) {
			long n = in.nextLong();
			long k = in.nextLong();
			System.out.println(solve(n, k) ? "Yes" : "No");
		}
	}
}
