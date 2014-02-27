package expectation;

import java.util.ArrayList;
import java.util.List;

public class Main {

	private static List<int[]> permutations(int[] a) {
	    List<int[]> ret = new ArrayList<int[]>();
	    permutation(a, 0, ret);
	    return ret;
	}

	private static void permutation(int[] arr, int pos, List<int[]> list){
	    if(arr.length - pos == 1)
	        list.add(arr.clone());
	    else
	        for(int i = pos; i < arr.length; i++){
	            swap(arr, pos, i);
	            permutation(arr, pos+1, list);
	            swap(arr, pos, i);
	        }
	}

	private static void swap(int[] arr, int pos1, int pos2){
	    int h = arr[pos1];
	    arr[pos1] = arr[pos2];
	    arr[pos2] = h;
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {1, 2, 3, 4, 5, 6};
		List<int[]> permutations = permutations(array);
		int sum = 0;
		for (int[] option : permutations) {
			for (int i = 1; i < option.length - 1; i++) {
				if ((option[i] > option[i - 1] && option[i] > option[i + 1]) || (option[i] < option[i - 1] && option[i] < option[i + 1])) {
					sum++;
				}
			}
		}
		System.out.println(sum + " of " + permutations.size());
	}
	
}
