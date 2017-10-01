package companies;

public class RightTreeView {
	
		private static TreeNode tree,two,three,four,five,six,seven;
		private static int count = 0;
		
		public static void main(String []args){
			
			formTree();  	//create a dummy tree.
			rightView();    //Level of Traversal.
		
//			TreeNode obj1 = new TreeNode(1);
//
//			TreeNode obj2 = new TreeNode(1);
//			
//			Object o1,o2; o1 = o2 = null;
//
//			if(o1 == o2)
//			   System.out.println("o1==o2 is TRUE");
//			else
//			  System.out.println("o1==o2 is FALSE");
		}
		
		private static void rightView(){
			
			int height = height(tree);
			System.out.println("Height of the tree: "+height);
			for(int i=1;i<=height;i++){
				count = 0;
				printGivenLevel(tree, i, (int) Math.pow(2,i-1));
			}
		}
		
		//create few tree nodes and form a tree.
		private static void formTree(){
			
			//nodes.
			tree  = new TreeNode(1);
			two   = new TreeNode(2);
			three = new TreeNode(3);
			four  = new TreeNode(4);
			five  = new TreeNode(5);
			six   = new TreeNode(6);
			seven = new TreeNode(7);
			
			//inner nodes.
			tree.setLeft(two); tree.setRight(three);
			System.out.println(tree.getData());
			System.out.println(tree.getLeft());
			System.out.println(tree.getRight());
			
			two.setLeft(four); two.setRight(five);
			System.out.println(two.getData());
			System.out.println(two.getLeft());
			System.out.println(two.getRight());
			
			three.setLeft(six); //three.setRight(seven);
			System.out.println(three.getData());
			System.out.println(three.getLeft());
			System.out.println(three.getRight());
			
			//leaf nodes.
			four.setLeft(null);four.setRight(null);
			System.out.println(four.getData());
			System.out.println(four.getLeft());
			System.out.println(four.getRight());
			
			five.setLeft(null);five.setRight(null);
			System.out.println(five.getData());
			System.out.println(five.getLeft());
			System.out.println(five.getRight());
			
			six.setLeft(seven);six.setRight(null);
			System.out.println(six.getData());
			System.out.println(six.getLeft());
			System.out.println(six.getRight());
			
			seven.setLeft(null);seven.setRight(null);
			System.out.println(seven.getData());
			System.out.println(seven.getLeft());
			System.out.println(seven.getRight());
		}
		
		private static int height(TreeNode node){
			
			int lheight,rheight;
			
			if(node == null)
				return 0;
			else{
				
//				if(node.getLeft() == null){
//					
//					lheight = 0;
//				}else{
//					System.out.println("Hello World!");
					lheight = height(node.getLeft());
//				}
//				
//				if(node.getRight() == null){
//					rheight = 0;
//				}else{
					rheight = height(node.getRight());
//				}
			}
			
			if(lheight>rheight){
				return 1+lheight;
			}
			
			return 1+rheight;
		}
		
		
		private static void printGivenLevel(TreeNode node, int level, int end_idx){
			
			if(node == null)
				return;
			else if(level == 1){ 
				count++;
				if(count == end_idx)
					System.out.print(node.getData());
			}else{
				
				printGivenLevel(node.getLeft(), level-1, end_idx);
				printGivenLevel(node.getRight(), level-1, end_idx);
			}	
		}
}
