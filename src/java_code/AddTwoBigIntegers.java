package java_code;

import java.math.BigInteger;

public class AddTwoBigIntegers {

	public static void main(String[] args) {
		System.out.println(add("671251237512367523","84639364634647636736"));
		System.out.println(add("3","8"));
	}
	
	public static String add(String n1, String n2){
		BigInteger a = new BigInteger(n1);
		BigInteger b = new BigInteger(n2);
		
		BigInteger result = a.add(b);
		return result.toString();
	}
}
