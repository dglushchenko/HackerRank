package sherlock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	private static int length;
	private static int shift;
	private static int numberOfQueries;
	private static int[] array;
	private static int[] queries;

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));

			String input = br.readLine();

			String[] mainValues = input.split(" ");
			length = Integer.valueOf(mainValues[0]);
			shift = Integer.valueOf(mainValues[1]);
			numberOfQueries = Integer.valueOf(mainValues[2]);
			array = new int[length];
			queries = new int[numberOfQueries];

			input = br.readLine();

			if (length > 0) {
				String[] arrayValues = input.split(" ");
				int i = 0;
				for (String arrayValue : arrayValues) {
					array[i++] = Integer.valueOf(arrayValue);
				}
			}

			if (numberOfQueries > 0) {
				int i = 0;
				while ((input = br.readLine()) != null) {
					queries[i++] = Integer.valueOf(input);
				}
			}

		} catch (IOException io) {
			io.printStackTrace();
		}
		
		for (int query : queries) {
			int index = query - shift;
			while (index < 0) {
				index += length;
			}
			System.out.println(array[index % length]);
		}
	}
}