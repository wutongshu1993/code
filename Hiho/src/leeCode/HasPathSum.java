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
�ҵ��뷨���Ƚ�����ȱ�������ÿ��һ��Ҷ�ӽڵ���ۺϼ�¼��list�У����������list��������û�к͸���sum���
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
	if(root.left == null && root.right == null){//Ҷ�ӽڵ�
		leftSum.add(sum + root.val);
		return;
	}
	sum += root.val;
	dfs(root.left, sum , leftSum);
	dfs(root.right, sum , leftSum);
}
}
/**
 *��һ�ֽⷨ��ÿ����һ���㣬�ͽ���ǰ��sumֵ��һ����Ҷ�ӽڵ��ʱ���ж�sumֵ�Ƿ�Ϊ��
 *public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
    
        if(root.left == null && root.right == null && sum - root.val == 0) return true;
    
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    } 
*/