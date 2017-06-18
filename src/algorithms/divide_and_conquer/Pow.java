package algorithms.divide_and_conquer;

import java.util.Scanner;

/**
 * Power function using divide and conquer.
 * @author Joy Ghosh
 *
 */
public class Pow {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter x: ");
		int x = sc.nextInt();
		System.out.println("Enter y: ");
		int y = sc.nextInt();
		System.out.println("Power result "+power(x, y));
		sc.close();
	}
	
	//Time complexity O(log y)
	private static long power(int x, int y){
		if(x==1) return x;
		if(y==0) return 1;
		
		long result;
		if(y%2==0){
			result = power(x,y/2);
			return (result*result);
		}
		
		result = power(x, (y-1)/2);
		return x*result*result;
	}
}
