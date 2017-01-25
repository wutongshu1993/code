package leeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HouseRobber {
	/**
	 * 给一个数组代表每个房间的财产数量，不能偷相邻的两家，最多可以偷多少
	 * @param nums
	 * @return
	 */
public int rob(int[] nums){
	int rob = 0;
	int noRob = 0;
	int max = 0;
	for(int i=0;i<nums.length;i++){
		rob = noRob + nums[i];
		noRob = max;
		max = Math.max(rob, noRob);
	}
	
	return max;
}
/**
 * 在1的基础上，所有房子围成一个环形，所以第一家和最后一家不能同时偷，最多可以偷多少财物
 * @param nums
 * @return
 */

public int rob2(int[] nums) {
	
	
	if(nums.length == 1){
		return nums[0];
	}
	
	
	int rob1 = 0;
	int noRob1 = 0;
	int max1 = 0;
	
	
	for(int i=0;i<nums.length - 1;i++){
		rob1 = noRob1 + nums[i];
		noRob1 = max1;
		max1 = Math.max(rob1, noRob1);
	}
	
	
	int rob = 0;
	int noRob = 0;
	int max = 0;
	for(int i=1;i<nums.length;i++){
		rob = noRob + nums[i];
		noRob = max;
		max = Math.max(rob, noRob);
	}
	
	return Math.max(max, max1);
}
/**
 * 一个二叉树，隔层遍历，求最大值，想法，先进行层序遍历，再将每一层的和单独放在一个数组里，再利用rob1求这个数组的rob
 * 
 * !!!!!想错了，是不能偷两个有边相连的二叉树
 * 所以就
 * @param root
 * @return
 */
//public int rob3(TreeNode root) {
//	List<Integer> list = new ArrayList<>();
//	dfs(root, list, 0);
//	
//	int[] nums = new int[list.size()];
//	
//	for(int i = 0; i< nums.length; i++){
//		nums[i] = list.get(i);
//	}
//	int max = rob(nums);
//	return max;
//}
//超时，存在一个问题---会计算root.left root.right root.left.left left.left.right root.right.left root.right.right，但是
//在计算root.right的时候也需要计算root.right.left和root.right.right ---重叠子问题
public int rob3(TreeNode root){
	if(root == null){
		return 0;
	}
	int val = 0;
	if(root.left != null){
		val += rob3(root.left.left) + rob3(root.left.right);
	}
	if(root.right !=  null){
		val += rob3(root.right.left) + rob3(root.right.right);
	}
	return Math.max(root.val + val, rob3(root.left) + rob3(root.right));
}

public int rob3_2(TreeNode root){
	Map<TreeNode, Integer> map = new HashMap<>();
	return rubSub(root, map);
	
}
//将每次计算的值存在map里面，Map<TreeNode, Integer>
public int rubSub(TreeNode root, Map<TreeNode, Integer> map){
	int val = 0;
	if(root == null){
		return 0;
	}
	if(map.get(root) != null){
		return map.get(root);
	}
	if(root.left != null){
		val += rubSub(root.left.left, map) + rubSub(root.left.right, map);
	}
	if(root.right != null){
		val += rubSub(root.right.left, map) + rubSub(root.right.right, map);
	}
	val = Math.max(val + root.val, rubSub(root.left, map) + rubSub(root.right, map));
	map.put(root, val);
	return val;
}
/**
 * 第三种方法：每个点都有两种状态---抢或者不抢，因此对状态rub(root)定义如下：返回一个数组，数组包含两个元素，分别表示不抢root和抢root,
 * 然后root的第一个元素是的值是rob(root.left)返回的较大值 + rob(root.right)返回的较大值 之和，
 * root的第二个元素为root.val + rob(root.left)[0] + rob(root.right)[0]
 * 
 */
public int rob(TreeNode root){
	int[] res = rubSub(root); 
	return Math.max(res[0], res[1]);
}
public int[] rubSub(TreeNode root){
	if(root == null){
		return new int[2];
	}
	
	int[] left = rubSub(root.left);
	int[] right = rubSub(root.right);
	int[] arr = new int[2];
	arr[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
	arr[1] = root.val + left[0] + right[0];
	return arr;
}
public void dfs(TreeNode node, List<Integer> list, int level) {
	if(node == null){
		return;
	}
	if(list.size() <= level){
		list.add(0);
	}
	
	list.set(level, list.get(level) + node.val);
	dfs(node.left, list, level + 1);
	dfs(node.right, list, level + 1);
	
}
public static void main(String[] args){
	int[] nums = {4,2,3,9};
	int a = new HouseRobber().rob(nums);
	
	
	TreeNode root = new TreeNode(2);
	TreeNode node1 = new TreeNode(1);
	TreeNode node2 = new TreeNode(3);
	TreeNode node3 = new TreeNode(4);
	
	
	root.left = node1;
	root.right = node2;
	node1.left = node3;
	

	
	
	System.out.println(new HouseRobber().rob3(root));
}
}
