package sherlockandthebeast;

import java.util.Scanner;

public class Solution {

	private static String inverse(String s) {
		char[] charArray = s.toCharArray();
		int i = 0;
		int j = charArray.length - 1;
		while (i < j) {
			char tmp = charArray[i];
			charArray[i] = charArray[j];
			charArray[j] = tmp;
			i++;
			j--;
		}
		return new String(charArray);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		while (scanner.hasNext()) {
			int n = scanner.nextInt();

			StringBuilder sb = new StringBuilder();

			while (n > 0) {
				if (n % 3 == 0) {
					for (int i = 0; i < n; i++) {
						sb.append("5");
					}
					break;
				} else {
					n -= 5;
					sb.append("33333");
				}
			}

			if (n < 0) {
				System.out.println("-1");
			} else {
				System.out.println(inverse(sb.toString()));
			}
		}
	}

}
