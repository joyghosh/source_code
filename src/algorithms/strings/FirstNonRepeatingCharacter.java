package algorithms.strings;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "GeeksQuiz";
		FirstNonRepeatingCharacter fnrc = new FirstNonRepeatingCharacter();
		System.out.println(fnrc.firstNonRepeatingChar(str));
		System.out.println(fnrc.firstNonRepeaterOptimized(str));
	}
	
	/**
	 * Traverses the input string twice.
	 * 
	 * Time-complexity: O(n)
	 * Space-complexity:  O(m), where m is the number of unique characters.
	 * @param s
	 * @return
	 */
	public char firstNonRepeatingChar(String s){
		Map<Character, Integer> counts = new HashMap<Character, Integer>();
		
		//Scan the entire string and populate the count of chars,
		for(int i=0;i<s.length();i++){
			if(counts.containsKey(s.charAt(i))){
				int val = counts.get(s.charAt(i));
				counts.put(s.charAt(i), ++val);
			}else{
				counts.put(s.charAt(i), 1);
			}
		}
		
		//Scan for the first non-repeating character.
		char result = 0;
		for(int i=0; i<s.length(); i++){
			if(counts.get(s.charAt(i)) == 1){
				result = s.charAt(i);
				break;
			}
		}
		
		return result;
	}
	
	/**
	 * String traversing is just for once.
	 * 
	 * Time-complexity: O(n)
	 * Space-complexity: O(m), where m is the number of unique characters.
	 * 
	 * @param str
	 * @return
	 */
	public char firstNonRepeaterOptimized(String str){
		Map<Character, Info> counts = new HashMap<Character, Info>();
		
		//Scan the entire string and populate the count of chars,
		for(int i=0;i<str.length();i++){
			if(counts.containsKey(str.charAt(i))){
				Info val = counts.get(str.charAt(i));
				val.count++;
				//counts.put(str.charAt(i), val);
			}else{
				counts.put(str.charAt(i), new Info(i));
			}
		}
		
		//Scan just the count map.
		char result = 0; int min_index = Integer.MAX_VALUE;
		for(Map.Entry<Character, Info> ob:counts.entrySet()){
			char c = ob.getKey();
			Info info = ob.getValue();
			if(info.count == 1 && info.index < min_index){
				result = c;
				min_index = info.index;
			}
		}
		
		return result;
	}
	
	class Info{
		int count;
		int index;
		
		public Info(int index){
			this.index = index;
			this.count = 1;
		}
	}
}
