package companies.adobe;

import java.util.Scanner;

public class StringRotation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the first string (str1): ");
		String str1 = sc.nextLine();
		System.out.print("Enter the second string (str2): ");
		String str2 = sc.nextLine();
		if(isRotation(str1, str2)){
			System.out.println("str1 is rotation of str2.");
		}else{
			System.out.println("str1 is not a rotation of str2");
		}
		
		sc.close();
	}
	
	private static boolean isRotation(String str1, String str2){
		if(str1 == null || str2 == null) return false;
		if(str1.length() != str2.length()) return false;
		
		String tmp = str1.concat(str1);
		if(tmp.contains(str2)){
			return true;
		}
		
		return false;
	}
}
