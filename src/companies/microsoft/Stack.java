package companies.microsoft;

import java.util.ArrayList;
import java.util.List;

public class Stack {
	
	private List<Integer> stack; 
	
	public Stack(){
		this.stack = new ArrayList<Integer>();
	}
	
	public void push(int data){
		this.stack.add(new Integer(data));
	}
	
	public int pop(){
		
		return (int)this.stack.remove(this.stack.size() - 1);
	}
}
