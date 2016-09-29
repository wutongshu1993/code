package leeCode;

import java.util.Arrays;

public class BuildTree {
	 class TreeNode {
		     int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	 /**
	  * 根据中根遍历和后根遍历，生成树
	  * @param inorder
	  * @param postorder
	  * @return
	  */
//	public TreeNode buildTree(int[] inorder, int[] postorder) {
//		int num = inorder.length;
//		if (num==0) {
//			return null;
//		}
//		TreeNode root = new TreeNode(postorder[num - 1]);
//		int len_r = 0;
//		int len_l = 0;
//		for (int i = 0; i < inorder.length; i++) {
//			if (inorder[i] == root.val) {
//				len_l = i;
//				break;
//			}
//		}
//		len_r = num - len_l - 1;
//		if (len_l == 0) {
//			root.left = null;
//		} else {
//			int[] l_inorder = new int[len_l];
//			int[] l_postorder = new int[len_l];
//			l_inorder = Arrays.copyOfRange(inorder, 0, len_l);
//			l_postorder = Arrays.copyOfRange(postorder, 0, len_l);
//			/*for (int i = 0; i < len_l; i++) {
//				l_inorder[i] = inorder[i];
//				l_postorder[i] = postorder[i];
//			}*/
//			root.left = buildTree(l_inorder, l_postorder);
//		}
//		if (len_r == 0) {
//			root.right = null;
//		} else {
//			int[] r_inorder = new int[len_r];
//			int[] r_postorder = new int[len_r];
//			r_inorder = Arrays.copyOfRange(inorder, len_l+1, num);
//			r_postorder = Arrays.copyOfRange(postorder, len_l, num);
//			/*for (int i = 0; i < len_r; i++) {
//				r_inorder[i] = inorder[len_l + 1 + i];
//				r_postorder[i] = postorder[len_l + i];
//			}*/
//			root.right = buildTree(r_inorder, r_postorder);
//		}
//		/*if (len_l == 0 && len_r == 0) {
//			return root;
//		}*/
//
//		return root;
//	}
	/**
	 * 中根和前根遍历，生成树
	 * @param inorder
	 * @param postorder
	 * @return
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int num = inorder.length;
		if (num==0) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[0]);
		int len_r = 0;
		int len_l = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == root.val) {
				len_l = i;
				break;
			}
		}
		len_r = num - len_l - 1;
		if (len_l == 0) {
			root.left = null;
		} else {
			int[] l_inorder = new int[len_l];
			int[] l_postorder = new int[len_l];
			l_inorder = Arrays.copyOfRange(inorder, 0, len_l);
			l_postorder = Arrays.copyOfRange(preorder, 1, len_l+1);
			root.left = buildTree(l_postorder,l_inorder);
		}
		if (len_r == 0) {
			root.right = null;
		} else {
			int[] r_inorder = new int[len_r];
			int[] r_postorder = new int[len_r];
			r_inorder = Arrays.copyOfRange(inorder, len_l+1, num);
			r_postorder = Arrays.copyOfRange(preorder, len_l+1, num);
			root.right = buildTree(r_postorder,r_inorder);
		}

		return root;
	}

	public static void main(String[] args){
		int[] inorder = {4,2,5,1,3,6};
		int[] postorder = {4,5,2,6,3,1};
		int[] preorder = {1,2,4,5,3,6};
		TreeNode node = new BuildTree().buildTree(preorder, inorder);
	}
}
