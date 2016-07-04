package companies.bloomberg;

/**
 * Prints the missing words from the original array along with their indices.
 * @author Joy
 *
 */
public class MissingWords {

	public static void main(String[] args) {
		String sentence1 = "Hackerrank is a great programming and a learning tool.";
		String sentence2 = "Hackerrank great and learning tool for what not and fun.";
		
		printMissingWords(sentence1, sentence2);
	}
	
	/**
	 * Time-complexity = O(n).
	 * Auxiliary space complexity = O(1).
	 * @param s1
	 * @param s2
	 */
	private static void printMissingWords(String s1, String s2){
		
		String[] arr1 = s1.replace(".", "").split(" ");
		String[] arr2 = s2.replace(".", "").split(" ");
		
		int i, j; i = j = 0;
		
		while(i<arr1.length && j<arr2.length){
			if(arr1[i].equals(arr2[j])){
				++i; ++j;
			}else{
				System.out.println(arr1[i]+":"+(i+1));
				++i;
			}
		}
	}
}
