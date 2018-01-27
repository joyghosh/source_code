package datastructures.arrays;

public class EvenOdd {

	public static void main(String[] args) {
		int[] arr = {12, 34, 45, 9, 8, 90, 3};
		arr = evenOdd(arr);
		for(int e:arr){
			System.out.printf("%d ", e);
		}
	}
	
	public static int[] evenOdd(int[] arr){
		int n = arr.length;
		int nextEven = 0;
		int nextOdd = n-1;
		
		while(nextEven < nextOdd){
			if(arr[nextEven]%2 == 0){
				nextEven++;
			}else{
				int tmp = arr[nextEven];
				arr[nextEven] = arr[nextOdd];
				arr[nextOdd--] = tmp;
			}
		}
		
		return arr;
	}
}
