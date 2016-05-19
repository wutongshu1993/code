package leeCode;
/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
 * @author lh
 *
 */
public class MinSubArrayLen {
	/**
	 * 超时
	 * @param s
	 * @param nums
	 * @return
	 */
//public int minSubArrayLen(int s, int[] nums) {
//    int min = nums.length;
//    int sum=0;
//    int flag=0;
//	for(int i=0;i<nums.length;i++){
//		sum = nums[i];
//		if (sum==s) {
//			return 1;
//		}
//    	for(int j=i+1;j<nums.length;j++){
//    		sum += nums[j];
//    		if (sum == s) {
//				min = j-i+1 < min ? j-i+1 : min;
//				flag = 1;
//			}
//    		else if(sum > s) {
//				break;
//			}
//    	}
//    	
//    } 
//	if (flag==0) {
//		return 0; 
//	}
//	 else {
//		return min;
//	} 
//    }
	/**
	 * 这个解是针对只能等于s的
	 * @param s
	 * @param nums
	 * @return
	 */
//public int minSubArrayLen(int s, int[] nums) {
//	if (nums.length == 0) {
//		return 0;
//	}
//	int start = 0;
//	int end = 0;
//	int flag=0;
//	int sum = nums[start];
//	int min = nums.length;
//	int len = nums.length;
//	while(start<len && end<len){
//		if (sum < s) {
//			end++;
//			if (end<len) {
//				sum += nums[end];
//			}
//		}
//		else if (sum >= s) {
//			sum = sum - nums[start++];
//		}
//		else if (sum == s) {
//			flag=1;
//			min = end-start+1<min ? end-start+1 : min;
//			end++;
//			if (end<len) {
//				sum = sum+nums[end];//这个地方应该让哪个加好一些呢
//			}
//			
//		}
//		
//	}
//	if (flag == 1) {
//		return min;
//	}
//	else {
//		return 0;
//	}
//}
	/**
	 * 这个解才是针对>=s的
	 * @param s
	 * @param nums
	 * @return
	 */
	public int minSubArrayLen(int s, int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int start = 0;
		int end = 0;
		int flag=0;
		int sum = nums[start];
		int min = nums.length;
		int len = nums.length;
		while(start<len && end<len){
			while (sum < s && end<len) {
				end++;
				if (end<len) {
					sum += nums[end];
				}
			}
			while (sum >= s && start<end) {
				flag=1;
				min = end-start+1<min ? end-start+1 : min;
				sum = sum - nums[start++];
				
			}
			
		}
		if (flag == 1) {
			return min;
		}
		else {
			return 0;
		}
	}
public static void main(String[] args){
	System.out.println(new MinSubArrayLen().minSubArrayLen(11, new int[]{1,2,3,4,5}));
}
}
