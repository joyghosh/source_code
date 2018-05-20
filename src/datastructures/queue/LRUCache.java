package datastructures.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCache {

	private static Map<Long, Node> pageMap;
	private static LinkedList<Node> queue;
	
	public static void main(String[] args) {
		
	}
	
	public static class Node{
		private Long value;
		
		public Node(Long value){
			this.value = value;
		}
		
		public Long getValue(){
			return this.value;
		}
	}
}
