package leeCode;
/**
 * 给一个排好序的数组，返回它的BST树
 * 想法就是先找出中间的元素作为根节点，然后再递归求它的左子树和右子树。
 * dfs状态：数组， 起始位置和结束位置。返回构造的子树。
 * @author lh
 *
 */
public class ConvertSortedArrayToBST {
public TreeNode sortedArrayToBST(int[] nums){
	int len = nums.length;
	if(len == 0){
		return null;
	}
	int mid = len / 2;
	int rootNum = nums[len / 2];
	TreeNode root = new TreeNode(rootNum);
	root.left = dfs(nums, 0, mid -1);
	root.right = dfs(nums, mid + 1, len-1);
	return root;
}
public TreeNode dfs(int[] nums, int left, int right){
	if(left > right){
		return null;
	}
	int mid = (left + right) / 2;
	TreeNode node = new TreeNode(nums[mid]);
	node.left = dfs(nums, left, mid - 1);
	node.right = dfs(nums, mid + 1, right);
	return node;
}

public static void main(String[] args){
	int[] nums = {1};
	new ConvertSortedArrayToBST().sortedArrayToBST(nums);
}
}
