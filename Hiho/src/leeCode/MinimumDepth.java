package leeCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import leeCode.Main.Node;



/**
 * minimum depth of binary tree
 * 
 * @author Administrator
 * 
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
public class MinimumDepth {
	
	 public int minDepth(TreeNode root) {
	     int r_minDepth = Integer.MAX_VALUE,l_minDepth=Integer.MAX_VALUE,minDepth=Integer.MAX_VALUE;
		 if (root == null) return 0;
	     if (root.left==null && root.right==null) return 1;
	     
	     if (root.left!=null && root.right==null) {
	    	 l_minDepth = minDepth(root.left)+1;
		}
	     if (root.left==null && root.right!=null) {
	    	 r_minDepth = minDepth(root.right)+1;
		}
//	     if(root.left==null || root.right==null) return 2;
	     else if (root.left!=null && root.right!=null){
	      l_minDepth = minDepth(root.left)+1;
	      r_minDepth = minDepth(root.right)+1;
	     }
	     minDepth =  Math.min(r_minDepth, l_minDepth);
	     return minDepth;
//		 return Math.min(minDepth(root.left),minDepth(root.right));
	    }
	 /**
	  * 用BFS应该怎么做呢
	  * 
	  * @param root
	  * @return
	  */
	 public int minDepthBFS(TreeNode root) {
		 int r_minDepth = 0,l_minDepth=0;
		 LinkedList<TreeNode> list = new LinkedList<>();
		 bfs(root, list, l_minDepth, r_minDepth);
		 return Math.min(l_minDepth, r_minDepth);
	 }
	 
	 public void bfs(TreeNode root, LinkedList<TreeNode> list, int left_depth, int right_depth){
		if (root == null) {
			return ;
		} 
		
		list.add(root.left);
		left_depth ++;
		list.add(root.right);
		right_depth ++;
		bfs(list.remove(), list, left_depth, right_depth);
		
	 }

	 public static void main(String[] args){
		MinimumDepth m = new MinimumDepth();
		 TreeNode t1 = new TreeNode(1);
		 TreeNode t2 = new TreeNode(2);
		 TreeNode t3 = new TreeNode(3);
		 TreeNode t4 = new TreeNode(4);
		 TreeNode t5 = new TreeNode(5);
		 TreeNode t6 = new TreeNode(6);
		 t1.left = t2;
		 t1.right = t3;
		 t2.left = t4;
		 t4.left = t5;
		 t2.right = t6;
		 t3.right = t6;
		 System.out.println(m.minDepthBFS(t1));
	 }
}
