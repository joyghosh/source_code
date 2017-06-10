package datastructures.arrays;

import java.util.Scanner;

public class FindTripletsZero {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array (n): ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter the elements of the array. ");
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		hasTripletsNaive(arr);
		sc.close();
	}

	//O(n^3) solution. Aux. space O(1).
	private static boolean hasTripletsNaive(int[] arr){
		if(arr.length == 0) return false;
		boolean hasTriplets = false;
		
		int n = arr.length;
		for(int i=0; i<n-2; i++){
			for(int j=i+1; j<n-1; j++){
				for(int k=j+1; k<n; k++){
					if(0 == (arr[i]+arr[j]+arr[k])){
						System.out.printf("Found triplets with sum zero: %d, %d & %d\n", arr[i], arr[j], arr[k]);
						hasTriplets = true;
					}
				}
			}
		}
		
		if(!hasTriplets){
			System.out.println("No triplets with sum zero was found.");
		}
		
		return hasTriplets;
	}
	
	private static boolean hasTripletsUsingHashing(int[] arr){
		if(arr.length == 0) return false;
		
		boolean hasTriplets = false;
		
		
		return hasTriplets;
	}
}
