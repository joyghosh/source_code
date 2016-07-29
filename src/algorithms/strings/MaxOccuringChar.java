package algorithms.strings;

public class MaxOccuringChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "test";
		System.out.println(maxOccuringChar(str));
	}
	
	/**
	 * Time-complexity: O(n).
	 * Space-complexity: O(1), since it is finite valued at 256.
	 * 
	 * @param str
	 * @return
	 */
	public static char maxOccuringChar(String str){
		int[] count = new int[256];
		
		//scan along the string.
		for(int i=0;i<str.length();i++){
			count[str.charAt(i)]++; 
		}
		
		//look for max count value.
		int max = Integer.MIN_VALUE;
		char result = 0;
		for(int i=0;i<count.length;i++){
			if(count[i] > max){
				max = count[i];
				result = (char)i;
			}
		}
		
		return result;
	}
}
