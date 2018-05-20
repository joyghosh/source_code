package java_code;

public class RandomStuff {

	public static void main(String[] args) {
//		sqrtFloorValue(10.0);
		String s = "110#(2)";
		charParsing(s);
//		String alphabets = "abcdefzklm";
//		displayAlphabetIndex(alphabets);
	}
	
	private static void sqrtFloorValue(double n){
		System.out.println((int) Math.floor(Math.sqrt(n)));
	}
	
	private static void displayAlphabetIndex(String s){
		if(s==null) return;
		for(char c:s.toCharArray()){
			System.out.println(alphabetToIndex(c));
		}
	}
	
	private static void charParsing(String s){
		if(s == null) return;
		int n = s.length();
		int[] freq = new int[27];
		
		for(int i=n-1; i>=0; i--){
			int count = 0;
			int idx = -1;
			if(s.charAt(i) == ')'){
				--i;
				while(s.charAt(i)!='('){
					count = count*10 + (s.charAt(i) - '0');
					--i;
				}
			}else{
				count = 1;
			}
			
			--i;
			
//			System.out.println(count);
			if(s.charAt(i) == '#'){
				--i;
				idx = (s.charAt(i) - '0') + 10*(s.charAt(i-1) - '0');
				i -= 2;
			}else{
				idx = s.charAt(i) - '0'; 
			}
			
			freq[idx] = count;
		}
		
		//Display frequency array.
		for(int f:freq){
			System.out.printf("%d ",f);
		}
	}
	
	private static int alphabetToIndex(char c){
		char filtered = Character.toLowerCase(c);
		if(filtered <'a' && filtered > 'z') return -1;
		return ((int)c - (int)'a' + 1);
	}
	
//	private static 
}
