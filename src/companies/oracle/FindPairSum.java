package companies.oracle;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given array of integers and element find whether sum of any two elements equal to given number.
 * @author Joy Ghosh
 *
 */
public class FindPairSum {

	public static void main(String[] args) {
		int A[] = {1, 4, 45, 6, 10, -8};
		findPair(A, 112);
		findPairHash(A, 112);
	}

	/**
	 * [using sorting]
	 * Time-complexity: O(n * log n)
	 * Space-complexity: O(1)
	 * 
	 * @param arr
	 * @param sum
	 */
	public static void findPair(int[] arr, int sum){
		
		Arrays.sort(arr);	//Assume this sorting takes O(n log n).
		int l = 0; int r = arr.length-1;
		while(l<r){
			if((arr[l] + arr[r]) == sum){
				System.out.printf("%d, %d \n", arr[l], arr[r]);
				return;
			}else if((arr[l] + arr[r]) < sum){
				l++;
			}else{
				r--;
			}
		}	
		System.out.println("No such pair found.");
	}
	
	/**
	 * [using hashing]
	 * Time-complexity: O(n)
	 * Space-complexity: O(m) where m is the number of unique elements.
	 * 
	 * @param arr
	 * @param sum
	 */
	public static void findPairHash(int[] arr, int sum){
		Set<Integer> elements = new HashSet<Integer>();
		for(int v:arr){
			if(elements.contains(sum-v)){
				System.out.printf("%d, %d \n", v, sum-v);
				return;
			}else{
				elements.add(v);
			}
		}
		System.out.println("No such pair found.");
	}
}
