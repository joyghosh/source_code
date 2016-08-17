package datastructures.heap;

/**
 * Sort numbers stored on different machines
 * 
 * @author Joy Ghosh
 *
 */
public class ExternalSort {

	public static void main(String[] args) {
		ExternalSort es = new ExternalSort();
		ListNode[] arr = new ListNode[3];
		
		push(arr[0], 50, es);
		push(arr[0], 40, es);
		push(arr[0], 30, es);
		
		push(arr[1], 45, es);
		push(arr[1], 35, es);
		
		push(arr[2], 100, es);
		push(arr[2], 80, es);
		push(arr[2], 70, es);
		push(arr[2], 60, es);
		push(arr[2], 10, es);
		
		externalSort(arr, es);
	}
	
	class ListNode{
		int data;
		ListNode next;
		
		public ListNode(int data){
			this.data = data;
		}
	}
	
	class MinHeapNode{
		ListNode head;
	}
	
	class MinHeap{
		int count;
		int capacity;
		MinHeapNode[] nodes;
	}
	
	public static MinHeap createHeap(int capacity, ExternalSort es){
		MinHeap heap = es.new MinHeap();
		heap.capacity = capacity;
		heap.count = 0;
		heap.nodes = new MinHeapNode[capacity];
		
		return heap;
	}
	
	public static void push(ListNode head, int data, ExternalSort es){
		ListNode node = es.new ListNode(data);
		node.next = head;
		head = node;
	}
	
	public static void swap(MinHeapNode a, MinHeapNode b){
		ListNode tmp = a.head;
		a.head = b.head;
		b.head = tmp;
	}
	
	public static void minHeapify(MinHeap heap, int i){
		int left, right;
		left = 2*i+1;
		right = 2*i+2;
		
		int smallest = i;
		if(left < heap.count && 
				heap.nodes[left].head.data < heap.nodes[smallest].head.data){
			smallest = left;
		}
		
		if(right < heap.count && 
				heap.nodes[right].head.data < heap.nodes[smallest].head.data){
			smallest = right;
		}
		
		if(smallest != i){
			swap(heap.nodes[smallest], heap.nodes[i]);
			minHeapify(heap, smallest);
		}
	}
	
	public static boolean isEmpty(MinHeap heap){
		return heap.count == 0;
	}
	
	public static void buildHeap(MinHeap heap){
		for(int i=(heap.count-1)/2; i>=0; --i){
			minHeapify(heap, i);
		}
	}
	
	public static void populateMinHeap(MinHeap heap, ListNode[] nodes){
		for(int i=0; i<nodes.length; i++){
			heap.nodes[heap.count++].head = nodes[i];
		}
		
		minHeapify(heap, 0);
	}
	
	public static ListNode extractMin(MinHeap heap){
		if(isEmpty(heap)) 
			return null;
		
		// The root of heap will have minimum value
		MinHeapNode result = heap.nodes[0];
		
		// Replace root either with next node of the same list.
		if(result.head.next != null){
			heap.nodes[0].head = result.head.next;
		}else{
			// If list empty, then reduce heap size
			heap.nodes[0] = heap.nodes[heap.count-1];
			--heap.count;
		}
		
		minHeapify(heap, 0);
		return result.head;
	}
	
	public static void externalSort(ListNode[] nodes, ExternalSort es){
		MinHeap heap = createHeap(nodes.length, es);
		populateMinHeap(heap, nodes);
		
		while(!isEmpty(heap)){
			ListNode tmp = extractMin(heap);
			System.out.println(tmp.data+" ");
		}
	}
}
