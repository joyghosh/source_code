package algorithms.dynamic_programming;

/**
 * Minimum number of jumps to reach end
 * Given an array of integers where each element represents the max number of steps 
 * that can be made forward from that element. Write a function to return the minimum 
 * number of jumps to reach the end of the array (starting from the first element). 
 * If an element is 0, then cannot move through that element.
 * Example:
 * Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
 * Output: 3 (1-> 3 -> 8 ->9)
 * First element is 1, so can only go to 3. Second element is 3, so can make at most 3 steps 
 * eg to 5 or 8 or 9.
 * 
 * @author Joy Ghosh
 *
 */
public class MinNumberOfJumps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		int arr[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
		int steps = minJumps(arr); //naiveRecursion(arr, 0, arr.length-1);
		if(steps != Integer.MAX_VALUE){
			System.out.println("Min. steps: "+steps);
		}else{
			System.out.println("Reached dead-end.");
		}
	}
	
	public static int naiveRecursion(int[] arr, int start, int end){
		if(start > end)
			return 0;
					
		if(arr[start] == 0)
			return Integer.MAX_VALUE;
		
		int min = Integer.MAX_VALUE;
		for(int i=1;i<=arr[start];i++){
			int v = naiveRecursion(arr, start+i, end); 
			if(v < min){
				min = v; 
			}
		}
		return min+1;
	}
	
	public static int minJumps(int[] arr){
		if(arr.length == 0 || arr[0] == 0)
			return Integer.MAX_VALUE;
		
		int[] jumps = new int[arr.length];
		jumps[0] = 0;
		
		for(int i=1;i<arr.length;i++){
			jumps[i] = Integer.MAX_VALUE;
			for(int j=0;j<i;j++){
				if(i<= j+arr[j] && jumps[j] != Integer.MAX_VALUE){
					jumps[i] = Math.min(jumps[i], jumps[j]+1);
					break;
				}
			}
		}
		
		return jumps[arr.length-1];
	}
}
