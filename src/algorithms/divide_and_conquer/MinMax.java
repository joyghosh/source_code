package algorithms.divide_and_conquer;

public class MinMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static Pair tournament(int[] arr, int size){
		
		Pair p = new Pair();
		if(size == 1){
			p.min = p.max = arr[0];
			return p;
		}
		return null;
	}
	
}

class Pair{
	int min;
	int max;
}
