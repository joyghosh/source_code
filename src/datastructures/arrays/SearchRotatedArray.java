//package datastructures.arrays;
//
///**
// * Search for an element in a rotated array.
// * @author joyghosh
// * 
// */
//public class SearchRotatedArray {
//
//	public static void main(String[] args) {
//		int[] arr = {1, 3, 5, 7, 18, 19, 34};
//		int key = 1;
//		System.out.println("Index of the key in array: "+binarySearch(arr, 0, arr.length-1, key));
//	}
//	//Binary search.
//	private static int binarySearch(int[] arr, int low, int high, int key){
//		//Base case. Key not found.
//		if(high < low){
//			return -1;
//		}
//		//compute mid.
//		int mid = (low + high)/2;
//		//check for a match.
//		if(key == arr[mid]) return mid;
//		if(key > arr[mid]) return binarySearch(arr, mid+1, high, key);
//		return binarySearch(arr, low, mid-1, key);
//	}
//	//Find pivot.
//	private static int findPivot(int[] arr, int low, int high){
//		//Base case.
//		if(high < low) return -1;
//		if(low == high) return low;
//		
//		//Compute mid.
//		int mid = (low+high)/2;
//		
//		if(mid<high && arr[mid] > arr[mid+1]){
//			return mid;
//		}
//		
//		if(mid>low && arr[mid]<arr[mid-1]){
//			return mid-1;
//		}
//		if(arr[low] >= arr[mid]) return findPivot(arr, low, mid-1);
//		return findPivot(arr, mid+1, high);
//	}
//	//Search the key in a pivoted sorted array.
//	private static int pivotedBinarySearch(){
//		
//	}
//}
