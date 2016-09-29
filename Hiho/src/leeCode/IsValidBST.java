package leeCode;

import java.util.LinkedList;

import util.TreeNode;

/**
 * 判断一个树是否是二叉查询树,
 * 我想到的办法是：先对这棵树进行中序遍历，将遍历后的结果存入list，再判断list是否是按照递增顺序排列。
 * 总是学不会在dfs之类的递归算法中返回一个值。
 * 
 * @author lh
 *
 */
public class IsValidBST {
	LinkedList<TreeNode> list = new LinkedList<>(); 
	public boolean isValidBST(TreeNode root) {
//       if(root == null || (root.left == null && root.right == null)){
//    	   return true;
//       }
//		midOrder(root);
//        for(int i = 1; i < list.size(); i++){
//        	if(list.get(i).val <= list.get(i - 1).val){
//        		return false;
//        	}
//        }
//		return true;
		return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);//为什么改double之后0就不能通过了
    }
	public boolean dfs(TreeNode root, long min, long max){
		if(root == null){
			return true;
		}
		if (root.val >= max || root.val <= min) {
			return false;
		}
		return dfs(root.left, min, root.val) && dfs(root.right, root.val, max) ;
	}
	
	public void midOrder(TreeNode root){
		if(root == null){
			return;
		}
		midOrder(root.left);
		list.add(root);
		midOrder(root.right);
		
	}
	public static void main(String[] args){
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(1);
		System.out.println(new IsValidBST().isValidBST(root));
	}
}
