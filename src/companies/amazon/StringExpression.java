package companies.amazon;

import java.util.ArrayList;
import java.util.List;



public class StringExpression {
	
	
	private static String expression;
	private static String cexpression = "";
	
	private static List<Character> operators = new ArrayList<Character>();  
	
	public StringExpression(){
		//init();
	}
	
	private static void init(){
		
		operators.add('+');
		operators.add('-');
		operators.add('*');
		operators.add('/');
		operators.add('%');
	}
	
//	//cleanse off white spaces.
//	private static String cleanseExpression(String expression){
//		
//		String cleansed_expression = "";
//		
//		//Trim leading and trailing white spaces.
//		expression = expression.trim();		
//		
//		//Remove spaces in between.
//		for(int i=0; i< expression.length(); i++){
//			 
//			if(expression.charAt(i) == '\b'){
//
//				cleansed_expression.concat(String.valueOf(expression.charAt(i)));
//			}
//		}
//		
//		//return the string.
//		return cleansed_expression;
//	}
	
	//check if valid expression.
	private static int isValid(){
		
		int ret = 1;
		System.out.println("Is Valid");
		
		//Trim leading and trailing white spaces.
		expression = expression.trim();	
		expression = expression.replaceAll(" ", "");
		
		//Check for abnormal conditions.
		//Expressions with leading or trailing operators.
		if(operators.contains(expression.charAt(0)) || 
				operators.contains(expression.charAt(expression.length() - 1))){
			
			ret = -1;
			return ret;
		}
			
		System.out.println("Is Valid middle");
		
		//Remove spaces in between.
		boolean isPrevOperator = false;
		for(int i=0; i < expression.length(); i++){
					
				if(operators.contains(expression.charAt(i)) && isPrevOperator){
					
					System.out.println("Case 1");
					ret = -1;
					break;
				}else if(operators.contains(expression.charAt(i)) && !isPrevOperator){
					
					System.out.println("Case 2");
					cexpression = cexpression.concat(String.valueOf(expression.charAt(i)));
					isPrevOperator = true;
				}else{
					
					System.out.println("Case 3");
					cexpression = cexpression.concat(String.valueOf(expression.charAt(i)));
					isPrevOperator = false;
				}
				
//				System.out.println(i);
		}
		
		System.out.println("Is Valid end.");
		
		System.out.println(cexpression);
		
		//return
		return ret;
	}
	
	private static int getResult(){
		
		System.out.println("Get result.");
		
		//retain the first digit.
		int result = Integer.parseInt(String.valueOf(cexpression.charAt(0)));
		System.out.println(result);
		
		for(int i=1;i < cexpression.length();i+= 2){
			
			switch(cexpression.charAt(i)){
			
				case '+': result = result + Integer.parseInt(String.valueOf(cexpression.charAt(i+1)));
						  break;
				case '-': result = result - Integer.parseInt(String.valueOf(cexpression.charAt(i+1)));
				  		  break;
				case '*': result = result * Integer.parseInt(String.valueOf(cexpression.charAt(i+1)));
				  		  break;
				case '/': result = result / Integer.parseInt(String.valueOf(cexpression.charAt(i+1)));
				  		  break;
				case '%': result = result % Integer.parseInt(String.valueOf(cexpression.charAt(i+1)));
				  		  break;
			}
		}
		
		System.out.println("Get result end.");
		
		return result;
	}
	
	public static void main(String[] args) {

		expression = new String(" 1 +2 *3");
		
		System.out.println("Length: "+expression.length());
		System.out.println("Main.....");
		init();
		System.out.println(operators.contains('+'));
		
		//StringExpression se = new StringExpression();
		if(isValid()==1){
			
			int result = getResult();
			System.out.println(result);
		
		}else{
			
			System.out.println("Invalid expression.");
		}
	}

}
