package algorithms.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordsProblem {

	public static void main(String[] args) {
		String strA = "Given a String STRA contain no of words and other string STRB you need to find occurrence of each word from STRA in STRB" + 
				"Complexity must be O(n)";
		String strB = "Break STRA into words and put into trie and then pick one by one word from STRB and compare";
		findOccurrencesOfWords(strA, strB);
	}
	
	private static void findOccurrencesOfWords(String strA, String strB){
		if(strA == null || strB == null) return;
		
		Set<String> lookUp = new HashSet<String>();
		for(String word: strB.split(" ")){
			lookUp.add(word);
		}
		
		Map<String, Integer> occurrences = new HashMap<String, Integer>();
		for(String word: strA.split(" ")){
			if(lookUp.contains(word)){
				if(occurrences.containsKey(word)){
					occurrences.put(word, occurrences.get(word)+1);
				}else{
					occurrences.put(word, 1);
				}
			}
		}
		
		occurrences.forEach((k,v)->System.out.println(k+" occurrs "+v+" times."));
	}
}
