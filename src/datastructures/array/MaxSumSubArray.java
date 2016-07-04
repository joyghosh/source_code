package datastructures.array;

//Program to find the max. sum of a contiguous sub-array using Kadane's algorithm. 
public class MaxSumSubArray {
	
	public static void main(String []args){
		int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println("Max. sum of contiguous sub-array.");
		System.out.println(maxSumSubArray(arr));
	}
	
	//find the max. sum of the contiguous sub-array.
	private static int maxSumSubArray(int[] arr){
		int sum = 0;
		
		if(isAllNegative(arr)){
			
			sum = arr[0];
			for(int i=1;i<arr.length;i++){
				if(arr[i]>sum)
					sum = arr[i];
			}
		}else{
			
			int max_so_far, max_ending_here;
			max_so_far = max_ending_here = 0;
			
			for(int i=0;i<arr.length;i++){
				max_ending_here += arr[i];
				if(max_ending_here < 0)
						max_ending_here = 0;
				else if(max_so_far < max_ending_here)
					max_so_far = max_ending_here;
			}
			
			sum = max_so_far;
		}
		return sum;
	}
	
	//Check for all negative array.
	private static boolean isAllNegative(int[] arr){
		
		boolean flag = true;
		for(int i=0;i<arr.length;i++){
			if(!(arr[i]<0)){
				flag = false;
				break;
			}
		}
		return flag;
	}
}
