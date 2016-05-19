package leeCode;

import java.util.Arrays;

public class FindMin {
	public int findMin1(int[] nums){
		if (nums.length==0) {
			return 0;
		}
		Arrays.sort(nums);
		return nums[0];
	}
	/**
	 * 采用二分
	 * 数组中的数不允许重复
	 * @param nums
	 * @return
	 */
	public int findMin(int[] nums){
		int low = 0;
		int high = nums.length-1;
		int mid = 0;
		if(nums[low] < nums[high]){//本身就是有序的
			   return nums[0]; 
			}
			while(high-low>1){//这个条件很好，避免了那种情况
				mid = (low+high)/2;
				if(nums[mid] < nums[high] ){//mid~hign 是有序的
					high = mid;
				}
				else {
					low = mid;
				}
			}
			return Math.min(nums[low], nums[high]);
	}
	/**
	 * 数组中的数允许重复 答案
	 * @param nums
	 * @return
	 */
	public int findMinII(int[] nums) {
	     int l = 0, r = nums.length-1;
	     while (l < r) {
	         int mid = (l + r) / 2;
	         if (nums[mid] < nums[r]) {
	             r = mid;
	         } else if (nums[mid] > nums[r]){
	             l = mid + 1;
	         } else {  
	             r--;  //nums[mid]=nums[r] no idea, but we can eliminate nums[r];
	         }
	     }
	     return nums[l];
	}
	public static void main(String[] args){
		int[] nums = {2,0,1,1,1};
		System.out.println(new FindMin().findMinII(nums));
	}
}
