package leeCode;

import java.util.LinkedList;
import java.util.List;

public class FlatternBinaryTree {
public void flatten(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        dfs(root, list);
        root = list.peek();
        while(!list.isEmpty()){
        	TreeNode temp = list.poll();
        	temp.left = null;
        	temp.right = list.peek();
        }
    }
public void dfs(TreeNode root, List<TreeNode> list){
	if(root == null){
		return ;
	}
	list.add(root);
	dfs(root.left, list);
	dfs(root.right, list);
}


}
