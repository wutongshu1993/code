package leeCodeAgain;

import java.util.HashMap;

import util.ArrayUtils;




public class TwoSum {
public int[] twoSum(int[] nums, int target){
	HashMap<Integer, Integer> map = new HashMap<>();
	int[] res = new int[2];
	for(int i = 0; i < nums.length; i++){
		if(map.containsKey(nums[i])){
			res[0] = map.get(nums[i]);
			res[1] = i;
			return res;
		}
		else {
			map.put(target - nums[i], i);
		}
	}
	return res;
}
public static void main(String[] args){
	int[] numbers = {3,2,4};
	int target = 6;
//	int[] index = twoSum(numbers, target);
//	ArrayUtils.printArray(index);
	
	ArrayUtils.printArray(new TwoSum().twoSum(numbers, target));
}
}
