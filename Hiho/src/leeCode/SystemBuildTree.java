package leeCode;

import java.util.LinkedList;

//�����ṩ�����飬���������������ڲ��Գ���
public class SystemBuildTree {
public static TreeNode buildTree(Object[] nums){
	TreeNode root;
	if(nums.length > 0){
		root = new TreeNode((int)nums[0]);
	}
	for(int i = 0; i < nums.length; i++){
		if(nums[i] != null){
			
		}
		else{
			
		}
		
	}
	return null;
}

public static void bfs(LinkedList<Object> nums){
	while(!nums.isEmpty()){
	if(nums.peek() != null){
		TreeNode newNode = new TreeNode((int)nums.peek());
	}
	}
}
}
