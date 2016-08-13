package algorithms.dynamic_programming;

/**
 * Given two strings str1 and str2 and below operations that can performed on str1.
 * Find minimum number of edits (operations) required to convert ‘str1′ into ‘str2′.
 *  Insert
 *  Remove
 *  Replace
 *  All of the above operations are of equal cost.
 * 
 * @author Joy Ghosh
 *
 */
public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "sunday";
		String str2 = "saturday";
		int m = str1.length();
		int n = str2.length();
		System.out.println("Min. number of edits: "+editDistance(str1, str2, m, n));
		System.out.println("Min. number of edits: "+editDistanceDP(str1, str2, m, n));
	}
	
	public static int min(int x, int y, int z){
		if(x<y && x<z) return x;
		if(y<x && y<z) return y;
		else return z;
	}
	
	/**
	 * [recursive approach.]
	 * T.C: O(3^m)
	 * 
	 * @param str1
	 * @param str2
	 * @param m
	 * @param n
	 * @return
	 */
	public static int editDistance(String str1, String str2, int m, int n){
		// If first string is empty, the only option is to
	    // insert all characters of second string into first
		if(m==0) return n;
		
		// If second string is empty, the only option is to
	    // remove all characters of first string
		if(n==0) return m;
		
		// If last characters of two strings are same, nothing
	    // much to do. Ignore last characters and get count for
	    // remaining strings.
		if(str1.charAt(m-1) == str2.charAt(n-1)){
			return editDistance(str1, str2, m-1, n-1);
		}
		
	    // If last characters are not same, consider all three
	    // operations on last character of first string, recursively
	    // compute minimum cost for all three operations and take
	    // minimum of three values.
		return 1 + min(editDistance(str1, str2, m, n-1),		//Insert a new character.
						editDistance(str1, str2, m-1, n),		//Remove a character.
						editDistance(str1, str2, m-1, n-1));	//Replace or substitute a character.
	}
	
	/**
	 * [Dynamic programming approach]
	 * T.C: O(m*n)
	 * S.C:O(m*n)
	 * 
	 * @param str1
	 * @param str2
	 * @param m
	 * @param n
	 * @return
	 */
	public static int editDistanceDP(String str1, String str2, int m, int n){
		// Create a table to store results of subproblems
		int[][] ed = new int[m+1][n+1];
		
		// Fill ed[][] in bottom up manner
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				// If first string is empty, only option is to
                // insert all characters of second string
				if(i==0){
					ed[i][j] = j;	// Min. operations = j
				}else if(j==0){	                
					// If second string is empty, only option is to
	                // remove all characters of first string
					ed[i][j] = i;		// Min. operations = i
				}else if(str1.charAt(i-1) == str2.charAt(j-1)){
	                // If last characters are same, ignore last char
	                // and recur for remaining string
					ed[i][j] = ed[i-1][j-1];
				}else{
					// If last character are different, consider all
	                // possibilities and find minimum
					ed[i][j] = 1 + min(ed[i][j-1],		// Insert
									ed[i-1][j],		// Remove
									ed[i-1][j-1]);  // Replace
				}
			}
		}
		
		return ed[m][n];
	}
}
