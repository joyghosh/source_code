package datastructures.matrix;

/**
 * Given an n x n square matrix, find sum of all sub-squares of size k x k
 * Given an n x n square matrix, find sum of all sub-squares of size k x k where k is smaller than or equal to n. 
 * @author Joy Ghosh
 *
 */
public class SumOfAllKSubSquares {

	public static void main(String[] args) {
		int[][] mat = {{1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2},
                {3, 3, 3, 3, 3},
                {4, 4, 4, 4, 4},
                {5, 5, 5, 5, 5},
               };
		int k = 3;
		sumOfAllKSubSquares(mat, k);
	}
	
	public static void sumOfAllKSubSquares(int[][] arr, int k){
		int[][] sums = new int[k][k];
		
		int N = arr.length;
		for(int i=0; i<N-k+1; i++){
			for(int j=0; j<N-k+1; j++){
				int sum = 0;
				for(int p=i; p<i+k; p++){
					for(int q=j; q<j+k; q++){
						sum += arr[p][q];
					}
				}
				System.out.print(sum+" ");
			}
			System.out.println();
		}
	}
}
