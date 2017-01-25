package offer;
/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 想法：交换根节点的左右孩子，继续交换子节点的左右孩子 
 * @author lh
 *
 */
public class GetSymmetricTree {
	 public void Mirror(TreeNode root) {
	        if(root == null){
	        	return ;
	        }
	        TreeNode left = root.left;
	        root.left = root.right;
	        root.right = left;
	        Mirror(root.left);
	        Mirror(root.right);
	    }
	 public static void main(String[] args){
		TreeNode n1 = new TreeNode(8);
		TreeNode n2 = new TreeNode(6);
		TreeNode n3 = new TreeNode(10);
		TreeNode n4 = new TreeNode(5);
		TreeNode n5 = new TreeNode(7);
		TreeNode n6 = new TreeNode(9);
		TreeNode n7 = new TreeNode(11);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		new GetSymmetricTree().Mirror(n1);
		System.out.println(n1);
	 }
}

