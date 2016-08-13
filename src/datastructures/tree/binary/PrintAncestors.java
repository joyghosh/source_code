package datastructures.tree.binary;


/**
 * Print Ancestors of a given node in Binary Tree
 * Given a Binary Tree and a key, write a function that prints all the ancestors of the key in the 
 * given binary tree. 
 * @author Joy Ghosh
 *
 */
public class PrintAncestors {

	class Node{
		int data;
		Node left, right;
		
		public Node(int data){
			this.data = data;
		}
	}
	
	public static void printAncestor(Node root, int k){
		if(root == null) return;
		
		if(root.data == k){
			System.out.println("Found value at root node. No ancestor for root.");
		}else{
			
			if((root.left != null && printAncestorUtil(root.left, k)) || 
					(root.right != null && printAncestorUtil(root.right, k))){
				System.out.println(root.data);
			}
		}
	}
	
	public static boolean printAncestorUtil(Node node, int k){
		if(node == null)
			return false;
		
		if(node.data == k){
			return true;
		}
		
		if((node.left != null && printAncestorUtil(node.left, k)) ||
					(node.right != null && printAncestorUtil(node.right, k))){
			System.out.println(node.data);
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		PrintAncestors pa = new PrintAncestors();
		Node root = pa.new Node(1);
		root.left = pa.new Node(2); root.right = pa.new Node(3);
		root.left.left = pa.new Node(4); root.left.right = pa.new Node(5);
		root.left.left.left = pa.new Node(7);
		
		printAncestor(root, 7);
	}
}
