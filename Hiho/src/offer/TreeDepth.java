package offer;
/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * @author lh
 *
 */
public class TreeDepth {
	 public int TreeDepth(TreeNode root) {
	      return 0;  
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
	 
	 public static void main(String[] args){
		 TreeNode n1 = new TreeNode(1);
			TreeNode n2 = new TreeNode(2);
			TreeNode n3 = new TreeNode(3);
			TreeNode n4 = new TreeNode(4);
			TreeNode n5 = new TreeNode(5);
			TreeNode n6 = new TreeNode(6);
			TreeNode n7 = new TreeNode(7);
			n1.left = n2;
			n1.right = n3;
			n2.left = n4;
			n2.right = n5;
			n5.left = n7;
			n3.right = n6;
			System.out.println(new TreeDepth().dfs(n1));
	 }
}
