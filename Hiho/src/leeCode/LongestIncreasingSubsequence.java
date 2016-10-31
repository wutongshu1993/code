package leeCode;
/**
 * 最长上升子序列
 * 首先根据要求的问题来定义状态：dP[i]
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS 
 * @author lh
 *
 */
public class LongestIncreasingSubsequence {
public int lengthOfLIS(int[] nums) {
    int len = nums.length;
    int[] dp = new int[len];
    int max = 0;
    //初始化
    for(int i = 0; i < len; i++){
    	dp[i] = 1;
    }
	for(int i = 1; i < len; i++){
		for(int j = 0; j < i; j++){
			if(nums[i] > nums[j]){
				dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			
		}
	}
	for(int i = 0; i < len; i++){
		max = Math.max(max, dp[i]);
	}
	return max;   
    }
public static void main(String[] args){
	int[] nums = {};
	System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums));
}
}
