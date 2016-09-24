package datastructures.tree;

import java.util.HashSet;
import java.util.Set;

/**
 * Print Common Nodes in Two Binary Search Trees
 * 
 * @author Joy Ghosh
 *
 */
public class CommonNodes {

	public static void main(String[] args) {
		
		CommonNodes cn = new CommonNodes();
		Node tree1 = cn.new Node(5); tree1.left = cn.new Node(1); tree1.right = cn.new Node(10);
		tree1.left.left = cn.new Node(0); tree1.left.right = cn.new Node(4);
		tree1.right.left = cn.new Node(7); tree1.right.left.right = cn.new Node(9);
		
		Node tree2 = cn.new Node(10); tree2.left = cn.new Node(7); tree2.right = cn.new Node(20);
		tree2.left.left = cn.new Node(4); tree2.left.right = cn.new Node(9);
		
		
		Set<Integer> hash = new HashSet<Integer>();
		buildHash(tree2, hash);
		printCommonNodes(tree1, hash);
	}

	class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data){
			this.data = data;
		}
	}
	
	/**
	 * First pass: Build the hash out of the elements in the first tree.
	 * Select the tree with less number of nodes.
	 * 
	 * @param node
	 * @param hash
	 */
	public static void buildHash(Node node, Set<Integer> hash){
		if(node == null) return;
		
		if(node.left!=null){
			buildHash(node.left, hash);
		}
		
		hash.add(node.data);
		
		if(node.right!=null){
			buildHash(node.right, hash);
		}
	}
	
	/**
	 * Second pass: Inorder traversal of the second tree looking up the hash for common nodes.
	 * @param node
	 * @param hash
	 */
	public static void printCommonNodes(Node node, Set<Integer> hash){
		
		if(hash.isEmpty() || node == null) return;
		
		if(node.left!=null){
			printCommonNodes(node.left, hash);
		}
		
		if(hash.contains(node.data))
			System.out.printf("%d ", node.data);
		
		if(node.right!=null){
			printCommonNodes(node.right, hash);
		}
	}
}
