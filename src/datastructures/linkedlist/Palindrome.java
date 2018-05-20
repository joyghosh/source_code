package datastructures.linkedlist;

public class Palindrome {

	public static void main(String[] args) {
		
	}

	private static Node findMiddle(Node head){
		Node slow = head;
		Node fast = head;
		Node prevToSlow = head;
		Node midNode = null;
		
		if(head!=null && head.next!=null){
			while(fast!=null && fast.next!=null){
				fast = fast.next.next;
				prevToSlow = slow;
				slow = slow.next;
			}
			
			if(fast!=null){
				midNode = slow;
				slow = slow.next;
			}
		}
		return slow;
	}
	
	
}
