package com.ds.matrix;

public class CommonElement{ 
    
    public static void main(String[] args){
            
            int[][] arr = { {1, 2, 3, 4, 5},
                            {2, 4, 5, 8, 10},
                            {3, 5, 7, 9, 11},
                            {1, 3, 5, 7, 9} };
            System.out.println("Common element in row-wise sorted matrix is: "+findCommonBinary(arr));
    }
    
    private static int findCommon(int[][] arr){
        
            int rows = arr.length;
            int cols = arr[0].length;
            int common = Integer.MIN_VALUE;
            
            for(int i=0;i<cols;i++){
                for(int j=1;j<rows;j++){
                    boolean present = false;
                    for(int k=0;k<cols;k++){
                        if(arr[j][k] == arr[0][i]){
                            present = true;
                            common = arr[0][i];
                            break;
                        }
                    }
                    if(!present)
                        break;
                }
            }
            
            return common;
    }
    
    private static int findCommonBinary(int[][] arr){
    	
    	 int rows = arr.length;
         int cols = arr[0].length;
         int common = Integer.MIN_VALUE;
         
         for(int i=0;i<cols;i++){
        	 for(int j=1;j<rows;j++){
        		 if(binarySearch(arr, j, 0, cols, arr[0][i])!=-1){
        			 common = arr[0][i];
        		 }else{
        			 break;
        		 }
        	 }
         }
         
         return common;
    }
    
    private static int findCommonLastCol(int[][] arr){
    	return -1;
    }
    
    private static int binarySearch(int[][] arr, int row, int low, int high, int key){
    	
    	int mid = -1;
    	if(low < high){
    		mid = low + ((high - low)/2);
    		if(arr[row][mid] == key)
    			return mid;
    		else if(arr[row][mid] > key)
    			return binarySearch(arr, row, low, mid, key);
    		else return binarySearch(arr, row, mid+1, high, key);
    	}
    	
    	return mid;
    }
}
