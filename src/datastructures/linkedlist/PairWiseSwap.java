package datastructures.linkedlist;

public class PairWiseSwap {
	
	public static void main (String[] args) throws java.lang.Exception
	{
		PairWiseSwap pws = new PairWiseSwap();
		PairWiseSwap.Node head = pws.new Node(1);
		head.next = pws.new Node(2);
		head.next.next = pws.new Node(3);
		head.next.next.next = pws.new Node(4);
		head.next.next.next.next = pws.new Node(5);
		head.next.next.next.next.next = pws.new Node(6);
		head.next.next.next.next.next.next = null;
		
		printLinkedList(head);
		pairWiseSwapRecursive(head);
		printLinkedList(head);
	}
	
	/**
	 * [Iterative]
	 * T.C = O(n)
	 * 
	 * @param head
	 */
	public static void pairWiseSwap(Node head){
		if(head == null)
			return;
		
		Node temp = head;
		while(temp!=null && temp.next!=null){
			int k = temp.data;
			temp.data = temp.next.data;
			temp.next.data = k;
			temp = temp.next.next;
		}
	}
	
	/**
	 * [Recursive]
	 * T.C. = O(n)
	 * S.C. = O(n) Calling recursion stack. 
	 *  
	 * @param head
	 */
	public static void pairWiseSwapRecursive(Node head){
		if(head == null) return;
		
		if(head !=null && head.next!= null){
			int k = head.data;
			head.data = head.next.data;
			head.next.data = k;
			
			pairWiseSwapRecursive(head.next.next);
		}
	}
	
	public static void printLinkedList(Node head){
		if(head == null)
			return;
			
		while(head!=null){
			System.out.printf("%d ",head.data);
			head = head.next;
		}
		
		System.out.println();
	}
	
	class Node{
		int data;
	    Node next;
	    
	    public Node(int data){
	    	this.data = data;
	    }
	}
}