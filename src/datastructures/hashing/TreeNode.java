package datastructures.hashing;

/**
 * Basic node of a tree.
 * @author joy
 *
 */
public class TreeNode implements Comparable<TreeNode>{
	
	public int data;
	public TreeNode left, right;
	
	public TreeNode(int data){
		this.data = data;
	}

	@Override
	public int compareTo(TreeNode o) {
		// TODO Auto-generated method stub
		if(this.data > o.data)
			return 1;
		else if(this.data < o.data)
			return -1;
		return 0;
	}
}
