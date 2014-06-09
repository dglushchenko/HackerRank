package week4.twotwo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution2 {

	public static final int MAX_POWER = 800;
	public static final int THRESHOLD = 20;

	public static String[] generatePowersOfTwo(int maxPower) {
		String[] powersOfTwo = new String[maxPower + 1];
		BigInteger powerOfTwo = BigInteger.ONE;
		for (int i = 0; i < powersOfTwo.length; i++) {
			powersOfTwo[i] = powerOfTwo.toString();
			powerOfTwo = powerOfTwo.multiply(BigInteger.valueOf(2L));
		}
		return powersOfTwo;
	}
	
	public static int solveForBig(String string, String[] powersOfTwo, int[] powersOfTwoIndexes, int bunchLength) {
		int count = 0;
		Map<Integer, List<Integer>> stringIndex = indexString(string, bunchLength);
		for (int i = 0; i < powersOfTwoIndexes.length; i++) {
			List<Integer> list = stringIndex.get(powersOfTwoIndexes[i]);
			if (list != null) {
				System.out.println("power: " + i + ", size: " + list.size());
				for (int index : list) {
					if (string.indexOf(powersOfTwo[i], index) == index) { 
						count++;
					}
				}
			}
		}
		return count;
	}

	public static Map<Integer, List<Integer>> indexString(String string, int bunchLength) {
		int stringIndexLength = string.length() - bunchLength + 1;
		Map<Integer, List<Integer>> index = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < stringIndexLength; i++) {
			int hashcode = string.substring(i, i + bunchLength).hashCode();
			List<Integer> list = index.get(hashcode);
			if (list == null) {
				list = new ArrayList<Integer>();
			}
			list.add(i);
			index.put(hashcode, list);
		}
		return index;
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

	public static int[] generatePowersOfTwoIndexes(String[] powersOfTwo, int bunchLength) {
		int[] powersOfTwoIndex = new int[powersOfTwo.length];
		for (int i = 0; i < powersOfTwo.length; i++) {
			int substringLength = Math.min(bunchLength, powersOfTwo[i].length());
			powersOfTwoIndex[i] = powersOfTwo[i].substring(0, substringLength).hashCode();
		}
		return powersOfTwoIndex;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		String[] strings = new String[t];
		for (int i = 0; i < t; i++) {
			strings[i] = in.next();
		}
		String[] powersOfTwo = generatePowersOfTwo(MAX_POWER);
		int[] powersOfTwoIndex = generatePowersOfTwoIndexes(powersOfTwo, THRESHOLD);
		for (int i = 0; i < strings.length; i++) {
			int count = 0;
			count = solveForSmall(strings[i], powersOfTwo, THRESHOLD);
			if (strings[i].length() >= THRESHOLD) {
				count += solveForBig(strings[i], powersOfTwo, powersOfTwoIndex, THRESHOLD);
			}
			System.out.println(count);
		}
	}

}
