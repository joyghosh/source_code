package datastructures.bst;

public class LCA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        
        int n1 = 10, n2 = 14;
        Node t =  leastCommonAncestor(root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
        
        n1 = 14;
        n2 = 8;
        t = leastCommonAncestor(root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
        
        
        n1 = 10;
        n2 = 22;
        t = leastCommonAncestor(root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
	}
	
	//Find a node n such that n1 < n < n2 or either n == n1 (where n1 < n2) or n == n2 (where n2 < n1).
	//T.C. = O(h), h is the height of the tree.
	private static Node leastCommonAncestor(Node n, int n1, int n2){
		//edge or base case. If the tree is empty.
		if(n==null) return null;
		
		//if both n1 and n2 are smaller than node n, lca is in the left subtree to n.
		if(n1 < n.data && n2 < n.data){
			return leastCommonAncestor(n.left, n1, n2);
		}
		
		//if both n1 and n2 are greater than node n, lca is in the right subtree to n.
		if(n1 > n.data && n2 > n.data){
			return leastCommonAncestor(n.right, n1, n2);
		}
		
		return n;
	}
}
