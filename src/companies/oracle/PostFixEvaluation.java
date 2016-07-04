package companies.oracle;

import java.util.Deque;
import java.util.LinkedList;

public class PostFixEvaluation {

	
	public static void main(String[] args) {
	
			String exp = "234+*6-";
			System.out.println("result is: "+computePostFix(exp));
	}

	/**
	 * Time-complexity O(n).
	 * Auxiliary space complexity O(n).
	 * @param expression
	 * @return
	 */
	private static int computePostFix(String expression){
        
        Deque<Integer> stack = new LinkedList<Integer>();
        
        for(char c:expression.toCharArray()){
                if(Character.isDigit(c)){
                    stack.push(Character.getNumericValue(c));
                }else{
                    
                   if(stack.size()>=2){
                        int b = stack.pop();
                        int a = stack.pop();
                        
                        int result = compute(a, b, c);
                        stack.push(result);
                    }else{
                        System.err.println("Invalid expression.");
                    }
                }
        }
        
        return (int)stack.pop();
    }
    
    private static int compute(int a, int b, char operator){
        
        int result = 0;
        
        switch(operator){
            case '+':  result = a + b;
                       break;
            case '-':  result = a - b;
                       break;     
            case '*':  result = a * b;
                       break;
            case '/':  result = a/b;
                       break;
            default:  result = Integer.MIN_VALUE;
        }
        
        return result;
    }
}
