package datastructures.arrays;

public class MajorityElement {

	public static void main(String[] args) {
//		int[] arr = {3, 3, 4, 2, 4, 4, 2, 4, 4};
		int[] arr = {1, 3, 3, 1, 2};
		int major = findMajorityElement(arr);
		if(major == Integer.MIN_VALUE){
			System.out.println("No majority element exists.");
		}else{
			System.out.printf("Majority element is %d \n", major);
		}
	}

	/**
	 * [Moore's voting algorithm]
	 * Time-complexity: O(n).
	 * Space-complexity: O(1).
	 * 
	 * @param arr
	 * @return
	 */
	public static int findMajorityElement(int[] arr){
		
		if(arr.length == 1)
			return arr[0];
		
		//Find a potential candidate.
		int maj_index = 0; int count = 1;
		for(int i=1; i<arr.length; i++){
			if(arr[maj_index] == arr[i]){
				++count;
			}else{
				--count;
			}
			
			if(count == 0){
				maj_index = i;
				count = 1;
			}
		}
		
		//Check if the candidate is actually a majority element.
		count = 0;
		for(int i=0;i<arr.length;i++){
			if(arr[i] == arr[maj_index])
				++count;
		}

		
		if(count > arr.length/2){
			return arr[maj_index];
		}
		
		return Integer.MIN_VALUE;
	}
}
