package algorithms.sorting;

/**
 * Heapsort class.
 * Array based binary heap.
 * @author Joy Ghosh
 *
 */
public class HeapSort {

	public static void main(String[] args) {
			int[] arr = {12, 11, 13, 5, 6, 7};
			
			System.out.println("Original array.");
			printArray(arr);
			
			heapSort(arr);
			
			System.out.println("Sorted array.");
			printArray(arr);
	}

	/**
	 * Heapify the sub-tree rooted at node i.
	 * Time-complexity: O(logn)
	 * Space-complexity: O(1)
	 * @param arr
	 * @param i
	 * @param size
	 */ 
	public static void heapify(int[] arr, int i, int size){
		
		int largest = i;	//init the largest as root.
		int left = 2*i + 1;		//index of left child node.
		int right = 2*i + 2;	//index of right child node.
		
		//Find the largest element.
		if(left<size && arr[left] > arr[largest]){
			largest = left;
		}
		
		if(right<size && arr[right] > arr[largest]){
			largest = right;
		}
		
		//check if there is a change and recursively heapify for the affected sub-tree.
		if(largest != i){
			swap(arr, i, largest);
			heapify(arr, largest, size);
		}
	}
	
	/**
	 * Heapsort
	 * Time-complexity: O(nlogn)
	 * Space-complexity: O(1) 
	 * @param arr
	 */
	public static void heapSort(int[] arr){
		
		int size = arr.length;
		
		//Build heap.
		for(int i=(size/2)-1; i>=0; i--){
			heapify(arr, i, size);
		}
		
		//Extract element one by one.
		for(int i=size-1; i>=0; i--){
			swap(arr, 0, i);
			
			heapify(arr, 0, i);
		}
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
