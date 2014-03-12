package angrychildren;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[] input = new int[n];
		int i = 0;
		while (scanner.hasNext()) {
			input[i++] = scanner.nextInt();
		}
		
		Arrays.sort(input);
	
		int minUnfairness = Integer.MAX_VALUE; 
		
		for (int j = 0; j < n - k; j++) {
			int unfairness = input[j + k - 1] - input[j];
			if (unfairness < minUnfairness) {
				minUnfairness = unfairness;
			}
		}
		
		System.out.println(minUnfairness);
	}
	
}
