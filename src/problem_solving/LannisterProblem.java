package problem_solving;

import java.util.*;

public class LannisterProblem {
	
	    public static void main(String args[] ) throws Exception {
	        /*
	         * Read input from stdin and provide input before running
	         * Use either of these methods for input
	        */


	        //Scanner
	        Scanner s = new Scanner(System.in);
	        int T = s.nextInt();
	        int n = s.nextInt();
	        int m = s.nextInt();
	        
	        for(int t=0; t<T; t++){
	            int[] lann = new int[n];
	            
	            for(int i=0; i<n; i++){
	                lann[i] = s.nextInt();
	            }
	            
	            int[] result = new int[n];
	            result = lannisterProblem(lann, n, m);
	            for(int r:result){
	                System.out.printf("%d ",r);
	            }
	            System.out.println();
	        }
	        s.close();
	    }
	    
	    private static int[] lannisterProblem(int[] lann, int n, int m){
	        int[] result = new int[n];
	        
	        for(int i=0; i<m; i++){
	        	Arrays.fill(result, 0);
	            for(int j=0; j<n; j++){
	                if(j==0 && lann[j+1]==1){
	                    result[j] = 1;
	                }else if(j==n-1 && lann[j-1]==1){
	                    result[j] = 1;
	                }else if(j>0 && j<=n-1){
	                	if(lann[j-1]==1 && lann[j+1]==1){
	                		result[j] = 1;
	                	}
	                }
	            }
	            
	            //Copy result to previous or lann array and reset result array.
	            lann = Arrays.copyOf(result, result.length);
	        }
	        
	        return result;
	    }
}
