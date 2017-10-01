package companies;

import java.util.Scanner;

public class Exponentiation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number (x):");
		int x = sc.nextInt();
		System.out.print("Enter (n): ");
		int n = sc.nextInt();
		System.out.println("Value of x^n: "+power(x, n));
		sc.close();
	}
	
	private static long power(int x, int n){
		if(n==0) return 1;
		if(n==1) return x;
		
		long result;
		if(n%2 == 0){
			result = power(x,n/2);
			return (result*result);
		}
		
		result = power(x, (n-1)/2);
		return x*(result*result);
	}
}
