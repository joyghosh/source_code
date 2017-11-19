package algorithms.searching;

/**
 * Search an element in a sorted and rotated array.
 * An element in a sorted array can be found in O(log n) time via binary search. 
 * But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand. 
 * So for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise a way to find an element in the rotated 
 * array in O(log n) time.
 * 
 * @author Joy Ghosh
 *
 */
public class SearchRotatedArray {

	public static void main(String[] args) {
		int[] arr = {30, 40, 50, 10, 20};
		int key = 10;
		int index = findElementInPivotedArray(arr, key);
		if(index !=-1){
			System.out.printf("Index of key %d is %d.",key, findElementInPivotedArray(arr, key));
		}else{
			System.out.println("Not found.");
		}
	}
	
	public static int findElementInPivotedArray(int[] arr, int key){
		int n = arr.length;
		int pivot = searchPivot(arr, 0, n-1);
		if(pivot == -1)
			return binarySearch(arr, 0, n-1, key);
		if(arr[pivot] == key)
			return pivot;
		if(arr[0] <= key){
			return binarySearch(arr, 0, pivot-1, key);
		}
		
		return binarySearch(arr, pivot+1, n-1, key);
	}
	
	//Find the pivot index in the rotated array.
	public static int searchPivot(int[] arr, int low, int high){
		
		if(low > high) return -1;
		if(low==high) return low;
		
		int mid = low + (high-low)/2;  //Avoid memory overflow. (low+high)/2
		
		if(mid < high && arr[mid] > arr[mid+1]){
			return mid;
		}
		
		if(mid > low && arr[mid] < arr[mid-1]){
			return mid-1; 
		}
		
		if(arr[mid] <= arr[low]){
			return searchPivot(arr, low, mid-1);
		}
		return searchPivot(arr, mid+1, high);
	}
	
	//Normal binary search.
	public static int binarySearch(int[] arr, int low, int high, int key){
		
		if(low>high) return -1;
		int mid = low + (high-low)/2;
		if(arr[mid] == key){
			return mid;
		}else if(arr[mid]<key){
			return binarySearch(arr, mid+1, high, key);
		}
		
		return binarySearch(arr, low, mid-1, key);
	}
}
