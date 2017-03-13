package companies.morgan_stanley;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		System.out.println("recursive factorial :"+factorialRecur(n));
		System.out.println("iterative factorial :"+factorialIter(n));
	}
	
	//O(n)
	//Space O(n) Function call stack.
	private static int factorialRecur(int n){
		if(n==0 || n==1) return 1;
		
		return n*factorialRecur(n-1);
	}
	
	//O(n)
	//Space O(1) Constant space.
	private static int factorialIter(int n){
		if(n==0 || n==1) return 1;
	
		int fact = n;
		for(int i=n-1; i>=1; i--){
			fact *= i;
		}
		
		return fact;
	}
}
