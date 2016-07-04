package datastructures.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalOrderTraversal {

	private static Map<Integer, List<TreeNode>> map;
	
	public static void main(String[] args) {
		
		//hash map.
		map = new TreeMap<Integer, List<TreeNode>>();
		
		//build the tree.
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2); root.right = new TreeNode(3);
		root.left.left = new TreeNode(4); root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6); root.right.right = new TreeNode(7);
		root.right.left.right = new TreeNode(8); root.right.right.right = new TreeNode(9);
		
		//vertical order traversal using hashing technique.
		verticalOrderTraversal(root);
	}
	
	//in-order traversal of Binary tree to compute horizontal distance.
	private static void hd_inorderTraversal(TreeNode root, int hd){
		
		//in case the tree is empty.
		if(root == null)
			return;
		
		//left sub-tree recursion. 
		if(root.left!=null)
			hd_inorderTraversal(root.left, hd-1);
		
		//root node.
		if(map.containsKey(hd)){
			map.get(hd)
			   .add(root);
		}else{
			List<TreeNode> list = new ArrayList<TreeNode>();
			list.add(root);
			map.put(hd, list);
		}
				
		//traverse right sub-tree recursively.
		if(root.right != null)
			hd_inorderTraversal(root.right, hd+1);
	}
	
	//vertical order traversal using hashing technique.
	private static void verticalOrderTraversal(TreeNode root){
		
		hd_inorderTraversal(root, 0);
		
		for(List<TreeNode> entry : map.values()){
			Collections.sort(entry);
			for(TreeNode n : entry)
				System.out.print(n.data+" ");
			System.out.println();
		}
	}
}