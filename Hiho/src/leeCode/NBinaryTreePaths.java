package leeCode;

import java.util.ArrayList;
import java.util.List;

public class NBinaryTreePaths {
	List<String> res = new ArrayList<>();
public List<String> binaryTreePaths(TreeNode root){
	if (root==null) {
		return null;
	}
	findPaths(root, String.valueOf(root.val));
	return res;
}

	
private void findPaths(TreeNode node ,String path){
	if (node.left==null && node.right==null) {
		res.add(path);
	}
	if (node.left!=null) {
		findPaths(node.left, path+"->"+node.left.val);
	}
	if (node.right!=null) {
		findPaths(node.right,path+"->"+node.right.val);
	}
}

public static void main(String[] args){
	TreeNode root = new TreeNode(1);
	TreeNode n4 = new TreeNode(4);
	TreeNode n2 = new TreeNode(2);
	TreeNode n3 = new TreeNode(3);
	root.left = n2;
	root.right = n3;
	n2.right = n4;
	System.out.println(new NBinaryTreePaths().binaryTreePaths(root));
}
}
