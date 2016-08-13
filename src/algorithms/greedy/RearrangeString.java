package algorithms.greedy;

/**
 * 
 * @author Joy Ghosh
 *
 */
public class RearrangeString {

	public static void main(String[] args) {
		
	}
	
	public static void buildHeap(char[] arr){
		for(int i=arr.length/2-1; i>=0; i--){
			heapify(arr, i);
		}
	}
	
	public static void heapify(char[] arr, int i){
		int largest = i;
		int left = 2*i + 1;
		int right = 2*i + 2;
		
		if(arr[largest] < arr[left]){
			largest = left;
		}
		
		if(arr[largest] < arr[right]){
			largest = right;
		}
		
		if(largest != i){
			swap(arr, i, largest);
			heapify(arr, largest);
		}
	}
	
	public static void swap(char[] arr, int i, int j){
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	class Node implements Comparable<Node>{

		char c;
		int frequency;
		
		public Node(char c){
			
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
}
