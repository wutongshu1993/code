package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * @author lh
 *
 */
public class FindPath {
public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
	 ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	    ArrayList<Integer> temp = new ArrayList<>();
	    dfs(res, temp, 0, target,root);
		return res;
    }

public void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int val, int sum, TreeNode root ){
	if(root == null){
		temp.add(0);
		return;
	}
	val += root.val;
	temp.add(root.val);
	if(root.left == null && root.right == null){//叶子节点
		if (val == sum) {
			res.add(new ArrayList<>(temp));
		}
		return ;
	}
	dfs(res, temp, val, sum, root.left);
	temp.remove(temp.size() -1 );
	dfs(res, temp, val, sum, root.right);
	temp.remove(temp.size() -1 );
}
}
