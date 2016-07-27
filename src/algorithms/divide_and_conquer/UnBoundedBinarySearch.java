package algorithms.divide_and_conquer;

/**
 * Unbounded Binary Search Example (Find the point where a monotonically increasing function becomes 
 * positive first time).
 * <p>
 * Given a function ‘int f(unsigned int x)’ which takes a non-negative integer ‘x’ as input and 
 * returns an integer as output. The function is monotonically increasing with respect to value 
 * of x, i.e., the value of f(x+1) is greater than f(x) for every input x. Find the value ‘n’ where f() becomes positive for the first time. Since f() is monotonically increasing, values of f(n+1), f(n+2),… must be positive and values of f(n-2), f(n-3), .. must be negative.
 * Find n in O(logn) time, you may assume that f(x) can be evaluated in O(1) time for any input x.
 * </p>
 * @author Joy Ghosh
 *
 */
public class UnBoundedBinarySearch {

	public static void main(String[] args) {
		System.out.printf("The value n where f() becomes positive first is %d", firstPositiveIndex());
	}
	
	/**
	 * Monotonically increasing function.
	 * Time-complexity: O(1)
	 * @param x
	 * @return
	 */
	public static int f(int x){
		return (x*x - (10*x) -20);
	}
	
	public static int firstPositiveIndex(){
		
		//When the first index itself is +ve.
		if(f(0) > 0)
			return 0;
		
		//Apply doubling method.
		//Time-complexity: O(log n)
		int i=1;
		while(f(i)<=0){
			i *= 2;
		}
		
		return binarySearch(i/2, i);
	}
	
	/**
	 * Time-complexity: O(log n)
	 * @param low
	 * @param high
	 * @return
	 */
	public static int binarySearch(int low, int high){
		
		if(low <= high){
			
			int mid = low + (high-low)/2;
			if(f(mid) > 0 && (mid==low || f(mid-1) <=0))
				return mid;
			if(f(mid) <= 0){
				return binarySearch(mid+1, high);
			}else{
				return binarySearch(low, mid-1);
			}
		}
		
		return -1;
	}
}
