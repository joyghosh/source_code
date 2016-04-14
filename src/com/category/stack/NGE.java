package com.category.stack;

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

		public static void main(String[] args){
		
		    int[] arr = {13,12,11,8};
		    nextGreaterElement(arr);
		}
}
