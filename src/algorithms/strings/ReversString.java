package algorithms.strings;

/**
 * Reverse a string.
 * 
 * @author joyghosh
 *
 */
public class ReversString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Disneyland";
		printReverse(str, 0);
	}
	
	//Print the string in reverse using recursion.
	//Time complexity: O(n).
	//Space complexity: O(n).
	private static void printReverse(String str, int index){
		//Base cases. 
		//Empty or null string.
		//Reached the end of the string.
		if( str.isEmpty() || str == null || index == str.length()) return;
		
		if(index < str.length()){
			printReverse(str, index+1);
		}
		
		System.out.print(str.charAt(index));
	}
	
	//Reverse a string using loop.
//	private static String reverseUsingLoop(String str){
//		
//	}
}
