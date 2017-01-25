package offer;

import java.awt.Robot;

/**
 * ����һ�ö��������жϸö������Ƿ���ƽ���������
 * @author lh
 *
 */
public class IsBalanced {
	private boolean isBalanced = true;
	 public boolean IsBalanced_Solution(TreeNode root) {
	     if(root == null){
	    	 return true;
	     }  
	     int left = dfs(root.left);
	     int right = dfs(root.right);
	     if(Math.abs(left - right) > 1){
	    	 return false;
	     }
	     
		 return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
	    }
	 public int dfs(TreeNode root){
		 if(root == null){
			 return 0;
		 }
		 
		 TreeNode left = root.left;
		 TreeNode right = root.right;
		 int left_len = dfs(left);
		 
		 int right_len = dfs(right);
		 return Math.max(left_len+1, right_len+1);
	 }
	 
	 //�ڶ��ַ��������ú��������˼�룬����ÿ���ڵ�֮ǰ���Ѿ������������������������������������ƽ��ģ�����ƽ��ġ�
	
	 public int dfs2(TreeNode root){
		 if(root == null){
			 return 0;
		 }
		 
		 TreeNode left = root.left;
		 TreeNode right = root.right;
		 int left_len = dfs2(left);
		 
		 int right_len = dfs2(right);
		 if(Math.abs(left_len - right_len) > 1){
			 isBalanced = false;
		 }
		 return Math.max(left_len+1, right_len+1);
	 }
	 
	 public boolean isBalabced(TreeNode node){
		 dfs2(node);
		 return isBalanced;
	 }
}
