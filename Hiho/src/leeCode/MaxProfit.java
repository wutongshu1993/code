package leeCode;

import java.util.Arrays;

public class MaxProfit {
	/**
	 * ��һ�����飬��i���������Ʊ�ڵ�i��ļ۸�ÿ��ֻ������һ�Σ������ܻ���������棿
	 * ����prices[i]-prices[j]�����ֵ������i>j.��Ϊ�϶�Ҫ�����˲����������Բ�������
	 * ����forѭ�����϶�����ʵ�ֹ��ܣ�����ʱ�临�Ӷ�̫�ߣ�
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
	 * �ȼ�¼ǰ�����Сֵ��ȡ�жϵ�ǰֵ-��Сֵ ����Ϊ����
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
	 * ��ǰ�治ͬ���ǣ���ο���������Σ�����ֻ�����˲�������Ҳ��������ֻ����һ֧��Ʊ
	 * ��ǰ���������飬ֻҪ����ļ۸����ǰһ��ļ۸񣬾���������
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
	 * ���һ�ⲻͬ���ǣ��������������Σ���������棬�ٴ�����֮ǰ������Ҫ������
	 * �뷨��
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
	    //�ڵ�i�죨��������֮ǰ���е�һ���������������õ���ϢΪpreProfit[i]
	    for(int i=1;i<len;i++){
	    		cur_min = Math.min(prices[i], cur_min);
	    		preProfit[i] = Math.max(prices[i]-cur_min, preProfit[i-1]);	    	
	    }
	    //�ڵ�i�켰֮����еڶ����������������õ���ϢΪpostProfit[i]
	    
	    for(int i=len-2;i>=0;i--){
	    		cur_max = Math.max(prices[i], cur_max);
	    		postProfit[i] = Math.max(cur_max-prices[i], postProfit[i+1]);
				
	    		
	    }
	    for(int i=0;i<len;i++){
	    	max = Math.max(preProfit[i]+postProfit[i], max);
	    }
		 return max;}
	
	/**
	 * ����������K�����������������
	 * @param k
	 * @param prices
	 * @return
	 */
public int maxProfitIV(int k, int[] prices) {
    int hold = Integer.MIN_VALUE, release = 0;    
	return 0;
    }
	public static void main(String[] args){
		int[] prices = {1,30,20,100};
		System.out.println(new MaxProfit().maxProfitIII(prices));
	}
}
/**
 *���еĽⷨ
 * public class Solution {
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far. 
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }
}
 */
