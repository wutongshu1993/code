package leeCode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


import leeCode.IsSameTree.TreeNode;

/**
 * Given a binary tree, return the bottom-up level order 
 * traversal of its nodes' values.
 *  (ie, from left to right, level by level from leaf to root).
 * @author lh
 *
 */
public class LevelOrderBottom {
public List<List<Integer>> levelOrderBottom(TreeNode root) {
//	Stack<List<TreeNode>> stack = new Stack<>();
	List<List<Integer>> list = new ArrayList<>();
	List<List<Integer>> list3 = new ArrayList<>();
	List<Integer> list2 = new ArrayList<>();
	if (root == null) return list3;
	Queue<TreeNode> q = new LinkedList<>();
	q.offer(root);
	while(!q.isEmpty()){
		int size = q.size();
		for(int i=0;i<size;i++){
			TreeNode node = q.poll();
			if (node!=null) {
				list2.add(node.val);
				if (node.left!=null && node.right!=null) {
					q.offer(node.left);
					q.offer(node.right);
				}
				else if (node.left!=null ) {
					q.offer(node.left);
				}
				else if (node.right!=null ) {
					q.offer(node.right);
				}
			}
		}
		
		List<Integer> list4 = new ArrayList<>();
		for(int i=0;i<list2.size();i++)
		{
			list4.add(list2.get(i));
		}
		list.add(list4);
		list2.clear();
	}
	Collections.reverse(list);
//	for(int i=list.size()-1;i>=0;i--){
//		list3.add(list.get(i));
//	}
	return list;
		
}
public static void main(String[] args){
	TreeNode p = new TreeNode(1);
	TreeNode p1 = new TreeNode(2);
	TreeNode p2 = new TreeNode(3);
	p.left = p1;
	p.right = p2;

	List<List<Integer>> list = new LevelOrderBottom().levelOrderBottom(p);
}
}
/**
 * 采用宽搜的思想 2ms
 List<TreeNode> toUse = new ArrayList<>();
 List<List<Integer>> retValue = new ArrayList<>();
    if( root != null)
    {
        toUse.add(root);
    }

    while (toUse.size() != 0)
    {
        List<Integer> result  = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        for (TreeNode node : toUse)
        {
            result.add(node.val);

            if (node.left != null)
            {
                next.add(node.left);
            }

            if (node.right != null)
            {
                next.add(node.right);
            }
        }
        retValue.add(result);
        toUse = next;            
    }
    Collections.reverse(retValue);
    return retValue;
    **/
