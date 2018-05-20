package datastructures.tree;

public class AVL {

	public static void main(String[] args) {

	}
	
	private static Node leftRotate(Node z){
		Node y = z.right;
		Node x = z.right.right;
		Node T2 = y.left;
		
		z.right = T2;
		y.left = z;
		
		z.height = Math.max(height(z.left), height(z.right));
		y.height = Math.max(height(y.left), height(y.right));
		
		return y;
	}
	
	private static Node rightRotate(Node z){
		Node y = z.left;
		Node T3 = y.right;
		
		z.left = T3;
		y.right = z;
		
		z.height = Math.max(height(z.left), height(z.right));
		y.height = Math.max(height(y.left), height(y.right));
		
		return y;
	}
	
	private static int height(Node n){
		if(n == null) return 0;
		
		return n.height;
	}
	
	public static class Node{
		int data;
		int height;
		
		Node left, right;
		
		public Node(int data){
			this.data = data;
			this.height = 1;
		}
	}
}
