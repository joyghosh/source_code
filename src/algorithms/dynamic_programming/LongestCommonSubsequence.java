package algorithms.dynamic_programming;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "AGGTAB";
		String str2 = "GXTXAYB";
		int m = str1.length();
		int n = str2.length();
		
//		System.out.println("longest common subsequence: "+longestCommonSubsequence(str1, str2, m, n));
		System.out.println("longest common subsequence: "+lcsDP(str1, str2, m, n));
	}
	
	/**
	 * [Simple recursive approach.]
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static int longestCommonSubsequence(String str1, String str2, int m, int n){
		if(m == 0 || n == 0)
			return 0;
		
		if(str1 == null || str2 == null)
			return 0;
		
		if(str1.charAt(m-1) == str2.charAt(n-1)){
			return (1 + longestCommonSubsequence(str1, str2, m-1, n-1));
		}else{
			return Math.max(longestCommonSubsequence(str1, str2, m-1, n), 
							longestCommonSubsequence(str1, str2, m, n-1));
		}
	}
	
	/**
	 * Dynamic Programming approach.
	 * Tabulation method.
	 * 
	 * TC: O(n^2)
	 * SC: O(m*n)
	 * 
	 * @param str1
	 * @param str2
	 * @param m
	 * @param n
	 * @return
	 */
	public static int lcsDP(String str1, String str2, int m, int n){
		if(m==0 || n==0)
			return 0;
		
		int[][] LCS = new int[m+1][n+1];
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(i==0 || j==0){
					LCS[i][j] = 0;
				}else if(str1.charAt(i-1) == str2.charAt(j-1)){
					LCS[i][j] = 1 + LCS[i-1][j-1];
				}else{
					LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
				}
			}
		}
		
		return LCS[m][n];
	}
}
