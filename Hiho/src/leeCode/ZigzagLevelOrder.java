package leeCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ZigzagLevelOrder {
	/**
	 * Z字层序遍历二叉树，第一行从左到右，第二层从右到左。
	 * For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
	 * @param root
	 * @return
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		LinkedList<List<Integer>> res = new LinkedList<>();
		travel(root, res, 0);
		return res;
	}
	/**
	 * 
	 * @param cur 当前要插入的节点
	 * @param sol 最后返回的结果
	 * @param level 当前的层数
	 */
	 public void travel(TreeNode cur, LinkedList<List<Integer>> sol, int level){
		 if(cur == null){
			 return ;
		 }
		 
		 if(sol.size() <= level){
			 List<Integer> newLevel = new LinkedList<>();
			 sol.add(newLevel);
		 }
		 List<Integer> collection = sol.get(level);
		 if(level % 2 == 0){
			 collection.add(cur.val);
		 }
		 else {
			collection.add(0, cur.val);
		}
		 travel(cur.left, sol, level + 1);
		 travel(cur.right, sol, level + 1);
	 }
	
}
