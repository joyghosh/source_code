package algorithms.sorting;

/**
 * Bubble sort
 * 
 * @author Joy Ghosh
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {5, 1, 4, 2, 8};
		printArray(arr);
		bubbleSort(arr);
		printArray(arr);
	}
	
	public static void bubbleSort(int[] arr){
		
		int n = arr.length;
		for(int i=0; i<n-1;i++){
			boolean swap = false;
			for(int j=0;j<n-i-1;j++){
				if(arr[j] > arr[j+1]){
					swap(arr, j, j+1);
					swap = true;
				}
			}
			
			if(!swap){
				break;
			}
		}
	}
	
	public static void swap(int[] arr, int i, int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void printArray(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.printf("%d ",arr[i]);
		}
		System.out.println();
	}
}
