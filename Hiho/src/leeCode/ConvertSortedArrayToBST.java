package leeCode;
/**
 * ��һ���ź�������飬��������BST��
 * �뷨�������ҳ��м��Ԫ����Ϊ���ڵ㣬Ȼ���ٵݹ�����������������������
 * dfs״̬�����飬 ��ʼλ�úͽ���λ�á����ع����������
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
