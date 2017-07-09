package datastructures.arrays;

import java.util.Scanner;

/**
 * Find an element in an unsorted array such that all left elements are smaller and all right elements are greater. 
 * O(n) time complexity solution is required.
 * 
 * e.g.
 * Input:   arr[] = {5, 1, 4, 3, 6, 8, 10, 7, 9};
 * Output:  Index of element is 4
 * All elements on left of arr[4] are smaller than it
 * and all elements on right are greater.
 * 
 * Input:   arr[] = {5, 1, 4, 4};
 * Output:  Index of element is -1
 * 
 * @author joyghosh
 */
public class LeftRightElements {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of the array: ");
		int n = sc.nextInt();
		
		System.out.println("Enter the array elements. ");
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++){
			System.out.printf("Enter value for arr[%d]: ",i);
			arr[i] = sc.nextInt();
		}
		
		System.out.println("Element greater than left and smaller than right elements is: "+findElementSimple(arr));
		sc.close();
	}
	
	//Simple solution.
	//Time complexity: O(n^2)
	//Space complexity: O(1)
	private static int findElementSimple(int[] arr){
		int n = arr.length;
		int result = -1;
		
		for(int i=0; i<n; i++){
			boolean flag = false;
			
			//Check if all elements to the left are smaller than ith element.
			for(int j=0;j<=i-1;j++){
				if(arr[j] > arr[i]){
					flag = false;
					break;
				}
			}
			
			if(flag){
				//Check if all elements to the right are greater than ith element.
				for(int j=n-1;j>=i+1;j--){
					if(arr[j] < arr[i]){
						flag = false;
						break;
					}
				}
			}
			
			if(flag){
				result = i;
				break;
			}
		}
		
		if(result != -1) return arr[result];
		return result;
	}
	
//	private static int findElement(int[] arr){
//		
//	}
}
