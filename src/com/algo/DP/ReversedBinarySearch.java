package com.algo.DP;

public class ReversedBinarySearch {

	private static int findElement(int[] arr, int low, int high, int search){
        
        if(low < high){
            int mid = (high+low)/2;
            if(arr[mid] == search)
                return mid;
            else if(arr[mid] < search){
                return findElement(arr, low, mid-1,search);
            }else{
                return findElement(arr,mid+1, high,search);
            }
        }
        
        return -1;
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr = {10,7,6,3,1};
        
        System.out.println("index of 3 is :"+findElement(arr,0,arr.length-1,7));
	}

}
