package algorithms.dynamic_programming;

public class RodCutting {

	public static void main(String[] args) {
		 int arr[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
		 int size = arr.length;
		 System.out.println("Maximum Obtainable Value is "+ cutRodRecursive(arr, size));
	}
	
	public static int cutRodRecursive(int[] price, int n){
		if(n==0)
			return 0;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			max = Math.max(max, price[i]+cutRodRecursive(price, n-i-1));
		}
		
		return max;
	}
}
