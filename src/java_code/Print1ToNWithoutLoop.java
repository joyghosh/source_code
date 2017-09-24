package java_code;

import java.util.Scanner;

import jdk.nashorn.internal.ir.ContinueNode;

public class Print1ToNWithoutLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		printNos(N);
		//printNosGoto(N);
		s.close();
	}
	
	//Using recursion.
	public static void printNos(int n){
		if(n==0) return;
		printNos(n-1);
		System.out.printf("% d", n);
	}
	
//	public static void printNosGoto(int n){
//		int i = 1;
//		printBlock:{
//			if(i>n) break printBlock;
//			System.out.printf("%d ", i++);
//			continue printBlock;
//		}
//	}
}
