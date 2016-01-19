package leeCode;
import leeCode.IsSameTree.TreeNode;;
public class InvertBTree {
public TreeNode invertTree(TreeNode root){
	if (root !=null ) {
//		TreeNode left = root.left;
//		TreeNode right = root.right;
//		TreeNode temp;
//		temp = left;
//		left = right;
//		right = temp;
//		root.left = left;
//		root.right = right;
//		temp = null;
//		invertTree(right);
//		invertTree(left);//上面的速度慢于下面的
		TreeNode temp = root.left;
	    root.left = root.right;
	    root.right = temp;
		temp = null;
		invertTree(root.left);
		invertTree(root.right);
	}
	
	
	
	return root;
}
}
