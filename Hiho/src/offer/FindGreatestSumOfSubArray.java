package offer;

public class FindGreatestSumOfSubArray {
	 public int FindGreatestSumOfSubArray(int[] array) {
	     int len = array.length;
	     int[] dp = new int[len];
	     if(len == 0){
	    	 return 0;
	     }
	     int max = array[0];
	     dp[0] = array[0];
	     for(int i = 1; i < len; i++){
	    	 dp[i] = Math.max(dp[i-1] + array[i], array[i]);
	    	 max = Math.max(max, dp[i]);
	     }
		 return max;
	    }
}
