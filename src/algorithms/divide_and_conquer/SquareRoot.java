package algorithms.divide_and_conquer;

public class SquareRoot {

	public static void main(String[] args) {
		float n = 25.0f; 
		System.out.println("square root using simple solution: "+squareRootBasic(n));
		System.out.println("square root using binary search: "+squareRootAdvanced(n, 1.0f, n));
	}
	
	/**
	 * Square root simple solution. FloorOf(sqrt(n))
	 * Time-complexity: O(n^1/2)
	 * @return
	 */
	private static float squareRootBasic(float n){
		
		//base case.
		if(n == 0 || n == 1)
			return n;
		
		float i = 1.0f; float result = i;
		while(result<=n){
			if(result == n){
				return i;
			}
			i++;
			result = i*i;
		}
		
		return i-1;
	}
	
	/**
	 * Binary search approach to calculate the square root.
	 * Time-complexity: O(log n)
	 * @param n
	 * @return
	 */
	private static float squareRootAdvanced(float n, float start, float end){
		float ans = 0.0f;
		if(start <= end){
			float mid = start+(end-start)/2;
			
			if((mid*mid) == Math.floor(n))
				return mid;
			
			if((mid*mid) > n){
				return squareRootAdvanced(n, start, mid-1.0f);
			}
			
			if((mid*mid) < n){
				ans = mid;
				return squareRootAdvanced(n, mid+1.0f, end);
			}
		}
		
		return ans;
	}
}
