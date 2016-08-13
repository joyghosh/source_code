package datastructures.tree;

/**
 * Size of a tree.
 * 
 * @author Joy Ghosh
 *
 */
public class SizeOfTree {

	public static void main(String[] args) {
		
		SizeOfTree sot = new SizeOfTree();
		Node root = sot.new Node(1);
		root.left = sot.new Node(2); root.right = sot.new Node(3);
		root.left.left = sot.new Node(4); root.left.right = sot.new Node(5);
		
		System.out.println(sizeOfTree(root));
	}
	
	/**
	 * [Recursive]
	 * TC: O(n)
	 * SC: O(1)
	 * 
	 * @param root
	 * @return
	 */
	public static int sizeOfTree(Node root){
		if(root == null)
			return 0;
		int left_size = (root.left == null)? 0 :sizeOfTree(root.left);
		int right_size = (root.right == null)? 0 :sizeOfTree(root.right);
		return (left_size + 1 + right_size);
	}
	
	class Node{
		int data;
		Node left, right;
		
		public Node(int data){
			this.data = data;
		}
	}
}
