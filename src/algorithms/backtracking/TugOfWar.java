package algorithms.backtracking;

public class TugOfWar {

	public static void main(String[] args) {
		int[] a = { 23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4 };
		tugOfWarWrapper(a);
	}

	public static int tugOfWarWrapper(int[] arr){
		boolean[] soln = new boolean[arr.length];
		boolean[] selected = new boolean[arr.length];
		int diff = Integer.MAX_VALUE;
		tugOfWar(arr, diff, selected, soln, 0);
		printSoln(arr, soln);
		return diff;
	}
	
	/**
	 * 
	 * (1) Check if the selected subset is of required size, check for min. difference and update accordingly.
	 * (2) Check if we've reached the end of the array, simply return.
	 * (3) Include the current element into the set and call recursively.
	 * (4) Exclude the current element into the set and call recursively.
	 * 
	 * @param arr
	 * @param diff
	 * @param selected
	 * @param soln
	 * @return
	 */
	public static void tugOfWar(int[] arr, int diff, boolean[] selected, boolean[] soln, int curr){
			
		//Condition 1.
		int selectedSize = 0;
		for(boolean v:selected){
			if(v){
				selectedSize++;
			}
		}
		
		if(selectedSize == arr.length/2){
			int l_sum = 0; int r_sum = 0;
			for(int i=0;i<selected.length;i++){
				if(selected[i]){
					l_sum += arr[i];
				}else{
					r_sum += arr[i];
				}
			}
			
			if(Math.abs(l_sum-r_sum) < diff){
				diff = Math.abs(l_sum-r_sum);
				
				//update the solution set.
				for(int i=0; i<selected.length; i++){
					soln[i] = selected[i];
				}
			}else{
				//backtrack.
				selected[curr-1] = false;
			}
		}
		
		//Condition 2.
		if(curr >= arr.length)
			return;
		
		//Condition 3.
		selected[curr] = true;
		tugOfWar(arr, diff, selected, soln, curr+1);
		
		//Condition 4.
		selected[curr] = false;
		tugOfWar(arr, diff, selected, soln, curr+1);
	}
	
	
	/**
	 * Display the soln.
	 * TC: O(n)
	 * @param arr
	 * @param soln
	 */
	public static void printSoln(int[] arr, boolean[] soln){
		
		System.out.println("Set 1");
		for(int i=0; i<soln.length; i++){
			if(soln[i])
				System.out.printf("%d ", arr[i]);
		}
		
		System.out.println();
		System.out.println("Set 2");
		for(int i=0; i<soln.length; i++){
			if(!soln[i])
				System.out.printf("%d ", arr[i]);
		}
	}
}
