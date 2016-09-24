package algorithms.strings;

/**
 * Print all possible strings that can be made by placing spaces
 * 
 * @author Joy Ghosh
 *
 */
public class StringsWithSpaces {

	public static void main(String[] args) {
		String str = "ABCD";
		char[] buffer = new char[2*str.length() - 1];
		buffer[0] = str.charAt(0);
		printPattern(str.toCharArray(), 1, buffer, 1, str.length());
	}
	
	/**
	 * T.C. = O(2^n)
	 * S.C. = O(2^n) 
	 * 
	 * @param str
	 * @param i
	 * @param buffer
	 * @param j
	 * @param n
	 */
	public static void printPattern(char[] str, int i, char[] buffer,int j, int n){
		
		//If all characters in the string is covered, then just print the buffer string.
		if(i==n){
			System.out.println(buffer);
			return;
		}
		
		//Either put the next character in the index j and recurse.
		buffer[j] = str[i];
		printPattern(str, i+1, buffer, j+1, n);
		
		//or else put a space at ith position and next character at the i+1th position and recurse.
		buffer[j] = ' ';
		buffer[j+1] = str[i];
		printPattern(str, i+1, buffer, j+2, n);
	}
}
