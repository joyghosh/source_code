package algorithms.strings;

import java.util.Scanner;

/**
 * Given two strings in lowercase, the task is to make them anagram. The only allowed operation is to remove a character from any string. Find minimum number of characters to be deleted to make both the strings anagram?
 * If two strings contains same data set in any order then strings are called Anagrams.
 * 
 * e.g.
 * Input : str1 = "bcadeh" str2 = "hea"
 * Output: 3
 * We need to remove b, c and d from str1.
 * 
 * Input : str1 = "cddgk" str2 = "gcd"
 * Output: 2
 * 
 * Input : str1 = "bca" str2 = "acb"
 * Output: 0
 * 
 * @author joyghosh
 *
 */
public class AnagramsMinChar {
	
	private static final int ALPHABET_SIZE = 256;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the first string str1: ");
		String str1 = sc.nextLine();
		
		System.out.print("Enter the second string str2: ");
		String str2 = sc.nextLine();
		
		System.out.println("Min. chars to remove for both strings to be anagrams: "
						+minCharactersToRemove(str1, str2));
		sc.close();
	}
	
	private static int minCharactersToRemove(String str1, String str2){
		int[] count1 = new int[ALPHABET_SIZE];
		int[] count2 = new int[ALPHABET_SIZE];
		
		for(int i=0; i<str1.length(); i++){
			++count1[(int) str1.charAt(i)];
		}
		
		for(int i=0; i<str2.length(); i++){
			++count2[(int) str2.charAt(i)];
		}
		
		int result = 0;
		for(int i=0; i<ALPHABET_SIZE; i++){
			result += Math.abs(count1[i] - count2[i]);
		}
		
		return result;
	}
}
