package algorithms.divide_and_conquer;

public class InversionCount {

	public static void main(String[] args) {
		int arr[] = {1, 20, 6, 4, 5};
		System.out.println(mergeSort(arr));
	}

	
	public static int  mergeSort(int[] arr){
		int[] temp = new int[arr.length];
		return mergeSort(arr, temp, 0, arr.length-1);
	}
	
	public static int mergeSort(int[] arr, int[] temp, int left, int right){
		
		int invCount = 0;
		if(left < right){
			int mid = (left + right)/2;
			
			invCount = mergeSort(arr, temp, left, mid);
			invCount += mergeSort(arr, temp, mid+1, right);
			invCount += merge(arr, temp, left, mid+1, right); 
		}
		
		return invCount;
	}
	
	public static int merge(int[] arr, int[] temp, int left, int mid, int right){
		int i = left;
		int j = mid;
		int k = left;
		int invCount = 0;
		
		while((i<=mid-1) && (j<=right)){
			if(arr[i] <= arr[j]){
				temp[k++] = arr[i++];
			}else{
				temp[k++] = arr[j++];
				invCount = invCount + mid-i;
			}
		}
		
		//Copy the remaining elements.
		while(i<=mid-1){
			temp[k++] = arr[i++];
		}
		
		while(j<=right){
			temp[k++] = arr[j++];
		}
		
		//Copy back the merged array to the original.
		for(i=left; i<=right; i++){
			arr[i] = temp[i];
		}
		
		return invCount;
	}
}
