package algorithms.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Without duplicates: "+removeDuplicates("geeksforgeeks"));
		System.out.println("Without duplicates: "+removeDuplicatesInOrder("geeksforgeeks"));
	}
	
	/**
	 * METHOD 1 (Use Sorting)
	 * 
	 * Time-complexity: O(n*log n)
	 * Space-complexity: O(n)
	 * @param str
	 * @return
	 */
	public static String removeDuplicates(String str){
		char[] arr = str.toCharArray();
		Arrays.sort(arr);	//O(n*log n)
		StringBuilder sb = new StringBuilder();
		sb.append(arr[0]);
		
		for(int i=1; i<arr.length; i++){
			if(arr[i] != arr[i-1]){
				sb.append(arr[i]);
			}
		}
		
		return sb.toString();
	}
	
	/**
	 * METHOD 2 (Use Hashing ). Maintains order of characters.
	 * Time-complexity:  O(n)
	 * Space-complexity: O(m), m being the number of unique characters.
	 * 
	 * @param str
	 * @return
	 */
	public static String removeDuplicatesInOrder(String str){
		StringBuilder sb = new StringBuilder();
		Set<Character> status = new HashSet<Character>();

		for(int i=0;i<str.length();i++){
			if(!status.contains(str.charAt(i))){
				status.add(str.charAt(i));
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}
}
