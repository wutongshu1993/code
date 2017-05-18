package offer;

import java.util.Arrays;

/**
 * 根据前序和中序重建二叉树
 * @author lh
 *
 */
public class ReConstructBT {
	 public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
	     if(pre[0] == 0){
	    	 return null;
	     }   
		 int root = pre[0];
	        int index = getIndex(in, root);
	        TreeNode treeRoot = new TreeNode(root);
	        int[] pre_left = splice(pre, 1, index);
	        int[] in_left = splice(in, 0, index);
	        int[] pre_right = splice(pre, index+1, in.length - index -1);
	        int[] in_right = splice(in, index+1, in.length - index - 1);
	        treeRoot.left = reConstructBinaryTree(pre_left, in_left);
	        treeRoot.right = reConstructBinaryTree(pre_right, in_right);
	        return treeRoot;
	        
	    }
	 public static int getIndex(int[] array, int target){
		 for (int i : array) {
			if(array[i] == target){
				return i;
			}
		}
		 return -1;
	 }
	 public static int[] splice(int[] arr, int from, int len){
		 int[] res = new int[len];
		 int index = 0;
		 for(int i = from; i < arr.length && (i-from+1)<= len; i++){
			 res[index++] = arr[i];
		 }
		 return res;
	 }
	 
	 public static void main(String[] args){
		 int[] arr = {1,2,3,4,5};
		 int[] res = splice(arr, 2, 2);
		 System.out.println(res);

	 }
}
