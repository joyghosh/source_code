package companies.problem_solving;

public class GoldMiner {

	public static void main(String[] args) {
		int[][] matrix = {{1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}};
		
		int M = matrix.length;
		int N = matrix[0].length;
		System.out.println(maxGoldValue(matrix, M, N));
	}
	
	//Get the max gold value.
	private static int maxGoldValue(int[][] matrix, int M, int N){
		//Empty matrix.
		if(M==0 || N==0) return 0;
		
		//For single row matrix.
		if(M==1){
			int max = Integer.MIN_VALUE;
			for(int i=0;i<N;i++){
				if(matrix[0][i] > max) max = matrix[0][i];
			}
			return max;
		}
		
		//For single column matrix.
		if(N==1){
			int max = Integer.MIN_VALUE;
			for(int i=0;i<M;i++){
				if(matrix[i][0] > max) max = matrix[i][0];
			}
			return max;
		}
		
		//Find the start cell with max. value.
		int max = Integer.MIN_VALUE;
		int startRow = 0;
		for(int i=0; i<M; i++){
			if(matrix[i][0] > max){
				max = matrix[i][0];
				startRow = i;
			}
		}
		
		System.out.printf("Start cell (%d, %d)\n",startRow, 0);
		
		//For the rest of the cases.
		return maxGoldValueUtil(matrix, M, N, startRow, 0);
	}
	
	//Utility for obtaining the max gold value.
	private static int maxGoldValueUtil(int[][] matrix, int M, int N, int row, int col){
		if(col==N-1) return matrix[row][col];
		
		//First row
		if(row == 0){
			return matrix[row][col] + Math.max(maxGoldValueUtil(matrix, M, N, row, col+1), 
					maxGoldValueUtil(matrix, M, N, row+1, col+1));
		}
		
		//Last row
		if(row == M-1){
			return matrix[row][col] + Math.max(maxGoldValueUtil(matrix, M, N, row, col+1), 
					maxGoldValueUtil(matrix, M, N, row-1, col+1));
		}
		
		return matrix[row][col] + Math.max(maxGoldValueUtil(matrix, M, N, row-1, col+1), 
									Math.max(maxGoldValueUtil(matrix, M, N, row, col+1), 
										maxGoldValueUtil(matrix, M, N, row+1, col+1)));
	}
}	
