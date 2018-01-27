package datastructures.linkedlist;

import java.util.HashSet;
import java.util.Set;

import common.Node;

public class DetectLoop {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
//		head.next.next.next.next.next = head.next;
		
		System.out.println("Does linked list has loop using hashing: "+detectLoopHash(head));
		System.out.println("Does linked list has loop using Floyd's Cycle detection algorithm: "+detectLoopFloydCycleDetection(head));
	}
	
	//Time-complexity: O(n).
	//Space-complexity: O(n).
	public static boolean detectLoopHash(Node head){
		if(head == null) return false;
		Set<Node> lookUp = new HashSet<Node>();
		Node node = head;
		
		while(node!=null){
			if(lookUp.contains(node.next)){
				return true;
			}
			
			lookUp.add(node);
			node = node.next;
		}
		
		return false;
	}
	
	//O(n)
	//O(1)
	public static boolean detectLoopFloydCycleDetection(Node head){
		if(head == null) return false;
		
		Node slow, fast;
		slow = fast = head;
		while(fast!=null && fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
			
			if(slow == fast) return true;
		}
		
		return false;
	}
}
