package companies.oracle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindScore {

	public static void main(String[] args) {
		String str = "The college is in Massachusetts";
		findScore(str);
	}

	public static void findScore(String sentence){
		if(sentence == null)
			System.out.println("No max. score possible. No string found.");
		
		int max_so_far = Integer.MIN_VALUE; String max_word = null;
		for(String s: sentence.split(" ")){
			int freq = maxFrequency(s);
			if(freq > max_so_far){
				max_so_far = freq;
				max_word = s;
			}
		}
		
		System.out.printf("%s with score %d", max_word, max_so_far);
	}
	
	public static int maxFrequency(String str){
		
		char[] arr = str.toCharArray();
		Arrays.sort(arr);		//Assume it is of O(n*log n).
		
		Map<Character, Integer> counts = new HashMap<Character, Integer>();
		for(char c:arr){
			if(counts.containsKey(c)){
				int count = counts.get(c);
				counts.put(c, ++count);
			}else{
				counts.put(c, 1);
			}
		}
		
		int max = 0;
		for(int v:counts.values()){
			if(v>1)
				max += v;
		}
		
		return max;
	}
}
