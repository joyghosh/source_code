package datastructures.hashing;

import java.util.HashMap;
import java.util.Map;

public class CountDistinctKWindow {

	public static void main(String[] args) {
		int arr[] =  {1, 2, 1, 3, 4, 2, 3};
        int k = 4;
        countDistinctKWindow(arr, k);
	}
	
	//Using hashmap.
	//Time complexity of O(n).
	private static void countDistinctKWindow(int[] arr, int k){
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int distCount = 0;
		
		//For the first k elements.
		for(int i=0;i<k;i++){
			if(!hm.containsKey(arr[i])){
				hm.put(arr[i], 1);
				++distCount;
			}else{
				int count = hm.get(arr[i]);
				hm.put(arr[i], count+1);
			}
		}
		
		System.out.println("Distinct count: "+distCount);
		
		//For the remaining array.
		for(int i=k; i<arr.length; i++){
			if(hm.get(arr[i-k]) == 1){
				hm.remove(arr[i-k]);
				--distCount;
			}else{
				int count = hm.get(arr[i-k]);
				hm.put(arr[i-k], count-1);
			}
			
			//Check for new elements.
			if(!hm.containsKey(arr[i])){
				hm.put(arr[i], 1);
				++distCount;
			}else{
				int count = hm.get(arr[i]);
				hm.put(arr[i], count+1);
			}
			
			//print the distinct count for this k size window.
			System.out.println("Distinct count: "+distCount);
		}
	}
}
