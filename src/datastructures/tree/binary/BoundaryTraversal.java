package datastructures.tree.binary;

import common.TreeNode;

public class BoundaryTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        root.right = new TreeNode(22);
        root.right.right = new TreeNode(25);
        printBoundary(root);
	}
	
	private static void printBoundary(TreeNode node){
		if(node!=null){
			System.out.printf("%d ", node.data);
			
			if(node.left!=null){
				printLeftBoundary(node.left);
				printLeaves(node.left);
			}
			
			if(node.right!=null){
				printLeaves(node.right);
				printRightBoundary(node.right);
			}
		}
	}
	
	//Print the left boundary in top down manner.
	private static void printLeftBoundary(TreeNode node){
		if(node!=null){
			if(node.left!=null){
				System.out.printf("%d ",node.data);
				printLeftBoundary(node.left);
			}else if(node.right!=null){
				System.out.printf("%d ",node.data);
				printLeftBoundary(node.right);
			}
		}
	}
	
	private static void printLeaves(TreeNode node){
		if(node!=null){
			if(node.left!=null) printLeaves(node.left);
			if(node.right!=null) printLeaves(node.right);
			if(node.left==null && node.right==null)
				System.out.printf("%d ", node.data);
		}
	}
	
	//Print the right boundary in bottom up manner.
	private static void printRightBoundary(TreeNode node){
		if(node!=null){
			if(node.right!=null){
				printRightBoundary(node.right);
				System.out.printf("%d ",node.data);
			}else if(node.left!=null){
				printRightBoundary(node.left);
				System.out.printf("%d ",node.data);
			}
		}
	}
}