package leeCode;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import leeCode.IsSameTree.TreeNode;

/**
 * Given a binary tree, return the bottom-up level order 
 * traversal of its nodes' values.
 *  (ie, from left to right, level by level from leaf to root).
 * @author lh
 *
 */
public class LevelOrderBottom {
public List<List<Integer>> levelOrderBottom(TreeNode root) {
//	Stack<List<TreeNode>> stack = new Stack<>();
	List<List<Integer>> list = new ArrayList<>();
	List<List<Integer>> list3 = new ArrayList<>();
	List<Integer> list2 = new ArrayList<>();
	if (root == null) return list3;
	Queue<TreeNode> q = new LinkedList<>();
	q.offer(root);
	while(!q.isEmpty()){
		int size = q.size();
		for(int i=0;i<size;i++){
			TreeNode node = q.poll();
			if (node!=null) {
				list2.add(node.val);
				if (node.left!=null && node.right!=null) {
					q.offer(node.left);
					q.offer(node.right);
				}
				else if (node.left!=null ) {
					q.offer(node.left);
				}
				else if (node.right!=null ) {
					q.offer(node.right);
				}
			}
		}
		
		List<Integer> list4 = new ArrayList<>();
		for(int i=0;i<list2.size();i++)
		{
			list4.add(list2.get(i));
		}
		list.add(list4);
		list2.clear();
	}
	for(int i=list.size()-1;i>=0;i--){
		list3.add(list.get(i));
	}
	return list3;
		
}
public static void main(String[] args){
	TreeNode p = new TreeNode(1);
//	TreeNode q = new TreeNode(1);
	TreeNode p1 = new TreeNode(2);
	TreeNode p2 = new TreeNode(3);
//	TreeNode p3 = new TreeNode(4);
//	TreeNode p4 = new TreeNode(5);
//	TreeNode p5 = new TreeNode(6);
//	TreeNode q1 = new TreeNode(2);
//	TreeNode q2 = new TreeNode(3);
//	TreeNode q3 = new TreeNode(4);
//	TreeNode q4 = new TreeNode(5);
//	TreeNode q5 = new TreeNode(6);
	p.left = p1;
	p.right = p2;
//	p1.left = p3;
//	p1.right = p4;
//	p3.left = p5;
//	q.left = q1;
//	q.right = q2;
//	q1.left = q3;
//	q1.right = q4;
//	q3.right = q5;
	List<List<Integer>> list = new LevelOrderBottom().levelOrderBottom(p);
}
}
