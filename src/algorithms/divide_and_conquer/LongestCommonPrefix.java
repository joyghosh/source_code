package algorithms.divide_and_conquer;

/**
 * Given a set of strings, find the longest common prefix.
 * Input  : {“geeksforgeeks”, “geeks”, “geek”, “geezer”}
 * Output : "gee"
 * Input  : {"apple", "ape", "april"}
 * Output : "ap"
 * 
 * @author Joy Ghosh
 *
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] arr = {"geeksforgeeks", "geeks", "geek", "geezer"};
		System.out.println("Common prefix: "+findTheCommonPrefix(arr, 0, arr.length-1));
	}

	public static String commonPrefix(String str1, String str2){
		StringBuilder result = new StringBuilder();
		for(int i=0, j=0; i<str1.length() && j<str2.length(); i++, j++){
			if(str1.charAt(i) != str2.charAt(j))
				break;
			result.append(str1.charAt(i));
		}
		return result.toString();
	}
	
	/**
	 * Time-complexity: O(N*M)
	 * where N = number of strings.
	 * and M = length of the longest string.
	 * 
	 * Space-complexity:  
	 * 
	 * @param arr
	 * @param low
	 * @param high
	 * @return
	 */
	public static String findTheCommonPrefix(String[] arr, int low, int high){
		
		String result = null;
		if(low == high){
			result = arr[low];
		}else if(low < high){
			int mid = low + (high-low)/2;
			String s1 = findTheCommonPrefix(arr, low, mid);
			String s2 = findTheCommonPrefix(arr, mid+1, high);
			result = commonPrefix(s1, s2);
		}
		return result;
	}
}
