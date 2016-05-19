package leeCode;

import java.util.Arrays;

/**
 * 一个大小为数组里面有n+1个数（大小在1~n），证明至少有一个数是重复的。
 * 返回重复的数字
 * 要求，不能改变数组的值，最多用一个额外空间，复杂度小于o（n*n）
 * 假设重复的数只有一个米并且该数可以被重复多次
 * 最简单的办法是排序以后再比较，但这里不能进行排序
 * 第二种方法是暴力
 * @author lh
 *
 */
public class FindDuplicate {
	/**
	 * n*n
	 * @param nums
	 * @return
	 */
public int findDuplicate(int[] nums) {
    int n = nums.length;
    int pos=0;
    for(int i=0;i<n;i++)
    	for(int j=i+1;j<n;j++){
    		if (nums[i]==nums[j]) {
				pos++;
			}
    		if (pos>0) {
				return nums[i];
			}
    	}
	return 0;
    }
public int findDuplicate2(int[] nums){
	Arrays.sort(nums);
	for(int i=1;i<nums.length;i++){
		if (nums[i] == nums[i-1]) {
			return nums[i];
		}
	}
	return 0;
}
/**
 * 2分查找，假设有范围为1~10，小于等于5的数如果多于5个，前半部分找
 * @param nums
 * @return325
 * 
 */
public int findDuplicate3(int[] nums){
	int len = nums.length;
	int low = 1;
	int high = len-1;
	int media = 0;
	while(low<high ){
		media = (high+low)/2;
		int num = 0;
		for(int i=0;i<len;i++){
			if (nums[i]<=media ) {
				num++;
			}
			//小于等于中间数的个数大于
			if (num>media) {
				high = media;
				break;
			}
		}
		
		if (num<=media){
			low = media+1;//+1!!!!!
		}
	}
	if (low== high) {
		return low;
	}
	return 0;
}
public static void main(String[] args){
	int[] nums = {1,3,2,3,4,5};//
	System.out.println(new FindDuplicate().findDuplicate3(nums));
}
}
