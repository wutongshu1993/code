package leeCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
第一种做法：先从右向左层序遍历，再将每一层的第一个数取出，放入list,
第二种做法：在dfs里面放入。
第三种做法：当list和level相等的时候放入，就不把层序遍历的结果保存下来了
 * @author lh
 *
 */
public class BinaryTreeRightSideView {
public List<Integer> rightSideView(TreeNode root) {
    List<Integer> ret = new ArrayList<>();
    List<List<Integer>> list = new LinkedList<>();
//    dfs(list, root, 0);
//    for(int i = 0; i < list.size(); i++){
//    	ret.add(list.get(i).get(0));
//    }
    dfs2(list, root, 0, ret);
	return ret;
    }
public void dfs(List<List<Integer>> list, TreeNode node, int level){
	if(node == null){
		return ;
	}
	if(level >= list.size()){
		List<Integer> newlist = new LinkedList<>();
		list.add(newlist);
	}
	List<Integer> collection = list.get(level);
	collection.add(node.val);
	dfs(list, node.right, level+1);
	dfs(list, node.left, level+1);
	
}
public void dfs2(List<List<Integer>> list, TreeNode node, int level, List<Integer> ret){
	if(node == null){
		return ;
	}
	if(level >= list.size()){
		List<Integer> newlist = new LinkedList<>();
		list.add(newlist);
	}
	List<Integer> collection = list.get(level);
	collection.add(node.val);
	if(collection.size() == 1){
		ret.add(collection.get(0));
	}
	dfs2(list, node.right, level+1, ret);
	dfs2(list, node.left, level+1, ret);
	
}

public void dfs3 (List<Integer> ret, TreeNode node, int level){
	if(node == null){
		return;
	}
	if(level == ret.size()){
		ret.add(node.val);
	}
	dfs3(ret, node.right, level + 1);
	dfs3(ret, node.left, level + 1);
}

public static void main(String[] args){
	TreeNode root = new TreeNode(1);
	TreeNode node1 = new TreeNode(2);
	TreeNode node2 = new TreeNode(3);
	TreeNode node3 = new TreeNode(5);
	TreeNode node4 = new TreeNode(4);
	root.left = node1;
	root.right = node2;
//	node1.left = node4;
	node1.right = node3;
	new BinaryTreeRightSideView().rightSideView(root);
}

}
