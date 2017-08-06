package algorithms.bit_algorithms;

import java.util.Scanner;

/**
 * Count set bits in an integer.
 * @author joyghosh
 *
 */
public class CountSetBits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number (n): ");
		int n = sc.nextInt();
		System.out.printf("Count of set bits in %d is %d\n", n, countBits(n));
		System.out.printf("Count of set bits in %d is %d\n", n, countBitsBK(n));
		sc.close();
	}
	
	//Simple solution.
	//Time-complexity of O(log n)
	//Space complexity of O(1).
	public static int countBits(int n){
		//Base case.
		if(n==0) return 0;
		
		int count = 0;
		while(n>0){
			count += (n&1);
			n = (n >> 1);
		}
		
		return count;
	}
	
	//Brian Kernighan method.
	//Time-complexity O(logn)
	public static int countBitsBK(int n){
		//Base case.
		if(n==0) return 0;
		
		int count = 0;
		while(n>0){
			n = (n & (n-1));
			++count;
		}
		return count;
	}
}
