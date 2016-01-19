package leeCode;

public class MaxDepthOfBTree {
	static int  max =0;
public class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x) {
		// TODO Auto-generated constructor stub
		val = x;
	}
}
public static int maxDepth(TreeNode root){

	if (root.left == null && root.right!= null) {
		root.right.val =root.val+1;
		root = root.right;
		maxDepth(root);
	}
	else if (root.right == null && root.left!= null) {
		root.left.val = root.val+1;
		root = root.left;
		maxDepth(root);
	}
	else if(root.right!= null && root.left!=null) {
		root.left.val = root.val+1;
		root.right.val = root.val+1;
		maxDepth(root.left);
		maxDepth(root.right);
	}
	else if(root.right == null && root.left==null) {
		if (max < root.val) {
			max = root.val;
		}
	}
	return max;
}


public static void main(String[] args){
	MaxDepthOfBTree tree = new MaxDepthOfBTree();
	TreeNode root = tree.new TreeNode(9);
	root.left = tree.new TreeNode(7);
	root.right = tree.new TreeNode(8);
	root.left.left = tree.new TreeNode(6);
	root.left.right = tree.new TreeNode(5);
	root.right.left = tree.new TreeNode(4);;
	root.right.right = tree.new TreeNode(3);
	root.left.left.left = tree.new TreeNode(2);
	root.left.left.left.left = tree.new TreeNode(2);
	root.val = 1;
	System.out.println(maxDepth(root));
}
}
