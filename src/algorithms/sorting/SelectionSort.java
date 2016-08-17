package algorithms.sorting;

/**
 * Selection sort.
 * 
 * @author Joy Ghosh
 *
 */
public class SelectionSort {

	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int[] arr = {64, 25, 12, 22, 11};
		printArray(arr);
		selectionSort(arr);
		printArray(arr);
	}
	
	public static void selectionSort(int[] arr){
		int n = arr.length;
		for(int i=0; i<n-1; i++){
			int min_idx = i;
			for(int j=i+1; j<n; j++){
				if(arr[min_idx] > arr[j]){
					min_idx = j;
				}
			}
			
			if(min_idx!=i){
				swap(arr, min_idx, i);
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
