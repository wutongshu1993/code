package leeCode;

import leeCode.IsSameTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
//看的答案
public class NSymmetricTree {
public boolean mirror(TreeNode p, TreeNode q){
	if (p==null && q==null) return true;
	if (p==null || q==null) return false;
	if (p.val != q.val) return false;
	return mirror(p.left, q.right) && mirror(p.right, q.left);
	
}
public boolean isSymmetric(TreeNode root){
	return mirror(root.left, root.right);
}
//另一种方法，用队列实现
public boolean isSymmetric2(TreeNode root){
	if (root==null) {
		return false;
	}
	Queue<TreeNode> q = new  LinkedList<>();
	q.offer(root);
	while(!q.isEmpty()){
		int size = q.size();
		String[] arr = new String[size];
		for(int i=0;i<size;i++){
			TreeNode node = q.poll();
			if (node!=null) {
				arr[i] = node.val+"";
				q.offer(node.left);
				q.offer(node.right);
			}
			else {
				arr[i] ="X";
			}
		}
		int l=0,r=size-1;
		while(l<r){
		if(arr[l++].equals(arr[r--])) {
			return true;
		}
		return false;
	}
	
}
	return true;
}
}