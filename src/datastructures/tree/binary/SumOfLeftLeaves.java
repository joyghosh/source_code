package datastructures.tree.binary;

/**
 * Sum of all left leaves in a binary tree.
 * 
 * @author joyghosh
 *
 */
public class SumOfLeftLeaves {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.left = new TreeNode(7);
		root.right.right = new TreeNode(6);
		root.right.right.left = new TreeNode(8);
		
		System.out.println("Sum of left leaves: "+sumOfLeftLeaves(root));
	}
	
	public static int sumOfLeftLeaves(TreeNode node){
		//Base case empty tree.
		if(node == null) return 0;
		int sum = 0;
		
		if(node.left!=null){ 
			if(isLeaf(node.left)){
				sum += node.left.data;
			}else{
				sum += sumOfLeftLeaves(node.left);
			}
		}
		
		if(node.right!=null){
			sum += sumOfLeftLeaves(node.right);
		}
		
		return sum;
	}
	
	public static boolean isLeaf(TreeNode node){
		if(node == null) return false;
		if(node.left == null && node.right == null) return true;
		return false;
	}
}
