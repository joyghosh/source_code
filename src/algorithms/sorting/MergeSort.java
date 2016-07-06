package algorithms.sorting;

/**
 * Algorithm category: Divide & Conquer. 
 * 
 * @author Joy Ghosh
 * @version 1.0
 */
public class MergeSort {

	public static void main(String[] args) {
		int arr[] = {12, 11, 13, 5, 6, 7};
		System.out.print("unsorted array: ");
		for(int e:arr)
			System.out.print(e+" ");
		mergeSort(arr, 0, arr.length-1);
		System.out.println();
		System.out.print("sorted array: ");
		for(int e:arr)
			System.out.print(e+" ");
	}

	/**
	 * merge sort.
	 * @param arr
	 * @param l
	 * @param r
	 */
	private static void mergeSort(int[] arr, int l, int r){
		
		if(l<r){
			int m = l + (r-l)/2;
			mergeSort(arr, l, m);
			mergeSort(arr, m+1, r);
			merge(arr, l, m, r);
		}
	}
	
	/**
	 * merge two arrays in a sorted order.
	 * @param arr
	 * @param l
	 * @param m
	 * @param r
	 * @return
	 */
	private static void merge(int[] arr, int l, int m, int r){
		
		//sizes of left and right sub-arrays.
		int n1 = m-l+1;
		int n2 = r-m;
		
		//counters.
		int i,j,k;
		
		//temp sub-arrays.
		int[] left = new int[n1];
		int[] right = new int[n2];
		
		for(i=0;i<n1;i++){
			left[i] = arr[l+i];  
		}
		
		for(j=0;j<n2;j++){
			right[j] = arr[m+j+1];
		}
		
		//reset counters.
		i = j = 0;
		k = l;
		while(i<n1 && j<n2){
			if(left[i] <= right[j]){
				arr[k] = left[i];
				i++;
			}else{
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		
		//check for remaining elements.
		while(i<n1){
			arr[k] = left[i];
			i++; k++;
		}
		
		while(j<n2){
			arr[k] = right[j];
			j++; k++;
		}
	}
}
