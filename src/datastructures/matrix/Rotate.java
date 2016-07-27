package datastructures.matrix;

public class Rotate {
	
	/**
	 * Rotate a matrix by 90 degrees.
	 * Time-complexity: O(N*M) = O(N^2)
	 * Space-complexity: O(N*M)
	 * @param arr
	 * @return
	 */
    public static int[][] rotateMatrix(int[][] arr){
        int M = arr.length;
        int N = arr[0].length;
        int[][] buffer = new int[N][M];
        
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                buffer[j][M-1-i] = arr[i][j];
            }
        }    
        return buffer;
    }
    
    public static void main(String[] args){
        int[][] arr = {{1,2,3,4},
                       {5,6,7,8},
                       {9,10,11,12}};
        int[][] result = rotateMatrix(arr);
        
        System.out.println("Rotated matrix is:");
        for(int i=0;i<arr[0].length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}
