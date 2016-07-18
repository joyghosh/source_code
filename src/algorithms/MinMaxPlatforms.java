package algorithms;

/**
 * Min. or max. platforms required.
 * @author Joy Ghosh
 *
 */
public class MinMaxPlatforms {

	public static void main(String[] args) {
		
		int[] arrivals = {1500, 900, 940, 950, 1100, 1800};
		int[] departures = {1900, 910, 1200, 1120, 1130, 2000};
		int size = arrivals.length;
//		System.out.println(2);
//		System.out.println("Min. number of platforms required: "+minOrMaxPlatformsNaive(arrivals,departures, size));
		System.out.println("Min. number of platforms: "+minOrMaxPlatforms(arrivals, departures, size));
	}
	
	/**
	 * A simple O(n^2) soln.
	 * @param arr
	 * @param dep
	 * @param n
	 * @return
	 */
	private static int minOrMaxPlatformsNaive(int[] arr, int[] dep, int n){
		
		if(n==0){
			return 0;
		}
		
		int platforms; 
		int max = 1;
//		int i=1, j= 0;
//		
//		while(i<n && j<n){
//			if(arr[i] < dep[j]){
//				platforms++; i++;
//				if(platforms > max){
//					max = platforms;
//				}
//			}else{
//				platforms--;
//				j++;
//			}
//		}
		
		for(int i=0;i<(n-1);i++){
			platforms = 1;
			for(int j=i+1;j<n;j++){
				if(arr[j] <= dep[i] && dep[j] >= arr[i]){
					platforms++;
				}
			}
			
			if(platforms > max){
				max = platforms;
			}
		}
		return max;
	}
	
	private static int minOrMaxPlatforms(int[] arr, int[] dep, int n){
		
		//sort the arrays using an O(nlog n) algorithm.
		mergeSort(arr, 0, n-1);	
		mergeSort(dep, 0, n-1);
		
		int platforms = 0; 
		int max = 0;
		int i=0, j= 0;
		
		while(i<n && j<n){
			if(arr[i] < dep[j]){
				platforms++; i++;
				if(platforms > max){
					max = platforms;
				}
			}else{
				platforms--;
				j++;
			}
		}
		
		return max;
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
