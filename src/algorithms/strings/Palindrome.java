package algorithms.strings;

/**
 * Given a string, check if it is a palindrome by ignoring spaces. E.g. race car would be a palindrome.
 * 
 * @author joyghosh
 *
 */
public class Palindrome {
	
	 public static void main(String args[]) {
	       String str = "race car";
	       if(isPalindrome(str)){
	           System.out.printf("%s is a palindrome. \n", str);
	       }else{
	           System.out.printf("%s is not a palindrome. \n", str);
	       }
	    }
	    
	     
	    private static boolean isPalindrome(String str){
	        
	        if(str == null || str.length() == 1) return true;
	        
	        char[] strArr = str.toCharArray();
	        int i = 0;
	        int j = strArr.length-1;
	        
	        while(i<j){
	            if(strArr[i] == strArr[j] && strArr[i] != ' '){
	                i++; j--;
	            }else if(strArr[i] == ' '){
	                i++;
	            }else if(strArr[j] == ' '){
	                j--;
	            }else{
	                return false;
	            }
	        }
	        
	        return true;
	    }
}
