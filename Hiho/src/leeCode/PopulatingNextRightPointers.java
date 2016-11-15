package leeCode;

import java.util.LinkedList;
import java.util.List;

/**
 * For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 * @author lh
 *我的想法是，先进行层序遍历，然后再对每一层进行处理，建立连接
 */
class TreeLinkNode {
     int val;
     TreeLinkNode left, right, next;
     TreeLinkNode(int x) { val = x; }
 }
public class PopulatingNextRightPointers {
	 public void connect(TreeLinkNode root) {
	     List<List<TreeLinkNode>> list = new LinkedList<>();
	     if(root == null){return;}
		 dfs(list, root, 0); 
		 root.next = null;
		 for(int i = 1; i < list.size(); i++){
			 list.get(i).get(list.get(i).size() - 1).next = null;
		 }
//		 for(int i = 0; i < list.size(); i++){
//			 List<TreeLinkNode> temp = list.get(i);
//			 for(int j = 0; j < temp.size(); j++){
//				 if(j == temp.size() - 1){
//					 temp.get(j).next = null;
//				 }
//				 else {
//					 temp.get(j).next = temp.get(j + 1);
//				}
//				 
//			 }
//		 }
	    }
 	public void dfs(List<List<TreeLinkNode>> list, TreeLinkNode node, int level){
 		if(node == null){
			return;
		} 
 		if(level >= list.size()){
			 List<TreeLinkNode> newList = new LinkedList<>();
			 list.add(newList);
		 }
 		List<TreeLinkNode> temp = list.get(level);
		 if(temp.size() > 0){
			 temp.get(temp.size() - 1).next = node;
		 }
		 temp.add(node);
		 
		 dfs(list, node.left, level + 1);
		 dfs(list, node.right, level + 1);
 	}
}
