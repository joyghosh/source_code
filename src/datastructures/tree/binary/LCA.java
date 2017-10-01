package datastructures.tree.binary;

import java.util.LinkedList;

/**
 * Lowest Common Ancestor in a Binary Tree.
 * Given a binary tree (not a binary search tree) and two values say n1 and n2, write a program to find the least common ancestor.
 * 
 * @author joyghosh
 *
 */
public class LCA {
		
	private static boolean left;
	private static boolean right;
	
	public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        int n1 = 2;
        int n2 = 4;
        
//        Node r = findLCAUsingTwoTraversals(root, n1, n2);
//        Node r = findLCA(root, n1, n2);
        Node r = findLCABetter(root, n1, n2);
        if(r!=null){
        	System.out.println("LCA: "+r.data);
        }else{
        	System.out.println("No LCA found!");
        }
	}
	
	public static Node findLCAUsingTwoTraversals(Node root, int n1, int n2){
		
		if(root == null) return null;
		Node n = root;
		Node result = null;
		
		LinkedList<Node> path1 = new LinkedList<>();
		LinkedList<Node> path2 = new LinkedList<>();
		
		//Build path vectors upto n1 and n2.
		if(buildPath(n, path1, n1) && 
				buildPath(n, path2, n2)){
			
			//Print the path vectors.
			System.out.print("Path vector 1: ");
			for(Node r:path1){
				System.out.printf("%d ", r.data);
			}
			System.out.println();
			System.out.print("Path vector 2: ");
			for(Node r:path2){
				System.out.printf("%d ", r.data);
			}
			System.out.println();
			//Find lowest common ancestor.
			while(!path1.isEmpty() && !path2.isEmpty()){
				Node p1 = path1.removeFirst();
				Node p2 = path2.removeFirst();
				
				if(p1 != p2){
					break;
				}else{
					result = p1;
				}
			}
		}
		
		return result;
	}
	
	public static boolean buildPath(Node root, LinkedList<Node> path, int v){
		if(root == null) return false;
		
		if(root.data == v){
			path.addFirst(root);
			return true;
		}
		
		if(root.left != null && buildPath(root.left, path, v)){
			path.addFirst(root);
			return true;
		}else if(root.right != null && buildPath(root.right, path, v)){
			path.addFirst(root);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Using single traversal. Assuming both nodes are present.
	 */
	private static Node findLCA(Node root, int n1, int n2){
		if(root == null) return null;
		
		if(root.data == n1 || root.data == n2){
			return root;
		}
		
		Node leftLca = findLCA(root.left, n1, n2);
		Node rightLca = findLCA(root.right, n1, n2);
		
		if(leftLca!=null && rightLca!=null && left && right)
			return root;
		
		return (leftLca!=null)? leftLca: rightLca;
	}
	
	/**
	 * Single traversal, even if nodes are not present.
	 * @param root
	 * @param n1
	 * @param n2
	 * @return
	 */
	private static Node findLCABetter(Node root, int n1, int n2){
		left = false;
		right = false;
		Node lcaNode = findLCABetterUtil(root, n1, n2);
		
		if(left && right){
			System.out.print(left+" "+right);
			return lcaNode;
		}
		
		System.out.print(left+" "+right);
		return null;
	}
	
	private static Node findLCABetterUtil(Node root, int n1, int n2){
		if(root == null) return null;
		
		if(root.data == n1){
			left = true;
			return root;
		}
		
		if(root.data == n2){
			right = true;
			return root;
		}
		
		Node leftLca = findLCABetterUtil(root.left, n1, n2);
		Node rightLca = findLCABetterUtil(root.right, n1, n2);
		
		if(leftLca!=null && rightLca!=null)
			return root;
		
		return (leftLca!=null)? leftLca: rightLca;
	}
}


class Node{
	int data;
	Node left, right;
	
	public Node(int data){
		this.data = data;
	}
}