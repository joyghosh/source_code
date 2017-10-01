package companies;

/**
 * Check if the given string is a candidate for a palindrome or not.
 * 
 * @author joyghosh
 *
 */
public class PalindromeCandidate {

	public static void main(String[] args) {
//		String str = "geeksoskeeg";
		String str = "geeksforgeeks";
		if(isPalindromeCandidate(str)){
			System.out.println(str+" is a palindrome candidate.");
		}else{
			System.out.println(str+" is not a palindrome candidate.");
		}
	}
	
	//O(n).
	private static boolean isPalindromeCandidate(String str){
		if(str.length() == 0 || str.length() == 1)
			return true;
			
		int[] alphabet = new int[256];
		for(int i=0; i<str.length(); i++){
			++alphabet[(int)str.charAt(i)];
		}
		
		int count = 0;
		for(int i=0; i<alphabet.length; i++){
			if(alphabet[i]%2>0){
				++count;
				if(count>1){
					return false;
				}
			}
		}
		
		return true;
	}
}
