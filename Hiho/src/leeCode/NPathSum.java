package leeCode;

import java.util.ArrayList;
import java.util.List;

import leeCode.IsSameTree.TreeNode;

public class NPathSum {
	 public boolean hasPathSum(TreeNode root, int sum) {
//	     List<Integer> list = new ArrayList<>();
//	     if (root!=null) {
//	    	 list.add(root.val);
//		     hasPathSum(root.left, sum);
//		     hasPathSum(root.right, sum);
//		}
//	     
//	     
//		 
//		 return false;
		 if(root == null) return false;
		    if(root.val == sum && root.left == null && root.right == null) return true;
		    return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
	    }
	List<List<Integer>> list = new ArrayList<>();
	 List<Integer> list2 = new ArrayList<>();
	 public List<List<Integer>> dfsTree(TreeNode root){
		 if (root != null) {
			list2.add(root.val);
			if (root.left!=null) {
				dfsTree(root.left);
			}
			List<Integer> list3 = new ArrayList<>();
			for(int i : list2){
				list3.add(i);
			}
			list.add(list3);
			list2.clear();
			if (root.right != null) {
				dfsTree(root.right);
			}
			List<Integer> list4 = new ArrayList<>();
			for(int i : list2){
				list4.add(i);
			}
			list.add(list4);
			list2.clear();
		}
		 return list;
	 }
	public static void main(String[] args){
		TreeNode p = new TreeNode(1);
		TreeNode p1 = new TreeNode(2);
		TreeNode p2 = new TreeNode(3);
		TreeNode p3 = new TreeNode(4);
		TreeNode p4 = new TreeNode(5);
		TreeNode p5 = new TreeNode(2);
		p.left = p1;
		p.right = p2;
		p1.left = p3;
		p1.right = p4;
		p2.left = p5;
		List<List<Integer>> list = new NPathSum().dfsTree(p);
	} 
}
