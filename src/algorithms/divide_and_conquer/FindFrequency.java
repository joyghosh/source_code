package algorithms.divide_and_conquer;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an sorted array of positive integers, count number of occurrences for each element in the array. 
 * Assume all elements in the array are less than some constant M.Do this without traversing the complete array. 
 * i.e. expected time complexity is less than O(n)
 * @author Joy Ghosh
 *
 */
public class FindFrequency {

	public static void main(String[] args) {
		int[] arr = {1, 1, 1, 2, 3, 3, 5, 5, 8, 8, 8, 9, 9, 10};
		printFrequency(arr);
	}
	
	public static void printFrequency(int[] arr){
		if(arr.length == 0)
			return;
		Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
		findFrequency(arr, 0, arr.length-1, freq);
		
		for(Map.Entry<Integer, Integer> entry:freq.entrySet()){
			System.out.println("Element "+entry.getKey()+" occurs "+entry.getValue()+" times.");
		}
	}
	
	/**
	 * Time-complexity:  O(m*log n)
	 * Space-complexity: O(m) m is the number of unique elements.
	 * @param arr
	 * @param start
	 * @param end
	 * @param freq
	 */
	public static void findFrequency(int[] arr, int start, int end, Map<Integer, Integer> freq){
		if(arr[start] == arr[end]){
			int count = freq.containsKey(arr[start])? freq.get(arr[start]): 0; 
			freq.put(arr[start], count + (end-start+1));
		}else{
			int mid = (start+end)/2;
			findFrequency(arr, start, mid, freq);
			findFrequency(arr, mid+1, end, freq);
		}
	}
}
