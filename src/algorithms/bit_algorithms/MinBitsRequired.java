package algorithms.bit_algorithms;

import java.util.Scanner;

/**
 * Count number of bits to be flipped to convert A to B.
 * @author joyghosh
 *
 */
public class MinBitsRequired {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the A: ");
		int A = sc.nextInt();
		System.out.print("Enter the B: ");
		int B = sc.nextInt();
		System.out.printf("Min. bits to be flipped is %d\n",minBitsToConvertAToB(A, B));
//		System.out.printf("Count of set bits in %d is %d\n", n, countBitsBK(n));
		sc.close();
	}
	
	public static int minBitsToConvertAToB(int A, int B){
		//Base case.
		if(A == 0 && B == 0) return 0;
		if(A == 0) return CountSetBits.countBits(B);
		if(B == 0) return CountSetBits.countBits(A);
		
		int xorCount = (A^B);
		return CountSetBits.countBits(xorCount);
	}
}
