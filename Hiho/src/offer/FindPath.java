package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
 * ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
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
	if(root.left == null && root.right == null){//Ҷ�ӽڵ�
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
