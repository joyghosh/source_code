package datastructures.bst;

import java.util.LinkedList;
import java.util.Queue;

public class ArrayIsBST {

	public static void main(String[] args) {
		int[] arr = {7, 4, 12, 3, 6, 8, 1, 5, 10};
		System.out.println(checkIfLotOfArrayIsBST(arr));
	}
	
	public static boolean checkIfLotOfArrayIsBST(int[] arr){
		int n = arr.length;
		if(n == 0) return true;
		
		Queue<NodeDetails> q = new LinkedList<>();
		int i = 0;
		NodeDetails node = new NodeDetails();
		node.data = arr[i++];
		node.min = Integer.MIN_VALUE;
		node.max = Integer.MAX_VALUE;
		q.add(node);
		
		while(i!=n && !q.isEmpty()){
			NodeDetails nd = q.poll();
			
			if(i<n && arr[i] < nd.data && arr[i] > nd.min){
				NodeDetails newnd = new NodeDetails();
				newnd.data = arr[i++];
				newnd.min = nd.min;
				newnd.max = nd.data;
				q.add(newnd);
			}
			
			if(i<n && arr[i] > nd.data && arr[i] < nd.max){
				NodeDetails newnd = new NodeDetails();
				newnd.data = arr[i++];
				newnd.min = nd.data;
				newnd.max = nd.max;
				q.add(newnd);
			}
		}
		
		if(i == n) return true;
		return false;
	}
	
	public static class NodeDetails{
		public int data;
		public int min;
		public int max;
	}
	
//	public static boolean isPreOrderBst(int[] pre){
//		int n = pre.length;
//		if(n == 0) return true;
//			
//	}
	
//	private static boolean isPreOrderBstUtil(int[] pre, int i, int j){
//		if(i == j) return true;
//		
//		int nge = pre[i];
//		for(int k=i+1; k<=j; k++){
//			if(pre[k] > pre[i]){
//				nge = k;
//			}
//		}
//	}
}
