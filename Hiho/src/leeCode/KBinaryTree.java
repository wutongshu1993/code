package leeCode;

import java.util.LinkedList;

import util.TreeNode;

/**
 * �ҳ�����������е�k�������.
 * �뷨��ֱ�Ӷ������������������Ϳ����ˡ����������ѱ��������ѹ�������ڣ���ȡ����k������
 * @author lh
 *
 */
public class KBinaryTree {
public TreeNode findKth(TreeNode root, int k){
	midOrder(root);
	return list.get(k);
}
LinkedList< TreeNode> list = new LinkedList<>();
LinkedList<TreeNode> result = new LinkedList<>();
//public TreeNode findMin(TreeNode root){
//	if(root == null){
//		return null;
//	}
//	list.push(root);
//	findMin(root.left);
//	return list.peek();
//}
/**
 * �������
 * @param root
 */
public void midOrder(TreeNode root){
	if (root == null) {
		return ;
	}
	
	midOrder(root.left);
	list.add(root);
	midOrder(root.right);
	
	
}
public static void main(String[] args){
	TreeNode root = new TreeNode(6);
	root.left = new TreeNode(4);
	root.right = new TreeNode(8);
	root.left.left = new TreeNode(3);
	root.left.right = new TreeNode(5);
	System.out.println(new KBinaryTree().findKth(root, 2).val);
}
}
