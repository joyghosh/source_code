package algorithms.strings;

public class PrintAllDuplicates {

	public static void main(String[] args) {
		String str = "test string";
		printDuplicates(str);
	}
	
	/**
	 * Time-complexity: O(n).
	 * Space-complexity: O(1), since we have fixed sized character set, here it is 256.
	 * 
	 * @param str
	 */
	public static void printDuplicates(String str){
		int[] count_array = new int[256];
		
		for(int i=0;i<str.length();i++){
			++count_array[str.charAt(i)];
		}
		
		//print those indices which have values > 1.
		for(int i=0; i<count_array.length; i++){
			if(count_array[i] > 1){
				System.out.printf("%c, %d \n",(char)i, count_array[i]);
			}
		}
	}
}
