package datastructures.matrix;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class BooleanMatrix {

	public static void main(String[] args) {
//		int mat[ ][ ] = { {1, 0, 0, 1},
//						  {0, 0, 1, 0},
//						  {0, 0, 0, 0},};
//		int[][] result = modifyMatrix(mat);
//		
//		for(int i=0; i<mat.length; i++){
//			for(int j=0; j<mat[0].length; j++){
//				System.out.print(result[i][j]);
//			}
//			System.out.println();
//		}
		
		Collection<String> c = new HashSet<>();
		c.add("Joy");
		c.add("Ghosh");
		c.add("Ghosh");
		c.add("Ghosh");
		c.add("Ghosh");
		
		for(String s:c){
			System.out.println(s);
		}
	}

	public static int[][] modifyMatrix(int[][] matrix){
		int R = matrix.length;
		if(R == 0) return null;
		int C = matrix[0].length;
		
		int row[] = new int[R];
		int col[] = new int[C];
		int i, j;
		
		for(i=0; i<R; i++){
			for(j=0; j<C; j++){
				if(matrix[i][j] == 1){
					row[i] = 1;
					col[j] = 1;
				}
			}
		}
		
		for(i=0; i<R; i++){
			for(j=0; j<C; j++){
				if(row[i] == 1 || col[j] == 1){
					matrix[i][j] = 1;
				}
			}
		}
		
		return matrix;
	}
}
