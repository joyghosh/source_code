package datastructures.arrays;

import java.util.HashSet;
import java.util.Set;

public class SumZero{

	  public static void main(String[] args){
		  int[] arr = {2,-3,4,1,-6,-4,1};
//		  System.out.println(zeroSumExists(arr));
		  System.out.println(zeroSumExistsEfficient(arr));
	  }
	  
	  //O(n^2)
	  //O(1)
	  public static boolean zeroSumExists(int[] arr){
	    int n = arr.length;
	    for(int i=0; i<n-1; i++){
	      for(int j=i+1; j<n; j++){
	        if(arr[i]+arr[j] == 0){
	          return true;
	        }
	      }
	    }
	    return false;
	  }
	  
	  //O(n)
	  //O(n)
	  public static boolean zeroSumExistsEfficient(int[] arr){
		  int n = arr.length;
		  Set<Integer> elems = new HashSet<>();
		  elems.add(arr[0]);
		  for(int i=1; i<n; i++){
			  if(elems.contains(0-arr[i])){
				  return true;
			  }
			  
			  elems.add(arr[i]);
		  }
		  return false;
	  }
}