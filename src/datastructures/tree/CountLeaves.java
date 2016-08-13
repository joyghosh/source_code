package datastructures.tree;

/**
 * Count the leaves.
 * 
 * @author Joy Ghosh
 *
 */
public class CountLeaves {

	public static void main(String[] args) {
		CountLeaves sot = new CountLeaves();
		Node root = sot.new Node(1);
		root.left = sot.new Node(2); root.right = sot.new Node(3);
		root.left.left = sot.new Node(4); root.left.right = sot.new Node(5);
		System.out.println(countLeaves(root));
	}

	public static int countLeaves(Node root){
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		int l = (root.left == null)? 0: countLeaves(root.left);
		int r = (root.right == null)? 0: countLeaves(root.right);
		return (l+r);
	}
	
	class Node{
		int data;
		Node left, right;
		
		public Node(int data){
			this.data = data;
		}
	}
}
