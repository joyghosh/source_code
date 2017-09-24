package datastructures.bst;

public class CeilFloorValue {

	static Node root;
	
	static class Node{
		int data;
		Node left, right;
		
		public Node(int data){
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		CeilFloorValue tree = new CeilFloorValue();
		tree.root = new Node(8);
		tree.root.left = new Node(4);
		tree.root.right = new Node(12);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(6);
		tree.root.right.left = new Node(10);
		tree.root.right.right = new Node(14);
		for (int i = 0; i < 16; i++) {
			System.out.println(i + " " + floor(root, i));
		}
	}
	
	public static int ceil(Node node, int key){
		if(node == null) return -1;
		
		if(node.data == key) return node.data;
		
		if(node.data < key){
			return ceil(node.right, key);
		}
			
		int ceil = ceil(node.left, key);
		return (ceil>=key)? ceil: node.data;
	}
	
	public static int floor(Node node, int key){
		if(node == null)  return -1;
		if(node.data == key) return node.data;
		if(node.data > key){
			return floor(node.left, key);
		}
		int floor = floor(node.right, key);
		return (floor>node.data)? floor: node.data;
	}
}
