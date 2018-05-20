package datastructures.bst;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryToBst {

	public static void main(String[] args) {
		//Sample Binary tree;
		Node root = new Node(10);
		root.left = new Node(2);
		root.right = new Node(7);
		root.left.left = new Node(8);
		root.left.right = new Node(4);
		inOrderTraversal(root);
		
		System.out.println();
		
		//Convert to BST.
		Node bstRoot = binaryToBST(root);
		inOrderTraversal(bstRoot);
	}
	
	public static Node binaryToBST(Node root){
		if(root == null) return root;
		
		Node resultBST = null;
//		Node n = root;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		
		while(!q.isEmpty()){
			Node n = q.poll();
			resultBST = formBst(n, resultBST);
			if(n.left!=null){
				q.add(n.left);
			}
			
			if(n.right!=null){
				q.add(n.right);
			}
		}
		
		return resultBST;
	}
	
	public static Node formBst(Node n, Node bst){
		if(bst == null){
			bst = new Node(n.val);
			return bst;
		}
		
		if(n.val < bst.val){
			bst.left = formBst(n, bst.left);
		}else if(n.val > bst.val){
			bst.right = formBst(n, bst.right);
		}
		
		return bst;
	}
	
	public static void inOrderTraversal(Node root){
		if(root == null) return;
		
		inOrderTraversal(root.left);
		System.out.println(root.val);
		inOrderTraversal(root.right);
	}
	
	public static class Node{
		int val;
		Node left;
		Node right;
		
		public Node(int val){
			this.val = val;
		}
	}
}
