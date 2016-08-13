package datastructures.tree;

/**
 * Threaded Binary tree.
 * 
 * @author Joy Ghosh
 *
 */
public class ThreadedBinaryTree {

	public static void main(String[] args) {
		ThreadedBinaryTree tbt = new ThreadedBinaryTree();
		Node root = tbt.new Node(6);
		root.left = tbt.new Node(3);
		root.left.left = tbt.new Node(1); 
		root.left.left.right = root.left; 
		root.left.left.rightThreaded = true; 
		root.left.right = tbt.new Node(5); root.left.right.right = root; root.left.right.rightThreaded = true;
		root.right = tbt.new Node(8); root.right.left = tbt.new Node(7); root.right.right = tbt.new Node(11);
		root.right.left.right = root.right; root.right.left.rightThreaded = true;
		root.right.right.left = tbt.new Node(9); root.right.right.right = tbt.new Node(13);
		root.right.right.left.right = root.right.right; root.right.right.left.rightThreaded = true;
		
		inOrderTraversal(root);
	}

	public static void inOrderTraversal(Node root){
		if(root == null)
			return;
		
		Node n = leftMostNode(root);
		while(n!=null){
			System.out.printf("%d ", n.data);
			if(n.rightThreaded){
				n = n.right;
			}else{
				n = leftMostNode(n.right);
			}
		}
	}
	
	public static Node leftMostNode(Node root){
		if(root == null)
			return null;
		Node n = root;
		while(n.left!=null){
			n = n.left;
		}
		return n;
	}
	
	class Node{
		int data;
		Node left, right;
		boolean rightThreaded;
		
		public Node(int data){
			this.data = data;
		}
	}
}
