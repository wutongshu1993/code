package leeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HouseRobber {
	/**
	 * ��һ���������ÿ������ĲƲ�����������͵���ڵ����ң�������͵����
	 * @param nums
	 * @return
	 */
public int rob(int[] nums){
	int rob = 0;
	int noRob = 0;
	int max = 0;
	for(int i=0;i<nums.length;i++){
		rob = noRob + nums[i];
		noRob = max;
		max = Math.max(rob, noRob);
	}
	
	return max;
}
/**
 * ��1�Ļ����ϣ����з���Χ��һ�����Σ����Ե�һ�Һ����һ�Ҳ���ͬʱ͵��������͵���ٲ���
 * @param nums
 * @return
 */

public int rob2(int[] nums) {
	
	
	if(nums.length == 1){
		return nums[0];
	}
	
	
	int rob1 = 0;
	int noRob1 = 0;
	int max1 = 0;
	
	
	for(int i=0;i<nums.length - 1;i++){
		rob1 = noRob1 + nums[i];
		noRob1 = max1;
		max1 = Math.max(rob1, noRob1);
	}
	
	
	int rob = 0;
	int noRob = 0;
	int max = 0;
	for(int i=1;i<nums.length;i++){
		rob = noRob + nums[i];
		noRob = max;
		max = Math.max(rob, noRob);
	}
	
	return Math.max(max, max1);
}
/**
 * һ������������������������ֵ���뷨���Ƚ��в���������ٽ�ÿһ��ĺ͵�������һ�������������rob1����������rob
 * 
 * !!!!!����ˣ��ǲ���͵�����б������Ķ�����
 * ���Ծ�
 * @param root
 * @return
 */
//public int rob3(TreeNode root) {
//	List<Integer> list = new ArrayList<>();
//	dfs(root, list, 0);
//	
//	int[] nums = new int[list.size()];
//	
//	for(int i = 0; i< nums.length; i++){
//		nums[i] = list.get(i);
//	}
//	int max = rob(nums);
//	return max;
//}
//��ʱ������һ������---�����root.left root.right root.left.left left.left.right root.right.left root.right.right������
//�ڼ���root.right��ʱ��Ҳ��Ҫ����root.right.left��root.right.right ---�ص�������
public int rob3(TreeNode root){
	if(root == null){
		return 0;
	}
	int val = 0;
	if(root.left != null){
		val += rob3(root.left.left) + rob3(root.left.right);
	}
	if(root.right !=  null){
		val += rob3(root.right.left) + rob3(root.right.right);
	}
	return Math.max(root.val + val, rob3(root.left) + rob3(root.right));
}

public int rob3_2(TreeNode root){
	Map<TreeNode, Integer> map = new HashMap<>();
	return rubSub(root, map);
	
}
//��ÿ�μ����ֵ����map���棬Map<TreeNode, Integer>
public int rubSub(TreeNode root, Map<TreeNode, Integer> map){
	int val = 0;
	if(root == null){
		return 0;
	}
	if(map.get(root) != null){
		return map.get(root);
	}
	if(root.left != null){
		val += rubSub(root.left.left, map) + rubSub(root.left.right, map);
	}
	if(root.right != null){
		val += rubSub(root.right.left, map) + rubSub(root.right.right, map);
	}
	val = Math.max(val + root.val, rubSub(root.left, map) + rubSub(root.right, map));
	map.put(root, val);
	return val;
}
/**
 * �����ַ�����ÿ���㶼������״̬---�����߲�������˶�״̬rub(root)�������£�����һ�����飬�����������Ԫ�أ��ֱ��ʾ����root����root,
 * Ȼ��root�ĵ�һ��Ԫ���ǵ�ֵ��rob(root.left)���صĽϴ�ֵ + rob(root.right)���صĽϴ�ֵ ֮�ͣ�
 * root�ĵڶ���Ԫ��Ϊroot.val + rob(root.left)[0] + rob(root.right)[0]
 * 
 */
public int rob(TreeNode root){
	int[] res = rubSub(root); 
	return Math.max(res[0], res[1]);
}
public int[] rubSub(TreeNode root){
	if(root == null){
		return new int[2];
	}
	
	int[] left = rubSub(root.left);
	int[] right = rubSub(root.right);
	int[] arr = new int[2];
	arr[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
	arr[1] = root.val + left[0] + right[0];
	return arr;
}
public void dfs(TreeNode node, List<Integer> list, int level) {
	if(node == null){
		return;
	}
	if(list.size() <= level){
		list.add(0);
	}
	
	list.set(level, list.get(level) + node.val);
	dfs(node.left, list, level + 1);
	dfs(node.right, list, level + 1);
	
}
public static void main(String[] args){
	int[] nums = {4,2,3,9};
	int a = new HouseRobber().rob(nums);
	
	
	TreeNode root = new TreeNode(2);
	TreeNode node1 = new TreeNode(1);
	TreeNode node2 = new TreeNode(3);
	TreeNode node3 = new TreeNode(4);
	
	
	root.left = node1;
	root.right = node2;
	node1.left = node3;
	

	
	
	System.out.println(new HouseRobber().rob3(root));
}
}
