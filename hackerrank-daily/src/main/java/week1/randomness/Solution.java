package week1.randomness;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	private static final String[] letters = new String[] {
		"a", "b", "c", "d", "e", "f", "g", "h",
		"i", "j", "k", "l", "m", "n", "o", "p",
		"q", "r", "s", "t", "u", "v", "w", "x",
		"y", "z", ""};
	
	public static void radixSort(String[] array, int maxLength) {
		for (int i = 0; i < maxLength; i++) {
			int[] counts = new int[letters.length];
			for (String s : array) {
				
			}
		}
	}
	
	public static void lsd(String[] a, int maxLength) {
		int R = 27 + 1;
		int N = a.length;
		int W = maxLength;
		String[] temp = new String[N];
		for (int d = W - 1; d >= 0; d--) {
			int[] count = new int[R];
			for (int i = 0; i < N; i++) {
				int index = (d < a[i].length() ? a[i].charAt(d) - 97 : 26) + 1; 
				count[index]++;
			}
			for (int k = 1; k < R; k++)
				count[k] += count[k - 1];
			for (int i = 0; i < N; i++) {
				int index = (d < a[i].length() ? a[i].charAt(d) - 97 : 26); 
				temp[count[index]++] = a[i];
			}
			for (int i = 0; i < N; i++)
				a[i] = temp[i];
		}
	}

	public static int countSubstringsBasic(String s) {
		String[] suffixes = new String[s.length()];
		for (int i = 0; i < s.length(); i++) {
			suffixes[i] = s.substring(i);
		}

		Arrays.sort(suffixes);

		int count = suffixes[0].length();
		for (int i = 0; i < s.length() - 1; i++) {
			String suffix = suffixes[i];
			String nextSuffix = suffixes[i + 1];
			int minSuffixLength = suffix.length() < nextSuffix.length() ? suffix.length() : nextSuffix.length();
			int subcount = 0;
			for (int j = 0; j < minSuffixLength; j++) {
				if (suffix.charAt(j) == nextSuffix.charAt(j)) {
					subcount++;
				} else {
					break;
				}
			}
			count += nextSuffix.length() - subcount;
		}

		return count;
	}

	public static int countSubstrings(String s) {
		System.out.println("----------------------------");
		long start = System.currentTimeMillis();
		String[] suffixes = new String[s.length()];
		System.out.println("1: " + (System.currentTimeMillis() - start));
		for (int i = 0; i < s.length(); i++) {
			suffixes[i] = s.substring(i);
		}
		System.out.println("2: " + (System.currentTimeMillis() - start));

		//Arrays.sort(suffixes);
		//radixSort(suffixes, s.length());
		lsd(suffixes, s.length());
		
		System.out.println("3: " + (System.currentTimeMillis() - start));

		int count = suffixes[0].length();
		for (int i = 0; i < s.length() - 1; i++) {
			String suffix = suffixes[i];
			String nextSuffix = suffixes[i + 1];
			int minSuffixLength = suffix.length() < nextSuffix.length() ? suffix.length() : nextSuffix.length();
			int subcount = 0;
			for (int j = 0; j < minSuffixLength; j++) {
				if (suffix.charAt(j) == nextSuffix.charAt(j)) {
					subcount++;
				} else {
					break;
				}
			}
			count += nextSuffix.length() - subcount;
		}
		System.out.println("4: " + (System.currentTimeMillis() - start));

		return count;
	}

	private static String replaceChar(String s, String c, int index) {
		return s.substring(0, index) + c + (index < s.length() ? s.substring(index + 1) : "");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int q = in.nextInt();
		String s = in.next();
		while (q-- > 0) {
			int p = in.nextInt();
			String c = in.next();

			s = replaceChar(s, c, p - 1);
			System.out.println(countSubstringsBasic(s));
		}
	}

}
