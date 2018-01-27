package datastructures.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetOperations {

	public static void main(String[] args) {
	    int arr1[] = { 7, 1, 5, 2, 3, 6 };
	    int arr2[] = { 3, 8, 6, 20, 7 };
	    int M = arr1.length;
	    int N = arr2.length;
	    
	    List<Integer> result = insersection(arr1, arr2, M, N);
	    System.out.println(result);
//	    for(int e:result){
//	    	System.
//	    }
	}
	
	public static List<Integer> insersection(int[] arr1, int[] arr2, int M, int N){
		Set<Integer> lookUp = new HashSet<Integer>();
		List<Integer> result = new ArrayList<Integer>();
		if(M<N){
			for(int e:arr1){
				lookUp.add(e);
			}
			
			for(int i:arr2){
				if(lookUp.contains(i)){
					result.add(i);
				}
			}
		}else{
			for(int e:arr2){
				lookUp.add(e);
			}	
			for(int i:arr1){
				if(lookUp.contains(i)){
					result.add(i);
				}
			}
		}
		return result;
	}
}
