package companies.adobe;

import java.util.BitSet;

/**
 * Find the two's complement of a boolean string.
 * @author Joy Ghosh
 *
 */
public class TwosComplement {

	public static void main(String[] args) {
		
		String str = "00011100";
		System.out.println("2's complement is : "+twosComplementOf(str));
	}

	private static String twosComplementOf(String str){
		
		BitSet bit = new BitSet(str.length());
		BitSet tmp = new BitSet(); tmp.set(str.length()-1);
		
		System.out.println(bit.toString());
		System.out.println(tmp.toString());
		
		//Initialization.
		int i = 0;
		for(char c:str.toCharArray()){
			if(c == 1){
				bit.set(i);
			}
			i++;
		}
		
		System.out.println(bit.toString());
		
		//Actual 2's complement.
		//Step 1: Invert each bit.
		bit.flip(0, bit.size());
		
		System.out.println(bit.toString());
		
		//Step 2: Add 1 to above.
		bit.or(tmp);
		
		System.out.println(bit.toString());
		
		return bit.toString();
	}
}
