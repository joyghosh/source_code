package algorithms.dynamic_programming;

/**
 * Count number of ways to reach a given score in a game
 * 
 * @author joyghosh
 *
 */
public class CountWaysToScore {

	public static void main(String[] args) {
		int score = 20;
		int[] points = {3, 5, 10};
		System.out.println("Ways to score: "+countWaysToScore(score, points));
	}
	
	public static int countWaysToScore(int score, int[] points){
		int n = points.length;
		if(n == 0 || score <=0){ 
			return 0;
		}
		return countWaysToScoreUtil(score, points, n);
	}
	
	public static int countWaysToScoreUtil(int score, int[] points, int m){
		if(score == 0) return 1;
		if(score < 0) return 0;
		if(m<=0 && score>0) return 0;
		
		return countWaysToScoreUtil(score, points, m-1) + countWaysToScoreUtil(score - points[m-1], points, m);
	}
	
//	public static int countWaysToScoreDP(int score, int[] points){
//		int n = points.length;
//	}
}
