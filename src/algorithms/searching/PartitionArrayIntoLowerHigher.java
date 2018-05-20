package algorithms.searching;

public class PartitionArrayIntoLowerHigher {

	public static void main(String[] args) {
//		int[] arr = {5, 1, 4, 3, 6, 8, 10, 7, 9};
		int[] arr = {5, 1, 4, 4};
//		int index = findPartitionIndex(arr);
		int index = findPartitionIndexOptimal(arr);
		if(index != -1){
			System.out.println("Partition index: "+index);
		}else{
			System.out.println("No such index exists.");
		}
	}
	
	public static int findPartitionIndex(int[] arr){
		int n = arr.length;
		int resultIndex = -1;
		
		for(int i=0; i<n; i++){
			boolean isPotentialIndex = true;
			
			for(int j=0; j<i; j++){
				if(arr[j]>arr[i]){
					isPotentialIndex = false;
					break;
				}
			}
			
			if(isPotentialIndex){
				for(int k=i+1; k<n; k++){
					if(arr[k]<arr[i]){
						isPotentialIndex = false;
						break;
					}
				}
			}
			
			if(isPotentialIndex){
				resultIndex = i;
				break;
			}
		}
		
		return resultIndex;
	}
	
	public static int findPartitionIndexOptimal(int[] arr){
		int n = arr.length;
		int resultIndex = -1;
		int[] leftMax = new int[n];
		int[] rightMin = new int[n];
		
		leftMax[0] = Integer.MIN_VALUE;
		for(int i=1; i<n; i++){
			leftMax[i] = Math.max(leftMax[i-1], arr[i-1]); 
		}
		
		rightMin[n-1] = Integer.MAX_VALUE;
		for(int i=n-2; i>=0; i--){
			rightMin[i] = Math.min(rightMin[i+1], arr[i+1]); 
		}
		
		
		for(int i=0; i<n; i++){
			if(arr[i]>leftMax[i] && arr[i]<rightMin[i]){
				resultIndex = i;
				break;
			}
		}
		
		return resultIndex;
	}
}
