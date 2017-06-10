package datastructures.tree.binary;

/**
 * Max value of a node in a binary tree.
 * 
 * @author joyghosh
 *
 */
public class MaxValue {

	class Node{
		int data;
		Node left, right;
		
		public Node(int data){
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		MaxValue mv = new MaxValue();
		Node root = mv.new Node(2); root.left = mv.new Node(7); root.right = mv.new Node(5);
		root.left.right = mv.new Node(6); root.right.right = mv.new Node(9);
		root.left.right.left = mv.new Node(1); root.left.right.right = mv.new Node(11);
		root.right.right.left = mv.new Node(4);
		
		System.out.println("Max. value of the tree: "+maxValue(root));
	}

	private static int maxValue(Node root){
		if(root == null) return Integer.MIN_VALUE;
		
		int maxLeft = Integer.MIN_VALUE, maxRight = Integer.MIN_VALUE;
		if(root.left!=null){
			maxLeft =  maxValue(root.left);
		}
		
		if(root.right!=null){
			maxRight = maxValue(root.right);
		}
		
		return max(root.data, maxLeft, maxRight);
	}
	
	private static int max(int v1, int v2, int v3){
		int max = Integer.MIN_VALUE;
		max = (v1>v2)? v1: v2;
		max = (max>v3)? max: v3;
		
		return max;
	}
}
