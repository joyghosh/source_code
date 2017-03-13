//package datastructures.heap;
//
//public class MergKSortedArrays {
//	
//	public static final int K = 3;
//	public static final int N = 4;
//	
//	public static void main(String[] args) {
//	}
//	
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
//}
