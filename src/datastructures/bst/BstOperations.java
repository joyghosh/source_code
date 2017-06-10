package datastructures.bst;

import java.util.Scanner;

public class BstOperations {

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(8); root.right = new Node(15);
		root.left.left = new Node(4); root.left.right = new Node(9);
		root.right.left = new Node(14);
		
		// Find if the key exists.
		Scanner sc = new Scanner(System.in);
//		String choice;
//		do{
//			System.out.print("Enter a key to look up the BST: ");
//			int key = sc.nextInt();
//			Node node = findKey(key, root);
//			
//			if(node!=null){
//				System.out.println("Found node with key "+key);
//			}else{
//				System.out.println("No node found with key "+key);
//			}
//			System.out.print("Do you want to continue? (Enter q or Q to exit): ");
//			choice = sc.next();
//		}while(choice!="Q" || choice!="q");
//		
//		sc.close();
		
		// Insert key in BST.
		System.out.print("Enter the key value to insert: ");
		int key = sc.nextInt();
		insert(key, root);
		Node n = findKey(key, root);
		if(n!=null){
			System.out.println("Node present: "+n.data);
		}else{
			System.out.println("Node not present!");
		}
	}
	
	//O(n)
	private static Node findKey(int key, Node node){
		if(node == null) return null;
		
		if(node.data == key) return node;
		if(key < node.data)
			return findKey(key, node.left);
		return findKey(key, node.right);
	}
	
	//O(n)
	private static Node insert(int key, Node node){
		
		//if tree is empty, create a new node and return the node as root.
		if(node == null){
			Node n = new Node(key);
			return n;
		}
		
		if(key < node.data){
			node.left = insert(key, node.left);
		}else if(key > node.data){
			node.right = insert(key, node.right);
		} 
		
		return node;
	}
}
