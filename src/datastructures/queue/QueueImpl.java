package datastructures.queue;

public class QueueImpl {

	class Queue{
		int size;
		int capacity;
		int front;
		int rear;
		int[] array;

		public Queue(int capacity){
			this.array = new int[capacity];
			this.size = 0;
			this.front = 0;
			this.rear = capacity - 1;
			this.capacity = capacity;
		}

		public boolean isFull(){
			return this.size == capacity;
		}

		public boolean isEmpty(){
			return this.size == 0;
		}

		public void enqueue(int data){
			if(this.isFull()){
			  System.out.println("Overflow!");
			  return;
			}
			this.array[rear] = data;		 
			this.rear = (rear+1)%capacity;
			this.size++;
			System.out.println("Item enqueued "+data);
		}

		public int dequeue(){
			if(this.isEmpty()){
				System.out.println("Underflow!");
			  	return Integer.MIN_VALUE;
			}
			int data = this.array[front];
			this.front = (front+1)%capacity;
			this.size--;
			return data;		
		}

		public int front(){
			if(this.isEmpty()){
			   System.out.println("Underflow!");
			   return Integer.MIN_VALUE;
			}
			
			int data = this.array[front];
			return data;		
		}

		public int rear(){
			if(this.isEmpty()){
			   System.out.println("Underflow!");
			   return Integer.MIN_VALUE;
			}
			
			int data = this.array[rear];
			return data;	
		}
	}
	
	public static void main(String[] args) {
		QueueImpl qi = new QueueImpl();
		QueueImpl.Queue queue = qi.new Queue(10);
		
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		
		System.out.println(queue.front());
		System.out.println(queue.rear());
		
		queue.dequeue();
		System.out.println(queue.front());
		System.out.println(queue.rear());
		
		queue.dequeue();
		System.out.println(queue.front());
		System.out.println(queue.rear());
	}
}
