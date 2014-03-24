package manasalovesmaths;

import java.util.Scanner;

public class Solution {

	private static String prepare(String number) {
		if (number.length() < 2) {
			number = "00" + number;
		} else if (number.length() < 3) {
			number = "0" + number;
		}
		return number;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while (t-- > 0) {
			String number = scanner.next();
			boolean found = false;
			if (number.length() > 2) {
				for (int i = 0; i < number.length(); i++) {
					for (int j = 0; j < number.length(); j++) {
						if (i == j) {
							continue;
						}
						for (int k = 0; k < number.length(); k++) {
							if (k == i || k == j) {
								continue;
							}
							String permutation = prepare(String.valueOf(number
									.charAt(i))
									+ String.valueOf(number.charAt(j))
									+ String.valueOf(number.charAt(k)));
							for (int l = 0; l < 1000; l++) {
								if (l % 8 == 0) {
									String check = prepare(String.valueOf(l));
									if (permutation.equals(check)) {
										found = true;
										break;
									}
								}
							}
							if (found) {
								break;
							}
						}
						if (found) {
							break;
						}
					}
					if (found) {
						break;
					}
				}
			} else if (number.length() > 1) {
				for (int j = 0; j < number.length(); j++) {
					for (int k = 0; k < number.length(); k++) {
						if (j == k) {
							continue;
						}
						String permutation = prepare(String.valueOf(number.charAt(j))
								+ String.valueOf(number.charAt(k)));
						for (int l = 0; l < 100; l++) {
							if (l % 8 == 0) {
								String check = prepare(String.valueOf(l));
								if (permutation.equals(check)) {
									found = true;
									break;
								}
							}
						}
						if (found) {
							break;
						}
					}
					if (found) {
						break;
					}
				}
			} else if ("8".equals(number)) {
				found = true;
			}
			System.out.println(found ? "YES" : "NO");
		}
	}

}
