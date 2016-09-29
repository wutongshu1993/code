package leeCode;

import java.util.LinkedList;
import java.util.List;

public class LevelOrder {
public List<List<Integer>> levelOrder(TreeNode root) {
	List<List<Integer>> res = new LinkedList<>();
	travel(root, res, 0);
	return res;  
    }

public void travel(TreeNode cur, List<List<Integer>> res, int level){
	if(cur == null){
		return ;
	}
	if(res.size() <= level){
		List<Integer> newLevel = new LinkedList<>();
		res.add(newLevel);
	}
	List<Integer> collection = res.get(level);
	collection.add(cur.val);
	travel(cur.left, res, level + 1);
	travel(cur.right, res, level + 1);
}

}
