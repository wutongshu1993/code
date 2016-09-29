package leeCode;

import java.util.LinkedList;

import util.TreeNode;

/**
 * �ж�һ�����Ƿ��Ƕ����ѯ��,
 * ���뵽�İ취�ǣ��ȶ���������������������������Ľ������list�����ж�list�Ƿ��ǰ��յ���˳�����С�
 * ����ѧ������dfs֮��ĵݹ��㷨�з���һ��ֵ��
 * 
 * @author lh
 *
 */
public class IsValidBST {
	LinkedList<TreeNode> list = new LinkedList<>(); 
	public boolean isValidBST(TreeNode root) {
//       if(root == null || (root.left == null && root.right == null)){
//    	   return true;
//       }
//		midOrder(root);
//        for(int i = 1; i < list.size(); i++){
//        	if(list.get(i).val <= list.get(i - 1).val){
//        		return false;
//        	}
//        }
//		return true;
		return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);//Ϊʲô��double֮��0�Ͳ���ͨ����
    }
	public boolean dfs(TreeNode root, long min, long max){
		if(root == null){
			return true;
		}
		if (root.val >= max || root.val <= min) {
			return false;
		}
		return dfs(root.left, min, root.val) && dfs(root.right, root.val, max) ;
	}
	
	public void midOrder(TreeNode root){
		if(root == null){
			return;
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
		root.left.right = new TreeNode(1);
		System.out.println(new IsValidBST().isValidBST(root));
	}
}
