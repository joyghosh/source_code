package datastructures.tree.binary;

/**
 * Print nodes at k distance from root
 * 
 * @author Joy Ghosh
 *
 */
public class PrintNodesAtKDistance {
	
	class Node{
		int data;
		Node left, right;
		
		public Node(int data){
			this.data = data;
		}
	}
	
	/**
	 * T.C: O(k)
	 * S.C: O(k)
	 * 
	 * @param node
	 * @param k
	 * @param val
	 */
	public static void printNodeAtKDistance(Node node, int k, int val){
		
		if(node == null) return;
		
		if(val == k){
			System.out.println(node.data);
			return;
		}
		
		if(node.left != null){
			printNodeAtKDistance(node.left, k, val+1);
		}
		
		if(node.right != null){
			printNodeAtKDistance(node.right, k, val+1);
		}
	}
	
	public static void main(String[] args) {
		PrintNodesAtKDistance pnakd = new PrintNodesAtKDistance();
		Node root = pnakd.new Node(1);
		root.left = pnakd.new Node(2); root.right = pnakd.new Node(3);
		root.left.left = pnakd.new Node(4); root.left.right = pnakd.new Node(5);
		root.right.left = pnakd.new Node(8);
		
		printNodeAtKDistance(root, 2, 0);
	}
}
