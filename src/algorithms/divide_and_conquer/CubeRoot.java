package algorithms.divide_and_conquer;

public class CubeRoot {

	public static void main(String[] args) {
		float n = 3;
		System.out.printf("Cube root of %f: %f \n", n, cubeRoot(n));
	}
	
	public static float cubeRoot(float n){
		float e = 0.0000001f;
		
		float start = 0; float end = n;
		while(true){
			float mid = (start+end)/2;
			float cube = mid*mid*mid;
			
			if(Math.abs(cube-n) <= e){
				return mid;
			}
			
			if(cube > n){
				end = cube;
			}else{
				start = cube;
			}
		}
	}
}
