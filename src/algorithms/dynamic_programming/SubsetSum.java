package algorithms.dynamic_programming;

public class SubsetSum {

	public static void main(String[] args) {
		int[] arr = {3, 34, 4, 12, 5, 2};
		int sum = 9;
		if(isSubsetSum(arr, arr.length, sum)){
			System.out.println("Subset exists with desired sum.");
		}else{
			System.out.println("No such subset found.");
		}
	}
	
	public static boolean isSubsetSum(int[] arr, int n, int sum){
		if(sum!=0 && n==0) return false;
		if(sum == 0) return true;
		
		if(arr[n-1] > sum) return isSubsetSum(arr, n-1, sum);
		
		return (isSubsetSum(arr, n-1, sum) || isSubsetSum(arr, n-1, sum-arr[n-1]));
	}
	
//	public static boolean isSubsetSumDp(int[] arr, int sum){
//		boolean[] result = new boolean[sum+1];
//		
//		for()
//	}
}
