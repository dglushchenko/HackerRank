package week4.twotwo;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	//public static final int MAX_POWER = 800;
	public static final int MAX_POWER = 20000;
	
	// 3: min: 1004, max: 1203, avg: 1020
	// 4: min: 717, max: 902, avg: 725
	// 5: min: 737, max: 930, avg: 746
	//public static final int THRESHOLD = 4;
	public static final int THRESHOLD = 7;

	private static int hashcode(String s, int from, int to) {
		int hashcode = 0;
		for (int i = from; i < to; i++) {
			hashcode = 31 * hashcode + s.charAt(i);
		}
		return hashcode;
	}
	
	public static String[] generatePowersOfTwo(int maxPower) {
		String[] powersOfTwo = new String[maxPower + 1];
		BigInteger powerOfTwo = BigInteger.ONE;
		for (int i = 0; i < powersOfTwo.length; i++) {
			powersOfTwo[i] = powerOfTwo.toString();
			powerOfTwo = powerOfTwo.shiftLeft(1);
		}
		return powersOfTwo;
	}

	public static int solveForBig(String string, Map<Integer, Set<String>> powersOfTwoIndex, int bunchLength) {
		int count = 0;
		int stringIndexLength = string.length() - bunchLength + 1;
		for (int i = 0; i < stringIndexLength; i++) {
			/*String substring = string.substring(i, i + bunchLength);
			int hashcode = substring.hashCode();*/
			int hashcode = hashcode(string, i, i + bunchLength);
			Set<String> set = powersOfTwoIndex.get(hashcode);
			if (set != null) {
				for (String powerOfTwo : set) {
					//if (string.indexOf(powerOfTwo, i) == i) { // 9.568
					//if (string.substring(i, string.length()).startsWith(powerOfTwo)) { // 3.031
					if (string.startsWith(powerOfTwo, i)) { // 0.645
						count++;
					}
				}
			}
		}
		return count;
	}
	
	public static int solveForSmall(String string, String[] powersOfTwo, int bunchLength) {
		int count = 0;
		for (int j = 0; j < powersOfTwo.length; j++) {
			if (powersOfTwo[j].length() > Math.min(string.length(), bunchLength - 1)) {
				break;
			}
			int fromIndex = 0;
			while (true) {
				int indexOf = string.indexOf(powersOfTwo[j], fromIndex);
				if (indexOf == -1) {
					break;
				}
				count++;
				fromIndex = indexOf + 1;
			}
		}
		return count;
	}

	public static Map<Integer, Set<String>> generatePowersOfTwoIndexes(String[] powersOfTwo, int bunchLength) {
		Map<Integer, Set<String>> index = new HashMap<Integer, Set<String>>();
		for (int i = 0; i < powersOfTwo.length; i++) {
			int substringLength = Math.min(bunchLength, powersOfTwo[i].length());
			//int hashCode = powersOfTwo[i].substring(0, substringLength).hashCode();
			int hashCode = hashcode(powersOfTwo[i], 0, substringLength);
			Set<String> set = index.get(hashCode);
			if (set == null) {
				set = new HashSet<String>();
			}
			set.add(powersOfTwo[i]);
			index.put(hashCode, set);
		}
		return index;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		String[] strings = new String[t];
		for (int i = 0; i < t; i++) {
			strings[i] = in.next();
		}
		String[] powersOfTwo = generatePowersOfTwo(MAX_POWER);
		Map<Integer, Set<String>> powersOfTwoIndex = generatePowersOfTwoIndexes(powersOfTwo, THRESHOLD);
		for (int i = 0; i < strings.length; i++) {
			int count = 0;
			count = solveForSmall(strings[i], powersOfTwo, THRESHOLD);
			if (strings[i].length() >= THRESHOLD) {
				count += solveForBig(strings[i], powersOfTwoIndex, THRESHOLD);
			}
			System.out.println(count);
		}
	}

}
