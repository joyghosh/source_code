package companies.microsoft;

import java.util.HashMap;
import java.util.Map;

public class DigitSequenceDecodings {

	private static Map<String,String> decode = new HashMap<String, String>();
	
	
	public static void main(String[] args) {
		
		init();		//initialize the mappings.
		
	}

	//find all possible decodings for digit sequence str.
	private static void findAllPossibleDecodings(String str){
		
		if(str.length() == 0)
			return;
		
		if(str.length()>1){
			
			if(decode.containsKey(str.substring(0, 2)))
				System.out.print(decode.get(str.substring(0,2)));
			else{
				System.out.print(decode.get(str.charAt(0)));
				findAllPossibleDecodings(str.substring(1));
			}
		}else{
			
			System.out.print(decode.get(str));
		}
	}
	
	//initialize.
	private static void init(){
		decode.put("1", "A"); decode.put("2", "B"); decode.put("3", "C"); decode.put("4", "D");
		decode.put("5", "E"); decode.put("6", "F"); decode.put("7", "G"); decode.put("8", "H");
		decode.put("9", "I"); decode.put("10", "J"); decode.put("11", "K"); decode.put("12", "L");
		decode.put("13", "M"); decode.put("14", "N"); decode.put("15", "O"); decode.put("16", "P");
		decode.put("17", "Q"); decode.put("18", "R"); decode.put("19", "S"); decode.put("20", "T");
		decode.put("21", "U"); decode.put("22", "V"); decode.put("23", "W"); decode.put("24", "X");
		decode.put("25", "Y"); decode.put("26", "Z");
	}
}
