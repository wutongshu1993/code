package leeCode;

public class MaxProduct {
	//竟然超时了
	 public int maxProduct(int[] nums) {
	     int len = nums.length;
	     int max = nums[0];
	     int [][] a = new int[len][len];
		 for(int i=0;i<nums.length;i++){
	    	 a[i][i] = nums[i];
	     } 
		 for(int i=0;i<len;i++)
			 for(int j=i+1;j<len;j++){
				 a[i][j] =a[j][j]*a[i][j-1];
				 max = Math.max(a[i][j], max);
			 }
		 return max; 
	    }
	 /*改进,思想，保留当前最大和最小的两个数；并且，当还有一个选择起点的逻辑，如果之前的最大和最小
	  * 值同当前元素相乘之后，没有当前元素大（或小）那么当前元素就可以作为新的起点。
	  * 答案
	  * */
	 public int maxProduct2(int[] nums){
		 if (nums==null||nums.length==0) {
			return 0;
		}
		 int temp_min = nums[0];
		 int temp_max = nums[0];
		 int max = nums[0];
		 for(int i=1;i<nums.length;i++){
			 int a = nums[i]*temp_max;
			 int b = nums[i]*temp_min;
			 temp_max = Math.max(Math.max(a, b), nums[i]);
			 temp_min = Math.min(Math.min(a, b), nums[i]);
			 max = Math.max(max, temp_max); 
		 }
		 return max;
	 }

	
	 public static void main(String[] args){
		 int[] nums = {2,3,-2,4};
		 System.out.println(new MaxProduct().maxProduct(nums));
	 }
}
