package leeCode;

import javax.print.attribute.standard.NumberUpSupported;
/**
 * 给出一个数组，找出这个数组中和最大的连续的数组，并输出这个和
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
思路：动态规划的问题，首先找出需要求的问题（找出原问题--->dp[n]的最大连续的和），就可以找出子问题dp[i]：包含第i个元素的最大连续数组的和，
最后再在dp[]这个数组中找出最大的max即为所求。
 * @author lh
 *
 */
public class MaximumSubarray {
public int maxSubArray(int[] nums) {
    int len = nums.length;
    int[] dp = new int[len];
    dp[0] = nums[0];
    int max = nums[0];
    for(int i = 1; i < len; i++){
    	dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
    	max = Math.max(max, dp[i]);
    }
    
	return max;   
    }

public static void main(String[] args){
	int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
	System.out.println(new MaximumSubarray().maxSubArray(nums));
}
}
