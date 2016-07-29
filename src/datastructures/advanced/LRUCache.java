package datastructures.advanced;


public class LRUCache {

	public static void main(String[] args) {
		LRUCache lru = new LRUCache();
		Queue q = lru.new Queue(4);
		Hash hash = lru.new Hash(10);
		
		referencePage(q, hash, 1);
		referencePage(q, hash, 2);
		referencePage(q, hash, 3);
		referencePage(q, hash, 1);
		referencePage(q, hash, 4);
		referencePage(q, hash, 5);
		
		System.out.printf("%d ", q.front.pageNumber);
		System.out.printf("%d ", q.front.next.pageNumber);
		System.out.printf("%d ", q.front.next.next.pageNumber);
		System.out.printf("%d ", q.front.next.next.next.pageNumber);
	}
		
	public static void referencePage(Queue queue, Hash hash, int pageNumber){
		QNode reqPage = hash.array[pageNumber];
		
		if(reqPage == null){
			queue.enqueue(hash, pageNumber);
		}else if(reqPage != queue.front){
			reqPage.prev.next = reqPage.next;
			if(reqPage.next != null){
				reqPage.next.prev = reqPage.prev;
			}
			
			if(reqPage == queue.rear){
				queue.rear = reqPage.prev;
				queue.rear.next = null;
			}
			
			reqPage.next = queue.front;
			reqPage.prev = null;
			
			reqPage.next.prev = reqPage;
			
			queue.front = reqPage;
		}
	}
	
	/**
	 * Queue node.
	 * @author Joy Ghosh
	 *
	 */
	class QNode{
		QNode prev, next;
		int pageNumber;
		
		public QNode(int pageNumber){
			this.pageNumber = pageNumber;
		}
	}
	
	/**
	 * Actual queue.
	 * @author Joy Ghosh
	 *
	 */
	class Queue{
		int count;
		private int noOfFrames;
		QNode front, rear;
		
		public Queue(int noOfFrames){
			this.count = 0;
			this.noOfFrames = noOfFrames;
		}
		
		public boolean areFramesFull(){
			return this.count == this.noOfFrames;
		}
		
		public boolean isEmpty(){
			return this.rear == null;
		}
		
		public void enqueue(Hash hash, int pageNumber){
			
			// If all frames are full, remove the page at the rear
			if(this.areFramesFull()){
				
				//remove page from hash
				hash.array[this.rear.pageNumber] = null;
				dequeue();
			}
			
			// Create a new node with given page number,
		    // And add the new node to the front of queue
			QNode tmp = new QNode(pageNumber);
			tmp.next = this.front;
			
			 // If queue is empty, change both front and rear pointers
			if(this.isEmpty()){
				this.front = this.rear = tmp;
			}else{
				 // Else change the front
				this.front.prev = tmp;
				this.front = tmp;
			}
			
			// Add page entry to hash also
			hash.array[pageNumber] = tmp;
			
			// increment number of full frames
			this.count++;
		}
		
		public void dequeue(){
			if(this.isEmpty()){
				return;
			}
			
			if(this.front == this.rear){
				this.front = null;
			}
			
			QNode tmp = this.rear;
			this.rear = this.rear.prev;
			
			if(this.rear != null){
				this.rear.next = null;
			}
			
			this.count--;
		}
	}
	
	/**
	 * Hash table for maintaining mappings.
	 * @author Joy Ghosh
	 *
	 */
	class Hash{
		int capacity;
		QNode[] array;
		
		public Hash(int capacity){
			this.capacity = capacity;
			this.array = new QNode[capacity];
		}
	}
}
