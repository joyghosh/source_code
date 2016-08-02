package algorithms.strings;

/**
 * Print reverse of a string using recursion.
 * 
 * @author Joy Ghosh
 *
 */
public class PrintReverseUsingRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Geeks for Geeks";
		printReverse(str, 0);
	}
	
	/**
	 * Time-complexity: O(n).
	 * Space-complexity: O(n). Recursive call stack space.
	 * 
	 * @param str
	 * @param i
	 */
	public static void printReverse(String str, int i){
		if(i == str.length())
			return;
		printReverse(str, i+1);
		System.out.print(str.charAt(i));
	}
}
