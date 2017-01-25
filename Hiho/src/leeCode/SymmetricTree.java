package leeCode;

import java.util.ArrayList;
import java.util.List;

/**
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
 * @author lh
 *想法，即对这个树进行中序遍历，遍历的结果是一个对称的集合就满足条件
 */
public class SymmetricTree {
public boolean isSymmetric(TreeNode root) {
     List<Integer> list = new ArrayList<>();
     //有一个很奇葩的输入：1,2,3,3,NULL,2,3,NULL，中序是对称的，但是事实上不是
     
     if(root == null){return true;};
     if(root.left !=null && root.right != null){
    	 if(root.left.val != root.right.val){
    		 return false;
    	 }
     }
     
     
     midOrder(root, list);
     //判断list是否对称
    int p = 0;
    int q = list.size() - 1;
    while( p <= q){
    	if(list.get(p) == list.get(q)){
    		p++;
    		q--;
    	}
    	else {
			return false;
		}
    }
	return true;
    }
public void midOrder(TreeNode root, List<Integer> list){
	if(root == null){
		return ;
	}
	if (root.left != null) {
		midOrder(root.left, list);
	}
	list.add(root.val);
	if(root.right != null){
		midOrder(root.right, list);
	}
}

public static void main(String[] args){
	TreeNode root = new TreeNode(1);
	TreeNode node1 = new TreeNode(2);
	TreeNode node2 = new TreeNode(2);
	TreeNode node3 = new TreeNode(3);
	TreeNode node4 = new TreeNode(3);
	TreeNode node5 = new TreeNode(4);
	TreeNode node6 = new TreeNode(4);
	root.left = node1;
	root.right = node2;
	node1.left = node3;
	node1.right = node5;
	node2.right = node4;
	node2.left = node6;
	System.out.println(new SymmetricTree().isSymmetric(root));
}
/**
 * 答案中较好的解法
 * public boolean isSymmetric(TreeNode root) {
    return root==null || isSymmetricHelp(root.left, root.right);
}

private boolean isSymmetricHelp(TreeNode left, TreeNode right){
    if(left==null || right==null)
        return left==right;
    if(left.val!=right.val)
        return false;
    return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
}
 */
}
