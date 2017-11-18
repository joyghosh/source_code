package datastructures.arrays;

import java.util.Arrays;

public class TopK{

	  public static void main(String[] args){
	    int[] productsSales = {12, 45, 89, 11, 2, 0, 15};
	    int k = 2;
	    int[] result = topKElements(productsSales, k);
	    for(int r:result){
	    	System.out.println(r);
	    }
	  }

	  public static int[] topKElements(int[] arr, int k){
	      Arrays.sort(arr);
	      int[] result = new int[k];
	      for(int i=arr.length-1, j=0; j<k; j++, i--){
	        result[j] = arr[i];
	      }
	      return result;
	  }
}