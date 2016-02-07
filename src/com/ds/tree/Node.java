package com.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Node {
	
	public int data;
	public Node left, right;
	
	public Node(int data){
		this.data = data;
		this.left = this.right = null;
		
		Queue<Integer> q = new LinkedList<Integer>();
		
	}
}
