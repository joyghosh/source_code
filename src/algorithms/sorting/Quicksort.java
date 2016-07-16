package algorithms.sorting;

/**
 * Quicksort implementation. (recursive version)
 * @author Joy Ghosh
 *
 */
public class Quicksort {

	public static void main(String[] args) {
		int[] arr = {12, 11, 13, 5, 6, 7};
		
		System.out.println("Original array.");
		printArray(arr);
		
		quickSort(arr, 0, arr.length - 1);
		
		System.out.println("Sorted array.");
		printArray(arr);
	}
	
	/**
	 * Sorts an array using quicksort. Here pivot element is always the last element.
	 * Time-complexity: O(n Log n) for avg. case.
	 * Time-complexity: O(n^2) for worst case.
	 * Space-complexity: O(1)
	 * @param arr
	 * @param low
	 * @param end
	 */
	public static void quickSort(int[] arr, int low, int end){
		if(low < end){
				int p = partition(arr, low, end);
				quickSort(arr, low, p-1);
				quickSort(arr, p+1, end);
		}
	}
	
	/**
	 * Partition method. In this case we always select the last element as pivot.
	 * @param arr
	 * @param low
	 * @param end
	 * @return the index of the pivot.
	 */
	public static int partition(int[] arr, int low, int end){
		
		int pivot = arr[end];	//always select the last element as pivot.
		int i = low - 1;		//index of the smaller element.
		
		for(int j=low; j<end; j++){
			if(arr[j] <= pivot){
				i++;				//increment the smaller element index.
				swap(arr, i, j);
			}
		}
		swap(arr, i+1, end);
		return (i+1);
	}
	
	/**
	 * Swap elements in an array.
	 * @param arr
	 * @param i
	 * @param j
	 */
	public static void swap(int[] arr, int i, int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	/**
	 * Utility method to display an array.
	 * Time-complexity: O(n)
	 * Space-complexity: O(1)
	 * @param arr
	 */
	public static void printArray(int[] arr){
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
}
