package leeCode;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    dfs(res, temp, 0, root, sum);
	return res;
    }
public void dfs(List<List<Integer>> res, List<Integer> temp, int val, TreeNode root, int sum){
	if(root == null){
		temp.add(0);
		return;
	}
	val += root.val;
	temp.add(root.val);
	if(root.left == null && root.right == null){//叶子节点
		if(val == sum){
			res.add(new ArrayList<>(temp));
		}
		
		return;
	}
	
	dfs(res, temp, val, root.left, sum);
	temp.remove(temp.size() - 1);//移除最后一个
	dfs(res, temp, val, root.right, sum);
	temp.remove(temp.size() - 1);//移除最后一个
}
public static void main(String[] args){
	TreeNode root = new TreeNode(5);
	TreeNode node2 = new TreeNode(4);
	TreeNode node3 = new TreeNode(8);
	TreeNode node4 = new TreeNode(11);
	TreeNode node5 = new TreeNode(13);
	TreeNode node6 = new TreeNode(4);
	TreeNode node7 = new TreeNode(7);
	TreeNode node8 = new TreeNode(2);
	TreeNode node9 = new TreeNode(5);
	TreeNode node10 = new TreeNode(1);
	root.left = node2;
	root.right = node3;
	node2.left = node4;
	node3.left = node5;
	node3.right = node6;
	node4.left = node7;
	node4.right = node8;
	node6.left = node9;
	node6.right = node10;
	new PathSum().pathSum(root, 22);
}
}
