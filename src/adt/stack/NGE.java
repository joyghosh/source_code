package adt.stack;

import java.util.Stack;

public class NGE {
	
	private static void nextGreaterElement(int[] arr){
        
	        int next;
	        for(int i = 0;i<arr.length;i++){
	            
	        	next = -1;
	        	for(int j=i+1;j<arr.length;j++){
	                if(arr[j] > arr[i]){
	                    next = arr[j];
	                    break;
	                }
	            }
	            System.out.println(arr[i]+":"+next);
	        }
	}
	
	private static void nextGreaterElementStack(int[] arr){
		int n = arr.length;
		if(n==0) return;
		
		if(n==1){
			System.out.println(arr[0]+" -> -1");
			return;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(arr[0]);
		
		int next = -1;
		int i= 1;
		
		while(i<n){
			next = arr[i];
			while(!stack.isEmpty() && stack.peek() < next){
				System.out.println(stack.pop()+" -> "+next);
			}
			
			stack.push(next); i++;
			
			//Check if we have reached the end array.
//			if(i==n){
//				System.out.println(stack.pop()+" -> -1");
//			}
		}
		
		while(!stack.isEmpty()){
			System.out.println(stack.pop()+" -> -1");
		}
	}
	
	 

		public static void main(String[] args){
		
//		    int[] arr = {13,12,11,8};
//		    int[] arr = {4, 5, 2, 25};
			int[] arr = {13, 7, 6, 12};
//		    nextGreaterElement(arr);
		    nextGreaterElementStack(arr);
		}
}
