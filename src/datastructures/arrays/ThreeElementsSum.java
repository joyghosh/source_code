package datastructures.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ThreeElementsSum {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 7};
		int s = 9;
		System.out.println(hasThreeSum(arr, s));
		System.out.println(hasThreeSumSpaceOpt(arr, s));
	}

	//O(n^3)
	public static boolean hasThreeSum(int[] arr, int s){
	    int n = arr.length;
	    for(int i=0; i<n-2; i++){
	        for(int j=i+1; j<n-1; j++){
	            for(int k=j+1; k<n; k++){
	                if(arr[i]+arr[j]+arr[k] == s){
	                    return true;
	                }
	            }
	        }
	    }
	    
	    return false;
	}

	//O(n^2)
	//Space O(n)
	public static boolean hasThreeSumOpt(int[] arr, int s){
	    int n = arr.length;
	    Set<Integer> lookUp = new HashSet<Integer>();
	    for(int e:arr){
	        lookUp.add(e);
	    }
	    
	    for(int i=0; i<n-2; i++){
	        for(int j=i+1; j<n-1; j++){
	            if(lookUp.contains(s-(arr[i]+arr[j]))){
	                return true;
	            }
	        }
	    }
	    
	    return false;
	}

	//O(log n)
	public static int binarySearch(int[] arr, int l, int h, int s){
	    if(l<h){
	        int mid = (l+h)/2; //l+(h-l)/2;
	        if(arr[mid] == s){
	            return mid;
	        }
	        
	        if(arr[mid]>s){
	            return binarySearch(arr, l, mid-1, s);
	        }
	        
	        return binarySearch(arr, mid+1, h, s);
	    }
	    
	    return -1;
	}


	//O(log n)
	public static int binarySearchIterative(int[] arr, int l, int h, int s){
	    while(l<h){
	        int mid = (l+h)/2;
	        if(arr[mid] == s) return mid;
	        if(arr[mid]>s){
	            h = mid-1;
	        }else{
	            l = mid+1;
	        }
	    }
	    
	    return -1;
	}

	//O(n^2*log n)
	//Space O(1)
	public static boolean hasThreeSumSpaceOpt(int[] arr, int s){
	    int n = arr.length;
	    Arrays.sort(arr); //O(nlog n)
	    for(int i=0; i<n-2; i++){
	        for(int j=i+1; j<n-1; j++){
	            if(binarySearchIterative(arr, j+1, n-1, s-(arr[i]+arr[j])) > -1){
	                return true;
	            }
	        }
	    }
	    
	    return false;
	}
}
