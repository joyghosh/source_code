package algorithms.strings;

/**
 * Given two very large strings, consisting of only digits, multiply the two strings and return the result as a string.
 * 
 * @author joyghosh
 *
 */
public class MultiplyStrings {

	public static void main(String[] args) {
		
	}
	
	private static String multiply(String num1, String num2){
		
		//Base or edge cases.
		if(num1 == null || num2 == null) return null;
		if(num1.equals("0") || num2.equals("0")) return "0";
		if(num1.equals("1")) return num2;
		if(num2.equals("1")) return num1;
		
		int carry = 0;
		int sum = 0;
		int n1 = num1.length(); int n2 = num2.length();
		
//		if(n1<)
//		for()
//		
		return null;
	}
}
