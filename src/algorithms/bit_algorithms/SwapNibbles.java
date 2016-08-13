package algorithms.bit_algorithms;

/**
 * Swap two nibbles in a byte
 * A nibble is a four-bit aggregation, or half an octet. There are two nibbles in a byte.
 * Given a byte, swap the two nibbles in it. For example 100 is be represented as 01100100 in a byte (or 8 bits). 
 * The two nibbles are (0110) and (0100). If we swap the two nibbles, we get 01000110 which is 70 in decimal.
 * 
 * @author Joy Ghosh
 *
 */
public class SwapNibbles {

	public static void main(String[] args) {
		System.out.println("After swapping nibbles: "+swapNibblesOfByte(70));
	}
	
	/**
	 * T.C. = O(1)
	 * Aux. S.C = O(n)
	 * 
	 * @param n
	 * @return
	 */
	public static int swapNibblesOfByte(int n){
		if(n==0)
			return n;
		
		int first_nibble = n & (0xF0);
		int second_nibble = n & (0x0F);
		
		return ((first_nibble>>4)|(second_nibble<<4));
	}
}
