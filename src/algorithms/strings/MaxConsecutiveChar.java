package algorithms.strings;

public class MaxConsecutiveChar {
	
	public static int count = 0;
	
	public static void main(String[] args) {
		String str = "aaaabbbbbbbaaccde";
		char result = maxConsecutiveChar(str);
		if(result!='\b'){
			System.out.println("Max. repeating character is "+result+" with a count of "+count);
		}else{
			System.out.println("Sorry blank string is not allowed.");
		}
	}
	
	public static char maxConsecutiveChar(String str){
		if(str.length() == 0 || str == null) return '\b';
		int n = str.length();
		
		char result = str.charAt(0);
		count = 1;
		int currCount = 1;
		
		for(int i=0; i<n-1; i++){
			if(str.charAt(i) == str.charAt(i+1)){
				++currCount;
			}else{
				if(currCount>count){
					count = currCount;
					result = str.charAt(i);
				}
				currCount = 1;
			}
		}
		
		return result;
	}
}
