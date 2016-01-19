package leeCode;

import leeCode.MaxDepthOfBTree.TreeNode;;

public class IsBalanced {
public int getHeight(TreeNode root){
	if (root == null) {
		return 0;
	}
	if (root.left==null && root.right == null) {
		return 1;
	}
	return Math.max(getHeight(root.left), getHeight(root.right))+1;
	
}


	public boolean isBalanced(TreeNode root){
	if (root == null || (root.left== null && root.right==null) ){
		return true;
	}
	int left = getHeight(root.left);
	int right = getHeight(root.right);
	return Math.abs(right-left)<=1 && isBalanced(root.left)&&isBalanced(root.right);
}
public static void main(String[] args){
	MaxDepthOfBTree tree = new MaxDepthOfBTree();
	TreeNode root = tree.new TreeNode(9);
	root.left = tree.new TreeNode(7);
	root.right = tree.new TreeNode(8);
	root.left.left = tree.new TreeNode(6);
//	root.left.right = tree.new TreeNode(5);
//	root.right.left = tree.new TreeNode(4);;
	root.right.right = tree.new TreeNode(3);
	root.left.left.left = tree.new TreeNode(2);
	root.right.right.right = tree.new TreeNode(1);
//	root.left.left.left.left = tree.new TreeNode(2);
//	root.val = 1;
	System.out.println(new IsBalanced().isBalanced(root));
}
}


/*o(n)
 * public boolean isBalanced(TreeNode root) {
    if (root == null) return true;
    int depth = depth(root);
    if (depth == -1) return false;
    else return true;
}
private int depth(TreeNode root) {
    if (root == null) return 0;
    int left = depth(root.left);
    int right = depth(root.right);
    if (left == -1 || right == -1 || Math.abs(left-right) > 1) return -1;
    return Math.max(left,right)+1;
}*/
