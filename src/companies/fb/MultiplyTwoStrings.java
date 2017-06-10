package companies.fb;

import java.util.Scanner;

public class MultiplyTwoStrings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter num1: ");
		String num1 = sc.nextLine();
		System.out.print("Enter num2: ");
		String num2 = sc.nextLine();
		System.out.printf("Product of %s and %s is %s",num1, num2, product(num1, num2, 10));
		sc.close();
	}
	
	//Long multiplication method.
	//Assuming base 10.
	private static String product(String a, String b, int base){
		if(a==null || b==null) return null;
		
		char[] product = new char[a.length() + b.length()];
		
		for(int i=0; i<b.length(); ++i){
			int carry = 0;
			for(int j=0; j<a.length(); ++j){
				product[i+j] += carry + Character.getNumericValue(b.charAt(i)) * Character.getNumericValue(a.charAt(j));
				carry = product[i+j]/base;
				product[i+j] += product[i+j]%base;
			}
			product[i+a.length()] += carry;
		}
		
		System.out.println(product);
		return new String(product);
	}
}
