package companies.oracle;

public class PositiveNegative{
    
	   public static int[] rearrange(int[] arr){
	        
	        int i, j;
	        i = 0; j = arr.length - 1;
	        
	        while(i<j){  
	            if(arr[i] < 0 && arr[j]>=0){
	                int tmp = arr[i];
	                arr[i++] = arr[j];
	                arr[j--] = tmp;
	            }
	            
	            if(arr[i] >=0){
	                i++;
	            }
	            
	            if(arr[j] < 0){
	                j--;
	            }
	        }
	        
	        return arr;
	   }
	   
	   public static void main(String[] args){
	       
	       int[] arr = {3,4,-1,3,6,-10,-2,4,61};
	       int[] a = rearrange(arr);
	       for(int i=0;i<a.length;i++)
	           System.out.print(a[i]+" ");
	   }
	}