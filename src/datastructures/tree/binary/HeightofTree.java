package datastructures.tree.binary;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Find the height of a tree.
 * @author Joy Ghosh
 *
 */
public class HeightofTree {
	
	public static void main(String[] args){
		HeightofTree hot = new HeightofTree();
		Node root = hot.new Node(1);
		root.left = hot.new Node(2);  root.right = hot.new Node(3);
		root.left.left = hot.new Node(4); root.left.right = hot.new Node(5); root.right.left = hot.new Node(6); root.right.right = hot.new Node(7);
		root.right.right.left = hot.new Node(8); 
		System.out.println("[recursive] height of a binary tree: "+heightRecursive(root));
		System.out.println("[iterative] height of a binary tree: "+heightIterative(root));
	}
	
	/**
	 * [recursive]
	 * Time-complexity: O(n)
	 * Space-complexity: O(1)
	 * 
	 * @param root
	 * @return
	 */
	public static int heightRecursive(Node root){
		if(root == null)
			return 0;
		
		return Math.max(heightRecursive(root.left), heightRecursive(root.right)) + 1;
	}
	
	/**
	 * [Iterative]
	 * Time-complexity: O(n)
	 * Space-complexity: O(n)
	 * 
	 * @param root
	 * @return
	 */
	public static int heightIterative(Node root){
		if(root == null)
			return 0;
		
		Queue<Node> queue = new LinkedList<HeightofTree.Node>();
		int height = 0; queue.add(root);
		while(true){
			int nodeCount = queue.size();
			if(nodeCount == 0){
				return height;		//no more level.
			}else{
				++height;	//Found one more level.
			}
			
			while(nodeCount > 0){
				Node n = queue.remove();
				if(n.left != null){
					queue.add(n.left);
				}
				
				if(n.right != null){
					queue.add(n.right);
				}
				
				--nodeCount;
			}
		}
	}
	
	/**
	 * Node of a B-tree.
	 * @author Joy Ghosh
	 *
	 */
	class Node{
		int data;
		Node left, right;
		public Node(int data){
			this.data = data;
		}
	}
}
