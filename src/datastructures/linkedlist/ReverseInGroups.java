package datastructures.linkedlist;

/**
 * Reverse a Linked List in groups of given size.
 * @author Joy Ghosh
 *
 */
public class ReverseInGroups {

	public static void main(String[] args) {
		ReverseInGroups rig = new ReverseInGroups();
		ReverseInGroups.Node head = rig.new Node(1);
		head.next = rig.new Node(2);
		head.next.next = rig.new Node(3);
		head.next.next.next = rig.new Node(4);
		head.next.next.next.next = rig.new Node(5);
		
		printList(head);
		head = reverseInGroup(head, 2);
		printList(head);
	}

	/**
	 * [recursive reverse in groups of k]
	 * T.C. = O(n)
	 * S.C. = O(n)
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public static Node reverseInGroup(Node head, int k){
		Node current = head;
		Node prev, next;
		prev = next = null;
		
		int count = 0;
		//reverse the next k nodes of the linked list.
		while(count < k && current!=null){
			next = current.next;  //caching the next.
			current.next = prev;  //reversing the node link.
			prev = current;		  //current becomes the next previous.
			current = next;       //current next becomes the next current.
			count++;
		}
		
		//next now points to (k+1)th node of the linked list.
		//recursively call for reverse starting from the next 
		//and link it to the next of the head.
		if(next!=null){
			head.next = reverseInGroup(next, k);
		}
		
		//prev is the new head of the input list.
		return prev;
	}
	
	public static void printList(Node head){
		if(head == null) return;
		
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
