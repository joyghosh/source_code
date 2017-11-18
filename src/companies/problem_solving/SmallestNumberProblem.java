package companies.problem_solving;

import java.util.Stack;

public class SmallestNumberProblem{

	  public static void main(String[] args){
	    int n = 1000;
	    int result = findSmallestNumber(n);
	    if(result!=-1){
	      System.out.println(result);
	    }else{
	      System.out.println("No such number is possible.");
	    }
	  }

	  public static int findSmallestNumber(int n){
	    //check if n is single digit.
	    if(n>=0 && n<=9) return n;

	    Stack<Integer> digits = new Stack<>();
	    for(int i=9; i>1 && n>1; i--){
	      while(n%i==0){
	        digits.push(i);
	        n = n/i;
	      }
	    }

	    if(n!=1){
	      return -1;
	    }

	    int result = 0;
	    while(!digits.isEmpty()){
	      result = result*10 + digits.pop();
	    }

	    return result;
	  }
}

