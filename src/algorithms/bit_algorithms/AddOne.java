package algorithms.bit_algorithms;

/**
 * Add 1 to a given number
 * Write a program to add one to a given number. 
 * You are not allowed to use operators like ‘+’, ‘-‘, ‘*’, ‘/’, ‘++’, ‘–‘ …etc.
 * 
 * Examples:
 * Input: 12
 * Output: 13
 * 
 * Input: 6
 * Output: 7
 * 
 * @author Joy Ghosh
 *
 */
public class AddOne {

	public static void main(String[] args) {
		System.out.println(addOne(13));
	}

	/**
	 * TC: O(n), n is the number of bits.
	 * ASC: O(1).
	 * 
	 * @param x
	 * @return
	 */
	public static int addOne(int x){
		int m = 1;
		
		//Keep flipping the set bits until we reach the rightmost 0.
		while((x & m)==1){
			x = x^m;
			m<<=1;
		}
		
		//flip the rightmost zero and return.
		return x^m;
	}
}
