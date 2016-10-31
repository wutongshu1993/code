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
��ʵ����һ����ȱ��������ν��������Ľڵ���뵽���صĽ����,
��һ����Ҫע�⣬�ڵݹ�������֮ǰ����Ҫ�ȱ���temp�ĳ��ȣ��ڵݹ�֮����Ҫ����temp�ĳ���
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

