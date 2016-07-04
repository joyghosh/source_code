package com.algo.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * Union-Find algorithm.
 * A disjoint-set data structure is a data structure that keeps track 
 * of a set of elements partitioned into a number of disjoint (non-overlapping) subsets. 
 * A union-find algorithm is an algorithm that performs two useful operations on such a 
 * data structure.
 * @author Joy Ghosh
 */
public class UnionFind {

	public static void main(String[] args) {
		
		//Initialize and makeSet.
		List<Node> list = new ArrayList<Node>();
		for(int i=0; i<7; i++){
			Node n = new Node(i+1);
			makeSet(n);
			list.add(n);
		}
		
		//Apply find operation to the singletons.
		System.out.println("Representatives of the subsets");
		for(Node n:list){
			System.out.println(find(n).data);
		}
		
		//Do some union operations.
		union(list.get(0), list.get(1));
		union(list.get(4), list.get(6));
		
		//Now do a find.
		System.out.println("Representatives of the subsets");
		for(Node n:list){
			System.out.println(find(n).data);
		}
	}

	/**
	 * Find of Union-Find method.
	 * Time complexity: O(n).
	 * Space complexity: O(n).
	 * @param x
	 * @return
	 */
	private static Node find(Node x){
		if(x.parent == x)
			return x;
		else
			return find(x.parent);
	}
	
	/**
	 * Union operation of union-find method.
	 * Time complexity: O(n).
	 * Space complexity: O(n).
	 * @param x
	 * @param y
	 */
	private static void union(Node x, Node y){
		
		Node rootX = find(x);
		Node rootY = find(y);
		if(rootX != rootY){
			rootX.parent = rootY;
		}
	}
	
	/**
	 * MakeSet operation of Union-find.
	 * Time complexity: O(1).
	 * Space complexity: O(1).
	 * @param x
	 */
	private static void makeSet(Node x){
		x.parent = x;
	}
}

//Node entity.
class Node{
	int data;
	Node parent;
	
	public Node(int data){
		this.data = data;
	}
}
