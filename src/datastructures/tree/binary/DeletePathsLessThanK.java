package datastructures.tree.binary;

public class DeletePathsLessThanK {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.left = new TreeNode(7);
		root.right.right = new TreeNode(6);
		root.right.right.left = new TreeNode(8);
		System.out.println("Before");
		inorderTraversal(root);
		root = removePathsLessThanK(root, 4);
		System.out.println("After");
		inorderTraversal(root);
	}
	
	public static TreeNode removePathsLessThanK(TreeNode root, int k){
		return removePathsLessThanKUtil(root, 1, k);
	}
	
	//Idea is to do a post-order traversal.
	public static TreeNode removePathsLessThanKUtil(TreeNode node, int level, int k){
		//base case.
		if(node == null)
			return null;
		
		node.left = removePathsLessThanKUtil(node.left, level+1, k);
		node.right = removePathsLessThanKUtil(node.right, level+1, k);
		
		//If this node is the leaf or is part of the node
		if(node.left==null && node.right==null && level<k){
			return null;
		}
		
		return node;
	}
	
	public static void inorderTraversal(TreeNode node){
		if(node == null) return;
		
		inorderTraversal(node.left);
		System.out.println(node.data);
		inorderTraversal(node.right);
	}
}
