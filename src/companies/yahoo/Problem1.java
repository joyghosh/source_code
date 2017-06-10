package companies.yahoo;

import java.util.Scanner;

/**
 * Similar mobile phone problem.
 * @author joyghosh
 * 
 */
public class Problem1 {
	
	private static final float ALPHA = 1;
	private static final float BETA = 1.5f;
	private static final float GAMMA = 2.0f;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Point[][] dimensions = new Point[9][9];
		
		System.out.println("Enter the cost and the features");
	}

	private static double distance(Point p1, Point p2){
		return Math.sqrt((p1.x*p1.x - p2.x*p2.x) + (p1.y*p1.y - p2.y*p2.y));
	}
}
