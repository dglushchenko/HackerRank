package anagrams;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {

	private static String aString;
	private static String bString;
	
	private static void parseInput(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));

			aString = br.readLine();
			bString = br.readLine();

		} catch (IOException io) {
			io.printStackTrace();
		}
	}

    public static void main(String[] args) {
    	
    	parseInput(args);
    	/*String aString = "cde";
    	String bString = "abc";*/
    	
        Map<String, Integer> aMap = new HashMap<String, Integer>();
        Map<String, Integer> bMap = new HashMap<String, Integer>();
        
        for (char c : aString.toCharArray()) {
        	String key = String.valueOf(c);
        	Integer value = aMap.get(key);
        	if (value == null) {
        		value = 1;
        	} else {
        		value++;
        	}
        	aMap.put(key, value);
        }
        
        for (char c : bString.toCharArray()) {
        	String key = String.valueOf(c);
        	Integer value = bMap.get(key);
        	if (value == null) {
        		value = 1;
        	} else {
        		value++;
        	}
        	bMap.put(key, value);
        }
        
        for (String key : aMap.keySet()) {
        	Integer bValue = bMap.get(key);
        	if (bValue != null) {
        		Integer aValue = aMap.get(key);
        		int min = Math.min(aValue, bValue);
        		aValue -= min;
        		bValue -= min;
        		aMap.put(key, aValue);
        		bMap.put(key, bValue);
        	}
        }
        
        int count = 0;
        for (int value : aMap.values()) {
        	count += value;
        }
        for (int value : bMap.values()) {
        	count += value;
        }
        
        System.out.println(count);
    }
}