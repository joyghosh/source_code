package datastructures.linkedlist;

/**
 * <p> 
 * Clone a double linked list having next pointer and an 
 * arbitrary pointer.	
 * </p>
 * @author Joy Ghosh
 * @version 1.0
 */
public class CloneArbitraryDLL {

	public static void main(String[] args) {
		
	}
	
	/**
	 * Time-complexity:  O(n)
	 * Auxiliary space complexity: O(n).
	 * @return duplicate of the original linked list.
	 */
//	private static Node duplicateLLMethod1(Node head){
//		
//		//(1) create all nodes of the copy linked list from the original list.
//		Node copy_head, store_head;
//		Node copy_ref, head_ref, store_ref;
//		
//		head_ref = head;
//		copy_head = copy_ref = new Node(head_ref.data);
//		
//		while(head_ref!=null){
//			copy_ref.next = new Node(head_ref.next.data);
//			
//		}
//	}
}

/**
 * Node of a double linked list.
 * @author Joy Ghosh
 *
 */
class Node{
	
	int data;
	Node next;
	Node arbit;
	
	public Node(int data) {
		this.data = data;
	}
}