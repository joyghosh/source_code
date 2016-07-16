package datastructures.linkedlist;

public class SumOfLinkedLists {

	//Node class
	class Node{
			int data;
			Node next;
			
			public Node(int data){
				this.data = data;
			}
	}
	
	public static void main(String[] args) {
		SumOfLinkedLists soll = new SumOfLinkedLists();
		
		SumOfLinkedLists.Node first = soll.new Node(7); 
		first.next = soll.new Node(5); first.next.next = soll.new Node(9);
		first.next.next.next = soll.new Node(4); first.next.next.next.next = soll.new Node(6);
		
		SumOfLinkedLists.Node second = soll.new Node(8);
		second.next = soll.new Node(4);
		
		SumOfLinkedLists.Node result = soll.sumOfLinkedListsRecurWrapper(first, second);
		soll.printList(result);
		
//		SumOfLinkedLists.Node result = soll.sumLinkedList(first, second);
//		
//		soll.printList(result);
//		soll.printRecursive(result);
	}
	
	/**
	 * Time-complexity: O(n), n being the max of the two lists.
	 * Space-complexity: O(n)
	 * @param first
	 * @param second
	 * @return
	 */
	private Node sumLinkedList(Node first, Node second){
		Node result = null;
		Node temp = null;
		Node prev = null;
		
		int carry = 0; int sum = 0;
		while(first!=null || second!=null){
			
			//calculate sum.
			sum = carry + (first!=null? first.data:0) + (second!=null? second.data:0);
			
			//update the carry value.
			carry = (sum>=10)?1:0;
			
			//Update the sum which will be part of result.
			sum = sum%10;
			
			//Create the node for the sum.
			temp = new Node(sum);
			
			//Check if this the first node of the result or else connect it to the rest.
			if(result == null){
				result = temp;
			}else{
				prev.next = temp;
			}
			
			//Update the prev reference for the next iteration.
			prev = temp;
			
			//Move across the first and the second lists.
			if(first!=null){
				first = first.next;
			}
			
			if(second!=null){
				second = second.next;
			}
		}
		
		//Check if there's a carry forward.
		if(carry>0){
			temp.next = new Node(carry);
		}
		
		return result;
	}
	
	/**
	 * Sum of linked-list using space efficient recursive method wrapper. 
	 * @param first
	 * @param second
	 * @return
	 */
	private Node sumOfLinkedListsRecurWrapper(Node first, Node second){
		
		Node result = new Node(-1);
		int first_length = lengthOfLinkedList(first);
		int second_length = lengthOfLinkedList(second);
		
		if(first_length  == second_length){
			sumOfLinkedListsRecur(first, second, result.next);
		}else if(first_length > second_length){
			
			//Temp reference for the longer list.
			Node ref = first;
			
			//Advance along the longer list for the difference.
			for(int i=0;i<(first_length - second_length);i++){
				ref = ref.next;
			}
			
			sumOfLinkedListsRecur(ref, second, result.next);
		}else{
			
			//Temp reference for the longer list.
			Node ref = second;
			
			//Advance along the longer list for the difference.
			for(int i=0;i<(second_length - first_length);i++){
				ref = ref.next;
			}
			
			sumOfLinkedListsRecur(first, ref, result.next);
		}
		
		return result;
	}
	
	/**
	 * Sum of linked-list using space efficient recursive method.
	 * @param first
	 * @param second
	 * @param result
	 * @return
	 */
	private int sumOfLinkedListsRecur(Node first, Node second, Node result){
		if(first.next != null && second.next != null){
			int carry = sumOfLinkedListsRecur(first.next, second.next, result.next);
			int sum = carry + first.data + second.data;
			carry = (sum>=10)?1:0;
			sum = sum%10;
			result = new Node(sum);
			return carry;
		}
		return 0;
	}
	
	/**
	 * Utility: length of a linked list.
	 * @param head
	 * @return
	 */
	private int lengthOfLinkedList(Node head){
		int len = 0;
		while(head!=null){
			++len; head = head.next;
		}
		return len;
	}
	
	/**
	 * Utility method to print the linked list.
	 * @param head
	 */
	private void printList(Node head){
		while(head!=null){
			System.out.print(head.data+" ");
			head = head.next;
		}
		
		System.out.println();
	}
	
	/**
	 * Another uitlity method to print human readable result.
	 * @param head
	 */
	private void printRecursive(Node head){
		if(head==null)
			return;
		printRecursive(head.next);
		System.out.print(head.data+" ");
	}
}