package datastructures.arrays;

public class MinStepsToDesiredArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {16, 16, 16};
		System.out.println("Min. no. of steps: "+minStepsRequired(arr));
	}

	public static int minStepsRequired(int[] target){
		
		int[] result = new int[target.length];
		int steps = 0;
		
		while(!isEqual(target, result)){
			
			if(isAllEven(target)){
				for(int i=0; i<target.length; i++){
					target[i] /= 2;
				}
				++steps;
			}else{
				for(int i=0; i<target.length; i++){
					if(target[i]%2 != 0){
						--target[i];
					}
					++steps;
				}
			}
		}
		
		return steps;
	}
	
	public static boolean isEqual(int[] arr1, int[] arr2){
		
		for(int i=0; i<arr1.length; i++){
			if(arr1[i] != arr2[i])
				return false;
		}
		return true;
	}
	
	public static boolean isAllEven(int[] arr){
		for(int i=0; i<arr.length; i++){
			if(arr[i]%2 != 0)
				return false;
		}
		return true;
	}
}
