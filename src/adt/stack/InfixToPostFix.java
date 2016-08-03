package adt.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Convert from infix expression to post-fix expression.
 * @author Joy Ghosh
 *
 */
public class InfixToPostFix {

	public static void main(String[] args) {
		String exp = "a+b*(c^d-e)^(f+g*h)-i";
		convertToPostfix(exp);
	}

	public static void convertToPostfix(String infix){
		//for empty expression.
		if(infix == null)
			return;
		
		//Stack in place.
		Deque<Character> stack = new LinkedList<Character>();
		
		//Output expression.
		StringBuilder sb = new StringBuilder();
		
		//Scan through all the characters of an infix expression.
		for(char c:infix.toCharArray()){
			
			if(isOperand(c)){
				sb.append(c);
			}else if(c == '('){
				stack.addLast(c);
			}else if(c == ')'){
				//Pop all until '(' is found.
				while(!stack.isEmpty() && !(stack.peekLast() == '(')){
					sb.append(stack.pollLast());
				}
				
				//try and remove the '(' char.
				if(!stack.isEmpty() && !(stack.peekLast() == '(')){
					return;
				}else{
					stack.pollLast();
				}
			}else{
				while(!stack.isEmpty() && (precedenceValue(c)<=precedenceValue(stack.peekLast()))){
					sb.append(stack.pollLast());
				}
				stack.addLast(c);
			}
		}
		
		//Pop the rest of the operators on the stack.
		while(!stack.isEmpty()){
			sb.append(stack.pollLast());
		}
		
		//print the post-fix expression.
		System.out.println(sb);
	}
	
	//Check if the character is an operand. 
	public static boolean isOperand(char c){
		return ((c>='a' && c<='z') || (c>='A' && c<='Z'));
	}
	
	//returns precedence value of an operator.
	public static int precedenceValue(char c){
		switch(c){
			case '+':
			case '-': return 1;
			case '/':
			case '*': return 2;
			case '^': return 3;
		}
		
		return -1;
	}
}
