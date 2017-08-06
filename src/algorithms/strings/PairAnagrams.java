package algorithms.strings;

 import java.util.Scanner;

/**
 * Given an array of strings, find all anagram pairs in the given array.
 *  
 * @author joyghosh
 *
 */
public class PairAnagrams {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of the array (n): ");
		int n = sc.nextInt();
		System.out.println("Enter the array of strings.");
		String[] strings = new String[n];
		for(int i=0; i<n; i++){
			System.out.printf("strings[%d]: ", i);
			strings[i] = sc.next();
		}
		
		printAnagramPairs(strings);
		sc.close();
	}
	
	//O(n^2*m), where n is the number of strings and m is the max. length of a string.
	private static void printAnagramPairs(String[] strings){
		
		System.out.println("Checking for anagram pairs in an array of strings.");
		for(int i=0; i<strings.length-1; i++){
			for(int j=i+1; j<strings.length; j++){
				if(CheckAnagram.areAnagramsUsingCount(strings[i], strings[j])){
					System.out.println("("+strings[i]+","+strings[j]+")");
				}
			}
		}
	}
}
