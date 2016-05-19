package leeCode;

import java.util.Arrays;

public class MaxProfit {
	/**
	 * 给一个数组，第i个数代表股票在第i天的价格，每天只能买卖一次，怎样能获得最大的利益？
	 * 即找prices[i]-prices[j]的最大值，其中i>j.因为肯定要先买了才能卖，所以不能排序。
	 * 两个for循环，肯定可以实现功能，但是时间复杂度太高，
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
	    if (prices==null || prices.length == 0 ) {
			return 0;
		} 
	    int max = 0;
	    int temp = 0;
	    int len = prices.length;
		for(int i=0;i<len;i++){
			for(int j=i+1;j<len;j++){
				temp = prices[j] - prices[i];
				max = Math.max(temp, max);
			}
		}
		 return max;
	    }
	/**
	 * 先记录前面的最小值，取判断当前值-最小值 最大的为利润
	 * @param prices
	 * @return
	 */
	public int maxProfit2(int[] prices) {
	    if (prices==null || prices.length == 0 ) {
			return 0;
		} 
	    int max = 0;
	    int cur_min = prices[0];
	    int len = prices.length;
	    
		for(int i=1;i<len;i++){
			cur_min = Math.min(prices[i], cur_min) ;
			max = Math.max(max, prices[i]-cur_min);
			
		}
		 return max;
	    }
	/**
	 * 与前面不同的是，这次可以买卖多次，但是只能卖了才能再买，也就是手里只能有一支股票
	 * 从前向后遍历数组，只要当天的价格高于前一天的价格，就算入收益
	 * @param prices
	 * @return
	 */
	public int maxProfitII(int[] prices) {
	    if (prices==null || prices.length == 0 ) {
			return 0;
		} 
	    int max = 0;
	    int len = prices.length;
	    
		for(int i=1;i<len;i++){
			if(prices[i]>prices[i-1]){
				max += prices[i]-prices[i-1];
			}
		}
		 return max;
	    }
	/**
	 * 与第一题不同的是，最多可以买卖两次，求最大收益，再次买入之前必须先要卖掉。
	 * 想法：
	 * @param prices
	 * @return
	 */
	public int maxProfitIII(int[] prices) {
	    if (prices==null || prices.length == 0 ) {
			return 0;
		} 
	    int max = 0;
	    int len = prices.length;
	    int cur_min = prices[0];
	    int cur_max = prices[len-1];
	    int[] preProfit = new int[len];
	    int[] postProfit = new int[len];
	    for(int i=1;i<len;i++){
	    		cur_min = Math.min(prices[i], cur_min);
	    		preProfit[i] = Math.max(prices[i]-cur_min, preProfit[i-1]);	    	
	    }
	    
	    for(int i=len-2;i>=0;i--){
	    		cur_max = Math.max(prices[i], cur_max);
	    		postProfit[i] = Math.max(cur_max-prices[i], postProfit[i+1]);
				
	    		
	    }
	    for(int i=0;i<len;i++){
	    	max = Math.max(preProfit[i]+postProfit[i], max);
	    }
		 return max;}
	public static void main(String[] args){
		int[] prices = {1,30,20,100};
		System.out.println(new MaxProfit().maxProfitIII(prices));
	}
}
