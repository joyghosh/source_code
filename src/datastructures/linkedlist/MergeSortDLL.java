package datastructures.linkedlist;

import common.DllNode;

public class MergeSortDLL {

	public static void main(String[] args) {
//		10 <-> 30 <-> 3 <-> 4 <-> 20 <-> 5
		DllNode head = new DllNode(10);
		head.next = new DllNode(30);
		head.next.prev = head;
		head.next.next = new DllNode(3);
		head.next.next.prev = head.next;
		head.next.next.next = new DllNode(4);
		head.next.next.next.prev = head.next.next;
		head.next.next.next.next = new DllNode(20);
		head.next.next.next.next.prev = head.next.next.next;
		head.next.next.next.next.next = new DllNode(5);
		head.next.next.next.next.next.prev = head.next.next.next.next;
		
		System.out.println("Before sorting list.");
		printList(head);
		head = mergeSort(head);
		System.out.println("After sorting list.");
		printList(head);
	}
	
	public static DllNode mergeSort(DllNode head){
		if(head == null || head.next==null) return head;
		
		DllNode mid = split(head);
		DllNode nextToMid = mid.next;
		mid.next.prev = null;
		mid.next = null;
		
		DllNode first = mergeSort(mid);
			DllNode second = mergeSort(nextToMid);
		
		return merge(first, second);
	}
	
	public static DllNode split(DllNode head){
		if(head == null || head.next == null) return head;
		DllNode slow = head;
		DllNode fast = head;
		
		while(slow!=null && fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	public static DllNode merge(DllNode first, DllNode second){
		if(first == null) return second;
		if(second == null) return first;
		
		DllNode result = null;
		if(first.data <= second.data){
			result = first;
			result.next = merge(first.next, second);
		}else{
			result = second;
			result.next = merge(first, second.next);
		}
		
		result.next.prev = result;
		result.prev = null;
		return result;
	}
	
	public static void printList(DllNode head){
		if(head == null) return;
		
		DllNode node = head;
		while(node!=null){
			System.out.printf("%d ", node.data);
			node = node.next;
		}
	}
}
