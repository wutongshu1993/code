package leeCode;

import java.util.LinkedList;

import util.TreeNode;

public class SumOfLeftLeaves {
	int sum = 0;
	LinkedList<TreeNode> linkedList = new LinkedList<>();
public int sumOfLeftLeaves(TreeNode root) {
    dfs(root); 
    while (linkedList.size() > 0) {
		if(linkedList.peek().left == null && linkedList.peek().right == null){
			sum += linkedList.peek().val;
			linkedList.pop();
		}
		else {
			linkedList.pop();
		}
	}
	return sum;
    }
public void dfs(TreeNode root){
	if(root == null){
		return ;
	}
	if(root.left != null){
		//sum += root.left.val;
		linkedList.push(root.left);
		dfs(root.left);
	}
	if (root.right != null) {
		//sum += root.right.val;
		dfs(root.right);
	}
	
	
}

public static void main(String[] args){
	TreeNode root = new TreeNode(3);
	root.left = new TreeNode(9);
	root.right = new TreeNode(20);
	root.right.left = new TreeNode(15);
	root.right.right = new TreeNode(7);
	SumOfLeftLeaves sumOfLeftLeaves = new SumOfLeftLeaves();
	System.out.println(sumOfLeftLeaves.sumOfLeftLeaves(root));
}
}
