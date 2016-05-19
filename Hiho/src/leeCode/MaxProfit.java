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
