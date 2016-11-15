package leeCode;

import java.util.ArrayList;
import java.util.List;
/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
我的想法是先进行深度遍历，将每到一个叶子节点的综合记录到list中，最后遍历这个list，看看有没有和给的sum相等
 * @author lh
 *
 */
public class HasPathSum {
public boolean hasPathSum(TreeNode root, int sum) {
    if(root == null){
    	return false;
    } 
    List<Integer> res = new ArrayList<>();
    dfs(root, 0, res);
    for(int i = 0; i < res.size(); i++){
    	if(res.get(i) == sum){
    		return true;
    	}
    }
	return false; 
    }

public void dfs(TreeNode root, int sum, List<Integer> leftSum){
	if(root == null){
		return;
	}
	if(root.left == null && root.right == null){//叶子节点
		leftSum.add(sum + root.val);
		return;
	}
	sum += root.val;
	dfs(root.left, sum , leftSum);
	dfs(root.right, sum , leftSum);
}
}
/**
 *另一种解法是每遍历一个点，就将当前的sum值减一，到叶子节点的时候，判断sum值是否为零
 *public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
    
        if(root.left == null && root.right == null && sum - root.val == 0) return true;
    
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    } 
*/