package com.iq.microsoft;

public class TreeNode {
	
		private int data;
		private TreeNode left,right;
		
		public TreeNode(int data){
				this.data = data;
				this.left = this.right = null;
		}

		public TreeNode getLeft() {
//			if(this.left.equals(null))
//				return null;
			return this.left;
		}

		public void setLeft(TreeNode left) {
			this.left = left;
		}

		public TreeNode getRight() {
			
//			if(this.right.equals(null))
//				return null;
			return this.right;
		}

		public void setRight(TreeNode right) {
			this.right = right;
		}

		public int getData() {
			return this.data;
		}

}
