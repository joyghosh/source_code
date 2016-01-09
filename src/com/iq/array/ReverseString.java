package com.iq.array;

public class ReverseString {

//	private static void print(char[] string){
//		for(int i=0;i<string.length;i++)
//			System.out.print(string[i]);
//		System.out.println();
//	}
	
	public static void main(String[] args) {
	
		char[] string =  {'a','b','c','d','e','f','g','h'};
		System.out.println(string);
		
		int i = 0; int j = string.length - 1;
		while(i<=j){
			char temp = string[i];
			string[i] = string[j];
			string[j] = temp;
			++i;
			--j;
		}
		
		System.out.println(string);
	}
}

////reverse a String.
//public class ReverseString{
//  
//  //iterative approach.
//  private static String reverse(String s){
//      StringBuilder tmp = new StringBuilder(s);
//      int start = 0;
//      int end = s.length()-1;
//      
//      while(start<=end){
//         char t  = tmp.charAt(start);
//         tmp = tmp.insert(start, tmp.charAt(end));
//         tmp = tmp.insert(end, t);
//         
//         start++; end--;
//      }
//      
//      //return the string representation.
//      return tmp.toString();
//  }
//  
//  public static void main(String[] args){
//      
//          String s = "some string";
//          System.out.println("original string: "+s);
//          System.out.println("reverse of the string: "+reverse(s));
//  }
//}