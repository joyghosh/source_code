package companies;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find pair sums in a list with and without duplicates.
 * @author Joy.
 *
 */
public class PairSum {

	public static void main(String[] args) {
		
		int[] arr1 = {1,2,3,4,6,8,9};
		int[] arr2 = {1,2,3,4,6,8,4,4,9};
		int sum = 8;
		printPairSum(arr1, sum);
		printPairSumWithDuplicates(arr2, sum);
	}
	
	/**
	 * Time-complexity = O(n).
	 * Space complexity = O(n).
	 * @param arr
	 * @param sum
	 */
	private static void printPairSum(int[] arr, int sum){
		
		System.out.println("without duplicates.");
		Set<Integer> s = new HashSet<Integer>();
		
		//Initialization.
		for(int v:arr){
			s.add(v);
		}
		
		//Actual pair finding.
		for(int v:arr){
			if(v != (sum-v) && s.contains(sum-v)){
				System.out.println(v+":"+(sum-v));
				s.remove(v); s.remove(sum-v);
			}
		}
	}
	
	/**
	 * Time-complexity = O(n^2).
	 * Space-complexity = O(n).
	 * @param arr
	 * @param sum
	 */
	private static void printPairSumWithDuplicates(int[] arr, int sum){
		
		System.out.println("with duplicates.");
		List<Integer> list = new ArrayList<Integer>();
		
		//Initialization.
		for(int v:arr){
			list.add(v);
		}
				
		//Actual pair finding.
		for(int v:arr){
			while(true){
				if(list.contains(sum-v)){
					System.out.println(v+":"+(sum-v));
					list.remove((Integer)(sum-v)); list.remove((Integer)v);
				}else{
					break;
				}
			}
		}
	}
}
