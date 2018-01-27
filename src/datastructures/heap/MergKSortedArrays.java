package datastructures.heap;

/**
 * Merge K sorted arrays.
 * Create an empty array of size n*k.
 * Create a min-heap of size k.
 * From each of k sorted arrays put the first element to the heap.
 * For n*k times, extract the root element from the heap and put it the output array.
 * Replace the root with the next element from the array to which it belonged.
 * If the array is empty, replace the root with infinity and heapify the heap.
 * At the end we get the output array as the result.
 * 
 * @author joyghosh
 *
 */
public class MergKSortedArrays {
	
	public static final int K = 3;
	public static final int N = 4;
	
	public static void main(String[] args) {
	}
	
//	//Min heap node.
//	class Node{
//		int data;	//data component.
//		int i; 		//index of the array from which the element is picked.
//		int j;		//index of the next element to be picked.
//	}
//	
//	class MinHeap{
//		Node[] heap;
//		int size;
//		
//		public MinHeap(Node[] arr, int size, int[][] arr){
//			this.size = size;
//			this.heap = arr;
//		}
//		
//		public int extractMin(){
//			int data = heap[0].data; //always the root element
//			--size;
//			if(size != 0){
//				if(heap[0].j < N){
//					
//				}
//			}
//		}
//		
//		public void minHeapify(int r){
//			
//		}
//		
//		public void replaceMin(int x){
//			heap[0].data = x;
//			minHeapify(0);
//		}
//	}
	
	public void heapify(int[] heap, int i, int heapSize){
		
		int smallest = i;
		int left = 2*i+1;
		int right = 2*i+2;
		
		if(left<heapSize && heap[i] < heap[left]){
			smallest = left;
		}
		
		if(right<heapSize && heap[i] < heap[right]){
			smallest = right;
		}
		
		if(smallest!=i){
			int tmp = heap[i];
			heap[i] = heap[smallest];
			heap[smallest] = tmp;
			
			heapify(heap, smallest, heapSize);
		}
	}
	
	public void buildHeap(int[] arr){
		int n = arr.length;
		
		for(int i=n/2-1; i>=0; i--){
			heapify(arr, i, n);
		}
	}
}
