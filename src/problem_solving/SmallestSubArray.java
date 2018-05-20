package problem_solving;

public class SmallestSubArray {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		displayAllSubarrays(arr);
	}
	
	//O(n^3)
	public static void displayAllSubarrays(int[] arr){
		int n = arr.length;
		
		for(int i=0; i<n; i++){
			for(int j=i; j<n; j++){
				for(int k=i; k<=j; k++){
					System.out.printf("%d ", arr[k]);
				}
				System.out.println();
			}
		}
	}
	
	
}
