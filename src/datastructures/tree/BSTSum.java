package datastructures.tree;

public class BSTSum {
	
	private static int sumOfDescendants(Node root){
		
		if(root == null)
			return 0;
		
		int left, right;
		left = right = 0;
		
		if(root.left != null)
			left = sumOfDescendants(root.left);
		if(root.right != null)
			right = sumOfDescendants(root.right);
		
		//Set this node value to sum of it descendants.
		root.data = Math.max(root.data, left + right);		

		return root.data;
	}

	private static void traverse(Node root){
		
		System.out.println(root.data);
		if(root.left != null)
			traverse(root.left);
		if(root.right != null)			
			traverse(root.right);
	}

	public static void main(String[] args){
			
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4); root.left.right = new Node(5);
		root.right.left = new Node(6); root.right.right = new Node(7);

		//Sum of descendants.
		System.out.println("Sum of it's descendants: "+sumOfDescendants(root));
		
		//Traverse tree using pre-order.
		traverse(root);
	}
}
