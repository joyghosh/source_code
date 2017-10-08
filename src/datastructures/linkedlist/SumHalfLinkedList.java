package datastructures.linkedlist;

import common.Node;

/**
 * Given a Singly Linked list, Update the second half of the list such that n-th element becomes sum(1st + nth) 
 * element, (n-1)st element becomes sum(2nd + n-1st) element and so on. 
 * Eg: 2->3->4->5->6 => 2->3->(4+4)->(5+3)->(6+2)
 * 
 * @author joyghosh
 *
 */
public class SumHalfLinkedList {

	public static void main(String[] args) {
		Node head = new Node(2);
		head.next = new Node(3);
		head.next.next = new Node(4);
		head.next.next.next = new Node(5);
		head.next.next.next.next = new Node(6);
		sumHalfLinkedList(head);
		display(head);
	}
	
	private static void display(Node head){
		Node n = head;
		while(n!=null){
			System.out.printf("%d ", n.data);
			n = n.next;
		}
	}
	
	private static void sumHalfLinkedList(Node head){
		int len = length(head);
		if(len == 0) return;
		
		int N = (len%2==0)? len/2: len/2+1;
		int[] values = new int[N];
		Node n = head;
		Node prev = null;
				
		//Cache the values of the first half of the linked list.
		for(int i=0;i<N;i++){
			values[i] = n.data;
			prev = n;
			n = n.next;
		}
		
		//Manipulate the sum for the rest half.
		int i = N-1;
		n = prev;
		while(n!=null){
			n.data = n.data + values[i];
			i = i-1;
			n = n.next;
		}
	}
	
	private static int length(Node head){	
		if(head == null) return 0;
	
		Node n = head;
		int len = 0;
		
		while(n!=null){
			++len;
			n = n.next;
		}
		
		return len;
	}
}
