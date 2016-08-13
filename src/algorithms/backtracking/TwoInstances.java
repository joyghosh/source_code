package algorithms.backtracking;

/**
 * Fill two instances of all numbers from 1 to n in a specific way.
 * Given a number n, create an array of size 2n such that the array contains 2 instances of every number from 1 to n, 
 * and the number of elements between two instances of a number i is equal to i. 
 * If such a configuration is not possible, then print the same.
 * 
 * @author Joy Ghosh
 *
 */
public class TwoInstances {

	public static void main(String[] args) {
		placeInstancesWrapper(7);
	}
	
	/**
	 * Instance placement wrapper.
	 * 
	 * Aux. space complexity: O(2*n)
	 * 
	 * @param n
	 */
	public static void placeInstancesWrapper(int n){
		int[] result = new int[2*n];
		
		//initialization. Not needed, default value of elements is zero.
		
		//check if such a solution is possible or not.
		if(placeInstances(result, n)){	
			for(int v:result){
				System.out.printf("%d ",v);
			}
		}else{
			System.out.println("No such configuration possible.");
		}
	}
	
	/**
	 * Place instances recursively.
	 * @param arr
	 * @param n current instance number.
	 * @return
	 */
	public static boolean placeInstances(int[] arr, int n){
		
		if(n==0) return true;	//if current number becomes zero, then all numbers are filled.
		
		for(int i=0; i<(arr.length - n - 1);i++){
			if(arr[i] == 0 && arr[i+n+1] == 0){
				arr[i] = arr[i+n+1] = n;	//try placing the instances at these locations.
				//If this current config works, return true.
				if(placeInstances(arr, n-1)){
					return true;
				}		
				//Else backtrack, try some other locations.
				arr[i] = arr[i+n+1] = 0;
			}
		}
		return false;
	}
}
