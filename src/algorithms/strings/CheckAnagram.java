package algorithms.strings;

import java.util.Arrays;

/**
 * Check whether two strings are anagram of each other
 * 
 * @author Joy Ghosh
 *
 */
public class CheckAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "geeksforgeeks";
		String s2 = "forgeeksgeek";
		if(areAnagramsUsingCount(s1, s2)){
			System.out.println("Anagrams.");
		}else{
			System.out.println("Not anagrams.");
		}
	}
	
	/**
	 * Time-complexity: O(n^2) or O(n*log n).
	 * Space-complexity: O(n) 
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean isAnagramUseSorting(String s1, String s2){
		if(s1.length() != s2.length())
			return false;
		
		char[] arr1 = s1.toCharArray(); char[] arr2 = s2.toCharArray();
		
		//O(n^2) or O(n*log n)
		Arrays.sort(arr1); Arrays.sort(arr2);
		
		for(int i=0;i<arr1.length;i++){
			if(arr1[i] != arr2[i])
				return false;
		}
		
		return true;
	}
	
	//O(n)
	public static boolean areAnagramsUsingCount(String s1, String s2){
		if(s1.length() != s2.length())
			return false;
		
		int[] count1 = new int[256]; int[] count2 = new int[256];
		
		for(int i=0; i<s1.length(); i++){
			++count1[s1.charAt(i)];
			++count2[s2.charAt(i)];
		}
		
		for(int i=0; i<count1.length; i++){
			if(count1[i] != count2[i])
				return false;
		}
		
		return true;
	}
}
