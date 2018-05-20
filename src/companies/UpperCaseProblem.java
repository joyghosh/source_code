package companies;

/**
 * Convert words of length 3 to upper case.
 * 
 * @author joyghosh
 *
 */
public class UpperCaseProblem {

	public static void main(String[] args) {
		String sentence = "Wow! Let us try to learn computer programming.";
//		System.out.println(toUpperCase(sentence));
		System.out.println(toUpperCaseCustom(sentence));
	}
	
	public static String toUpperCase(String s){
		int n = s.length();
		if(n == 0 || s == null) return s;
		
		StringBuilder result = new StringBuilder();
		for(String str : s.split(" ")){
			if(str.length() == 3){
				result.append(str.toUpperCase()).append(" ");
			}else{
				result.append(str).append(" ");
			}
		}
		
		return result.toString().trim();
	}
	
	public static String toUpperCaseCustom(String s){
		if(s.length() == 0 || s == null) return s;
		
		StringBuilder result = new StringBuilder();
		int start = 0;
		for(int i=1; i<s.length(); ){
			if(s.charAt(i) == ' ' || s.charAt(i) == '.' 
					|| s.charAt(i) == ',' || s.charAt(i) == '!'){
				System.out.println("("+start+","+i+")");
				String str = s.substring(start, i);
				if(str.length() == 3){
					result.append(str.toUpperCase()).append(" ");
				}else{
					result.append(str).append(" ");
				}
				
				if(s.charAt(i) == ',' || s.charAt(i) == '!'){
					start = i = i + 2;
				}else{
					start = i = i + 1;
				}
			}else{
				i = i + 1;
			}
		}
		
		return result.toString().trim();
	}
}
