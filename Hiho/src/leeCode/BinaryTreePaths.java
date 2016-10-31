package leeCode;

import java.util.ArrayList;
import java.util.List;
/**
 * Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
其实就是一个深度遍历，依次将遍历到的节点加入到返回的结果中,
有一点需要注意，在递归左子树之前，需要先保存temp的长度，在递归之后需要设置temp的长度
 * @author lh
 *
 */
public class BinaryTreePaths {
public List<String> binaryTreePaths(TreeNode root) {
    List<String> res = new ArrayList<>(); 
	StringBuilder temp = new StringBuilder();   
	dfs(root, res, temp);
	return res;
    }
public void dfs(TreeNode root, List<String> res, StringBuilder temp){
	if(root == null){
		return;
	}
	temp.append("->"+root.val);
	if(root.left == null && root.right == null){ 
		
		res.add((temp.toString()).substring(2));
	}
	int oriLen = temp.length();
	dfs(root.left, res, temp);
	temp.setLength(oriLen);
	dfs(root.right, res, temp);
}
public static void main(String[] args){
	TreeNode root = new TreeNode(1);
	TreeNode node1 = new TreeNode(2);
	TreeNode node2 = new TreeNode(3);
	TreeNode node3 = new TreeNode(5);
	TreeNode node4 = new TreeNode(4);
	root.left = node1;
	root.right = node2;
	node1.left = node4;
	node1.right = node3;
	node2.left = null;
	node2.right = null;
	new BinaryTreePaths().binaryTreePaths(root);
}
}

