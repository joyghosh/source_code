package companies;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "abcdeab";
		
		Map<String, Integer> counters = new HashMap(); 
		
		duplicate:
		for(int i=0;i<str.length();i++){
			for(int j=2;j< str.length()-i+1;j++){
				if(counters.containsKey(str.substring(i, i+j))){
					
					System.out.println("String contains repeated substrings of length 2 or more.");
					break duplicate;
				}else{
					counters.put(str.substring(i,i+j),1);
				}
				
				System.out.println("Hi");
//				Pattern p = Pattern.compile(str.substring(i,i+j));
//				Matcher m = p.matcher(str);
//				if(counters.containsKey(str.substring(i, i+j))){
//					
//					counters.put(str.substring(i, i+j), counters.get(str.substring(i, i+j))+1);
//					
//				}else{
//					counters.put(str.substring(i,i+j),1);
//				}
			}
		}
		
//		for(Map.Entry<String, Integer> entry: counters.entrySet()){
//			
//			System.out.println(entry.getKey() + ":" + entry.getValue());
//		}
	}

}
