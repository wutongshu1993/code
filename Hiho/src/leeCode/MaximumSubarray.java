package leeCode;

import javax.print.attribute.standard.NumberUpSupported;
/**
 * ����һ�����飬�ҳ���������к��������������飬����������
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
˼·����̬�滮�����⣬�����ҳ���Ҫ������⣨�ҳ�ԭ����--->dp[n]����������ĺͣ����Ϳ����ҳ�������dp[i]��������i��Ԫ�ص������������ĺͣ�
�������dp[]����������ҳ�����max��Ϊ����
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
