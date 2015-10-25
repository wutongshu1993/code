package leeCode;

import util.ArrayUtils;

public class TwoSum {
public static int[] twoSum(int[] nums, int target){
	int i,j;
	int index1,index2;
	int[] index = new int[2];
	for(i=0;i<nums.length;i++){
		for(j=i+1;j<nums.length;j++)
		{
			if (nums[i] + nums[j] == target) {
				index1 = i+1;
				index2 = j+1;
				index[0] = index1;
				index[1] = index2;
				return index;
			}
		}
		
	}
	return null;
}
public static void main(String[] args){
	int[] numbers = {3,2,4};
	int target = 6;
	int[] index = twoSum(numbers, target);
	ArrayUtils.printArray(index);
}
}
