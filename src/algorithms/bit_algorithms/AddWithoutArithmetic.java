package algorithms.bit_algorithms;

/**
 * Add two numbers without using arithmetic operators.
 * 
 * @author Joy Ghosh
 *
 */
public class AddWithoutArithmetic {

	public static void main(String[] args){
		int x = 15; int y = 32;
		System.out.println("sum :"+add(x,y));
		System.out.println("sum recursive :"+addRecur(x, y));
	}

	public static int add(int x, int y){
		while(y!=0){
			
			int carry = x&y;
			x = x^y;
			y = carry << 1;
		}
		return x;
	}
	
	public static int addRecur(int x, int y){
		if(y==0)
			return x;
		return addRecur(x^y, (x&y)<<1);
	}
}
