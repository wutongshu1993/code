package leeCode;
/**
 * iven a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
 * @author lh
 *
 */
public class SumRootToLeafNumbers {
	 public int sumNumbers(TreeNode root) {
	     return dfs(root, 0, "", 0);
	    }
	 
	 public int dfs(TreeNode root, int sum, String ret, int temp){
		 if(root == null){
			 return 0;
		 }
		 if(root.left == null && root.right == null){
			 ret += root.val;
			 sum += Integer.parseInt(ret);//本条路径的值
			 sum += temp;
			 return sum;
		 }
		 ret += root.val;
		 if(root.left != null){
			temp = dfs(root.left, sum, ret, temp);//temp用于存储前面所有路径的值
		 }
		
		 if (root.right != null) {
			 temp = dfs(root.right, sum, ret, temp);
		}
		return temp;
	 }
	 
	 public static void main(String[] args){
		 TreeNode t1 = new TreeNode(1);
		 TreeNode t2 = new TreeNode(2);
		 TreeNode t3 = new TreeNode(3);
		 TreeNode t4 = new TreeNode(4);
		 TreeNode t5 = new TreeNode(5);
		 TreeNode t6 = new TreeNode(6);
		 t1.left = t2;
		 t1.right = t3;
		 t2.right = t4;
		 t2.left = t5;
//		 t2.right = t6;
		 t3.right = t6;
		 System.out.println(new SumRootToLeafNumbers().sumNumbers(t1));
	 }
}

/**
 * 答案
 *public int sumNumbers(TreeNode root) {
	return sum(root, 0);
}

public int sum(TreeNode n, int s){
	if (n == null) return 0;
	if (n.right == null && n.left == null) return s*10 + n.val;
	return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
}
 */
