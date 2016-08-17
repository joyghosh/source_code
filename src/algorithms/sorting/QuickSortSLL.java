package algorithms.sorting;

/**
 * QuickSort on Singly Linked List.
 * 
 * @author Joy Ghosh
 *
 */
//public class QuickSortSLL {
//
//	class Node{
//		int data;
//		Node next;
//		
//		public Node(int data){
//			this.data = data;
//		}
//	}
//	
//	public static Node getTail(Node root){
//		while(root!=null && root.next!=null)
//			root = root.next;
//		return root;
//	}
//	
//	public static void quickSort(Node root){
//		Node tail = getTail(root);
//		quickSortRecur(root, tail);
//	}
//	
//	public static Node quickSortRecur(Node head, Node end){
//		//base case.
//		if(head == end)
//			return head;
//		
//		Node new_head = null;
//		Node new_end = null;
//		
//		Node pivot = partition();
//		
//		// If pivot is the smallest element - no need to recur for
//	    // the left part.
//		if(new_head!=pivot){
//			
//			//Set the node before the pivot node as NULL.
//			Node tmp = new_head;
//			while(tmp.next != pivot){
//				tmp = tmp.next;
//			}
//			tmp.next = null;
//			
//			//recur for the list before pivot.
//			new_head = quickSortRecur(new_head, tmp);
//			
//			// Change next of last node of the left half to pivot
//			tmp = getTail(new_head);
//			tmp.next = pivot;
//		}
//		
//		// Recur for the list after the pivot element.
//		pivot.next = quickSortRecur(pivot.next, new_end);
//		return new_head;
//	}
//	
////	public static Node partition(Node head, Node end, Node new_head, Node new_end){
////		Node pivot = end;
////		Node prev = null;
////		Node curr = head;
////		Node tail = pivot;
////		
////	    // During partition, both the head and end of the list might change
////	    // which is updated in the newHead and newEnd variables.
////		while(curr!=pivot){
////			
////		}
////	}
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
