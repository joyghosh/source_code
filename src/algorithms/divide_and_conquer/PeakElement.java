package algorithms.divide_and_conquer;

public class PeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 20, 30, 40, 50};
		int n = arr.length;
		System.out.println(peak(arr, n));
	}
	
	//O(n) solution.
	private static int peak(int[] arr){
        int n = arr.length;
        if(n==0) return Integer.MIN_VALUE;
        if(n==1) return arr[0];
        
        
        for(int i=0;i<n;i++){
            if(i==0 && arr[i]>arr[i+1]){
                return arr[i];
            }else if(i==n-1 && arr[i]>arr[i-1]){
                return arr[i];
            }else if(i>0 && i<n-1 && arr[i]>arr[i-1] && arr[i]>arr[i+1]){
                return arr[i];
            }
        }    
        return Integer.MIN_VALUE;
	}
	
	//O(logn)
	private static int peak(int[] arr, int n){
		return peakUtil(arr, 0, n-1, n);
	}

	private static int peakUtil(int[] arr, int l, int r, int n){
		int mid = l + (r-l)/2;
		
		if((mid==0 || arr[mid-1]<=arr[mid]) && (mid==n-1 ||  arr[mid+1] <= arr[mid])){
			return arr[mid];
		}else if(mid>0 && arr[mid-1]>arr[mid]){
			return peakUtil(arr, l, mid-1, n);
		}else{
			return peakUtil(arr, mid+1, r, n);
		}
	}
}
