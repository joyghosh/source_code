package datastructures;

import java.util.HashMap;
import java.util.Map;

/**
 * Trie data structure.
 * @author Joy Ghosh
 *
 */
public class Trie {

	class TrieNode{
		char c;
		Map<Character, TrieNode> children;
		boolean isLeaf;
		
		public TrieNode(char c){
			this.c = c;
			this.children = new HashMap<Character, Trie.TrieNode>();
		}
	}
	
	/**
	 * [Trie insert a new key]
	 * T.C. = O(n), where n is the key length.
	 * S.C. = O(n), where n is the key length.
	 * 
	 * @param root
	 * @param key
	 * @param t
	 */
	public static void insert(TrieNode root, char[] key, Trie t){
		int n = key.length;
		TrieNode node = root;
		for(int i=0; i<n; i++){
			if(!node.children.containsKey(key[i])){
				node.children.put(key[i], t.new TrieNode(key[i]));
			}
			
			//follow the child node.
			node = node.children.get(key[i]);
		}
		
		//mark last node as leaf node.
		node.isLeaf = true;
	}
	
	public static boolean search(TrieNode root, char[] key){
		
		int n = key.length;
		TrieNode node = root;
		for(int i=0; i<n; i++){
			if(!node.children.containsKey(key[i])){
				return false;
			}
			node = node.children.get(key[i]);
		}
		
		return (node != null && node.isLeaf);
	}
	
	public static void delete(){
		
	}
	
	public static void main(String[] args) {
		
	}
}
