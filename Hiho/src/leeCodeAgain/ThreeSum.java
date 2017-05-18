package leeCodeAgain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ThreeSum {
public int[] threeSum(int[] nums, int target){//或者三重循环。。。
	
	int[] res = new int[3];
	int i = 1;
	
	
	while(i < nums.length- 2 ){
		int j = i+1; 
		int k = nums.length -1;
		while(j < k){
			int sum = nums[i]+nums[j] + nums[k];
			if(j < k && sum < target){
				j++;
			}
			else if(j < k && sum == target){
				res[0] = i;
				res[1] = j;
				res[2] = k;
				return res;
			}
			else if(j < k && sum > target){
				k--;
			}
		}
		i++;
		
	}
	return res;
	
}
}
