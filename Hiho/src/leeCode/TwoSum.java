package leeCode;

import java.util.Arrays;
import java.util.HashMap;

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
/**
 * ������ҳ�����������Ԫ�أ�����������
 * @param nums
 * @param target
 * @return
 */
public int[] twoSum2(int[] nums, int target) {
    int len = nums.length;
    int[] ret = new int[2];
    int i = 0;
    int j = len - 1;
    Arrays.sort(nums);
    while(i < j ){
    	while(i < j && nums[i] + nums[j] < target){
    		i ++;
    	}
    	if(nums[i] + nums[j] == target){
    		ret[0] = nums[i];
    		ret[1] = nums[j];
    		return ret;
    	}
    	while(i < j && nums[i] + nums[j] > target){
    		j --;
    	}
    }
	return null;
}
/**
 *�Ϻõ�һ�ְ취��ͨ��һ��hashmap�洢ֵ�Ͷ�Ӧ����ţ����ж�map���Ƿ����target - nums[i]�Ӷ�ֻ��һ��ѭ���͹���
 * @param nums
 * @param target
 * @return
 */
public int[] twoSum3(int[] nums, int target) {
	int[] ret = new int[2];
	HashMap<Integer, Integer> map = new HashMap<>();//key : ֵ value�����
	for(int i = 0; i < nums.length; i++){
		if(map.containsKey(target - nums[i])){
			ret[1] = i;
			ret[0] = map.get(target - nums[i]);
			return ret;
		}
		else {
			map.put(nums[i], i);
		}
	}
	return ret;
}
public static void main(String[] args){
	int[] numbers = {3,2,4};
	int target = 6;
//	int[] index = twoSum(numbers, target);
//	ArrayUtils.printArray(index);
	
	ArrayUtils.printArray(new TwoSum().twoSum3(numbers, target));
}
}
