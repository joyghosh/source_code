package algorithms.maths;

import java.util.Arrays;

/**
 * Program to print all permutations of a string in sorted order.
 * 
 * @author Joy Ghosh
 *
 */
public class DistinctAnagrams {
	
	//Driver program
	public static void main(String[] args) {
		String str = "ACBC";
		distinctPermute(str.toCharArray());
	}
	
	//Print all distinct permutations
	public static void distinctPermute(char[] str){
		
		int len = str.length;
		
		//Sort the string alphabetically.
		Arrays.sort(str);
		
		//status flag.
		boolean isFinished = false;
		while(!isFinished){
			System.out.println(str);
			
			//Find the rightmost character smaller than its next character.
			int i;
			for(i=len-2;i>=0; --i){
				if(str[i] < str[i+1]){
					break;
				}
			}
			
			//if there is no such character, all are sorted in decreasing order,
			//means we just printed the last permutation and we are done.
			if(i == -1){
				isFinished = true;
			}else{
				// Find the ceil of 'first char' in right of first character.
	            // Ceil of a character is the smallest character greater than it.
				int ceil = findCeil(str, str[i], i+1, len-1);
				
				// Swap first and second characters
				swap(str, i, ceil);
				
				// Sort the string on right of 'first char'
				Arrays.sort(str, i+1, len);
			}
		}
	}
	
	//Find the index for the ceiling character.
	public static int findCeil(char[] arr, char first, int l, int h){
		int ceil_index = l;
		
		for(int i=l+1;i<=h;i++){
			if(arr[i] > first && arr[i] < arr[ceil_index]){
				 ceil_index = i;
			}
		}
		return ceil_index;
	} 
	
	//Swap characters in an array.
	public static void swap(char[] str, int i, int j){
	    char tmp = str[i];
	    str[i] = str[j];
	    str[j] = tmp;
	}
}
