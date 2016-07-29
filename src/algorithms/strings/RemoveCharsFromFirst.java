package algorithms.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Remove characters from the first string which are present in the second string.
 * 
 * @author Joy Ghosh
 *
 */
public class RemoveCharsFromFirst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String first = "geeksforgeeks";
		String second = "mask";
		System.out.println(removeCharsInFirst(first, second));
	}

	/**
	 * Time-complexity: O(m+n), m is length of mask string and n is length of string.
	 * Space-complexity: O(m)
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	public static String removeCharsInFirst(String first, String second){
		Set<Character> set = new HashSet<Character>();
		StringBuilder sb = new StringBuilder();
		
		//Form the set from chars of second string.
		for(char c:second.toCharArray()){
			set.add(c);
		}
		
		//remove chars present in second string from first string.
		for(int i=0;i<first.length(); i++){
			if(!set.contains(first.charAt(i))){
				sb.append(first.charAt(i));
			}
		}
		
		return sb.toString();
	}
}
