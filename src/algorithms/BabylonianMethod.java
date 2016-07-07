package algorithms;

/**
 * Babylonian method to find the square root.
 * @author Joy Ghosh
 *
 */
public class BabylonianMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(squareRoot(9.0f));
	}

	/**
	 * Finds the square root of n.
	 * @param n
	 * @return
	 */
	private static float squareRoot(float n){
		
		float x = n;			//Choose arbitrary value for x, in this case we select n itself.
		float y = 1;			//Initialize y as 1.
		float e = 0.00000001f; 	//accuracy level.
		
		while((x-y)>e){
			x  = (x+y)/2;		//next approx. for x. Average of x and y.
			y = n/x;
		}
		
		return x;
	}
}
