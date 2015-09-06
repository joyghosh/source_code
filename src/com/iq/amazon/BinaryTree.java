package com.iq.amazon;

public class BinaryTree {

	private static int inIndex = 0;
	private static int preIndex = 0;
	
	public class TreeNode<T>{
		
		private T data;
		private TreeNode<T> left = null;
		private TreeNode<T> right = null;
		
		public TreeNode(T data){
			this.data = data;
		}
		
		public void setLeftNode(TreeNode<T> left){
			this.left = left;
		}
		
		public void setRightNode(TreeNode<T> right){
			this.right = right;
		}
		
		public T getData(){
			return this.data;
		}
		
		public TreeNode<T> getLeftNode(){
			
			if(this.left.equals(null))
				return null;
			
			return this.left;
		}
		
		public TreeNode<T> getRightNode(){
			
			if(this.right.equals(null))
				return null;
			
			return this.right;
		}
	}
	
	private TreeNode<String> buildTree(String inorder, String preorder){
		
		System.out.println("Pre Index: "+preIndex);
		
		if(preIndex < preorder.length()){
		
			char c = preorder.charAt(preIndex);
			preIndex = preIndex + 1;
			TreeNode<String> node = new TreeNode<String>(String.valueOf(c));
			
			System.out.println(c);
			inIndex = inorder.indexOf(c);
		
			System.out.println("In Index: "+inIndex);
			
			if(inIndex != -1){
				//define left sub-tree.
				TreeNode<String> left = buildTree(inorder,preorder); 
				node.setLeftNode(left);
			
				//define right sub-tree.
				TreeNode<String> right = buildTree(inorder,preorder);
				node.setRightNode(right);
			}
			
			return node;
		}
		
		return null;
	}
	
	private static void inOrderTraverse(TreeNode<String> root){
		
		if(root.equals(null))
			return;
			
		if(!root.getLeftNode().equals(null)){
			TreeNode<String> node = root.getLeftNode();
			inOrderTraverse(node);
		}
			
			System.out.println(root.getData());
			
		if(!root.getRightNode().equals(null)){
			TreeNode<String> node = root.getRightNode(); 
			inOrderTraverse(node);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String inorder = "DBEAFC";
		String preorder = "ABDECF";
		
		BinaryTree b = new BinaryTree();
		
		TreeNode<String> bt = b.buildTree(inorder, preorder);
		
		if(bt.equals(null)){
			System.out.println("Root is null");
		}else{
			System.out.println("Root is valid");
			inOrderTraverse(bt);
		}
	}
}