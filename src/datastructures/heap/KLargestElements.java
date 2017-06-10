package datastructures.heap;

import java.util.Scanner;

public class KLargestElements {

	public static void main(String[] args) {
		int[] arr;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the array size(n): ");
		int n = sc.nextInt();
		if(n>0){
			arr = new int[n];
			System.out.println("Enter the array values.");
			for(int i=0; i<n; i++){
				System.out.printf("value arr[%d]: ",i);
				arr[i] = sc.nextInt();
			}
			
			System.out.print("How many largest value you need(k): ");
			int k = sc.nextInt();
			if(k>0 && k<n){
				System.out.printf("Finding the %d largest value .....", k);
				int[] result = new int[k];
				result = kLargestElements(arr, k);
				for(int e:result){
					System.out.printf("%d ",e);
				}
			}else{
				exit();
			}
		}else{
			exit();
		}
		
		sc.close();
	}
	
	private static void exit(){
		System.err.println("Usage: n>, k>0 and k<n.");
		System.exit(1);
	}
	
	//O((n-k)*k)
	private static int[] kLargestElements(int[] arr, int k){
		if(arr.length == 0) return null;
		
		int[] kLargestArr = new int[k];
		int min = Integer.MAX_VALUE; int minIdx = -1;
		
		//O(k)
		for(int i=0; i<k; i++){
			kLargestArr[i] = arr[i];
			if(kLargestArr[i] < min){
				min = kLargestArr[i];
				minIdx = i;
			}
		}
		
		//O((n-k)*k)
		for(int i=k; i<arr.length; i++){		//O(n-k).
			if(arr[i] > kLargestArr[minIdx]){
				kLargestArr[minIdx] = arr[i];
				minIdx = findMin(kLargestArr); //O(k).
			}
		}
		
		return kLargestArr;
	}
	
	//O(n); n being the size of the array passed.
	private static int findMin(int[] arr){
		if(arr.length == 0) return -1;
		
		int min = Integer.MAX_VALUE;
		int minIdx = -1;
		
		for(int i=0; i<arr.length; i++){
			if(arr[i] < min){
				min = arr[i];
				minIdx = i;
			}
		}
		
		return minIdx;
	}
	
	//O(n); n being the size of the array passed.
	private static int findMax(int[] arr){
		if(arr.length == 0) return -1;
		
		int max = Integer.MIN_VALUE;
		int maxIdx = -1;
		
		for(int i=0; i<arr.length; i++){
			if(arr[i] > max){
				max = arr[i];
				maxIdx = i;
			}
		}
		
		return maxIdx;
	}
}
