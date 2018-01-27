package algorithms.maths;

public class Palindrome {

	public static void main(String[] args) {
		System.out.println("Number is palindrome: "+isPalindrome(1011));
	}
	
	public static boolean isPalindrome(int n){
		int div = 1;
		
		while(n/div>=10){
			div *= 10;
		}
		
		while(n>0){
			int leading = n/div;
			int trailing = n%10;
			
			if(leading!=trailing) return false;
			
			n = (n%div)/10;
			div = div/100;
		}
		
		return true;
	}
}
