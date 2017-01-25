package leeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sort.Merge;
/**
 * 找出数组中相加为0的三个数，返回的集合中，数字按照递增的顺序出现,返回的集合中不能出现重复的集合
 * @author lh
 *
 */
public class ThreeSum {
	/**
	 * 最笨的方法也就是三次循环呗，将满足条件的三个元素排序（这一步可以通过第一步就进行排序宠儿省略），然后再去重
	 * @param nums
	 * @return
	 */
public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
//	List threeeSum = new ArrayList<>();
	for (int i = 0; i < nums.length; i++) {
		for(int j=i+1;j<nums.length;j++){
			int temp = nums[i]+nums[j];
			for(int k=0;k<nums.length;k++){
				if (k>j && temp+nums[k] == 0 && k<nums.length){
					result.add(nonDescendingOrder(nums[i], nums[j], nums[k]));
				}
			}
		}
	}    
	result = removeDuplicate(result);
	return result;
    }
public List<Integer> nonDescendingOrder(int i,int j,int k){
	List<Integer> list = new ArrayList<>();
	if (i>j) {
		int temp = i;
		i = j;
		j = temp;
	}
	if (j>k) {
		int temp = j;
		j = k;
		k = temp;
	}
	if (i>j) {
		int temp = i;
		i = j;
		j = temp;
	}
	list.add(i);
	list.add(j);
	list.add(k);
	return list;
}
public List<List<Integer>> removeDuplicate(List<List<Integer>> list){
	List<List<Integer>> result = list;
	for(int i=0;i<list.size();i++){
		List<Integer> list1 = list.get(i);
		for(int j=i+1;j<list.size();j++){
			List<Integer> list2 = list.get(j);
			if (isDuplicate(list1, list2)) {
				result.remove(j);
			}
		}
	}
	return result;
}
public boolean isDuplicate(List<Integer> list1, List<Integer> list2){
	for (int i = 0; i < list1.size(); i++) {
		if (list1.get(i) != list2.get(i)) {
			return false;
		}
	}
	return true;
}
/**
 * 所谓的双指针，这两个指针一定要是在两边。
 * 首先对数组进行排序，然后设定三个指针，I,J,K分别指向首，尾，尾-1。计算sum = num[i]+num[j]+num[k]的和分三种情况讨论，小于、等于、大于0
 * 这三种情况，每种情况都要用while排除相邻两个数相等的情况。
 * @param nums
 * @return
 */
public List<List<Integer>> threeSum2(int[] nums){
	if (nums == null) {
		return null;
	}
	List<List<Integer>> result = new ArrayList<>();
	Arrays.sort(nums);
//	for(int i=0;i<nums.length;i++){
//		if (nums[i]>0) {
//			return result;
//		}
//		for(int j=nums.length-1;j>i;j--){
//			for(int k=j-1;k>i;){
//				if (nums[i]+nums[j]+nums[k] < 0) {
//					//跳出循环
//					j=i;
//					k=i;
//				}
//				else if (nums[i]+nums[j]+nums[k] == 0) {
//					result.add(Arrays.asList(nums[i],nums[k],nums[j]));
//					k=i;
//					while(nums[j]==nums[k]){
//						j--;
//					}
//				}
//				else if (nums[i]+nums[j]+nums[k] > 0) {
//					k--;
//				}
//				
//			}
//		}
//	}
//	result = removeDuplicate(result);

int j = nums.length-1;
while(j>1){
	int i = 0;
	int k = j-1;
	while(k>i){
		int sum = nums[i]+nums[j]+nums[k];
		if (sum < 0) {
			do {
				i++;
			} while (i<k&&nums[i] == nums[i-1] );//去除重复的数字
		}
		else if(sum == 0){
			result.add(Arrays.asList(nums[i],nums[k],nums[j]));
			
			do {
				k--;
			} while (i<k&&nums[k]==nums[k+1] );
			do {
				i++;
			} while (i<k&&nums[i] == nums[i-1]);
			
		}
		else {
			do {
				k--;
			} while (i<k && nums[k]==nums[k+1]);
		}
		
	}
	do {
		j--;
	} while (j>i&&nums[j]==nums[j+1]);
}
	return  result;

}
/**
 * 看的答案，主要针对对重复数组的处理
 * @param nums
 * @return
 */
public List<List<Integer>> threeSum3(int[] nums){
	if (nums == null) {
		return null;
	}
	List<List<Integer>> result = new ArrayList<>();
	if (nums.length<3) {
		return result;
	}
	Arrays.sort(nums);
	int n = nums.length;
	int i=0;
	while(i<n-2){
		int start = i+1;
		int end = n-1;
		while(end>start){
			int sum = nums[i]+nums[start]+nums[end];
			if (sum<0) {
				do {
					start++;
				} while (start<end&& nums[start]==nums[start-1] );
			}
			else if(sum==0) {
				result.add(Arrays.asList(nums[i],nums[start],nums[end]));
				do {
					start++;
				} while (start<end&&nums[start] == nums[start-1]);
				do {
					end--;
				} while (start<end&&nums[end]==nums[end+1] );
			}
			else {
				do {
					end--;
				} while (start<end&&nums[end]==nums[end+1]);
			}
		}
		do {
			i++;
		} while (i<n-2 && nums[i]==nums[i-1] );
	}
	
	
	return result;
}
public static void main(String[] args){
// List<Integer> list = new ThreeSum().nonDescendingOrder(9, 4, 1)	;
 int[] nums = {-15,13,6,-11,-4,5,-13,5,3,2,6,-1,4,12,-10,-13,-7,-4,-5,6,9,-14,1,-6,13,7,-8,10,-4,11,-8,-3,1,5,-7,4,-13,-13,-5,-3,4,-14,11,-14,5,-13,-12,13,-10,-10,-4,-15,13,13,-14,11,-3,-15,6,1,3,5,13,-11,-5,-9,1,-2,-14,11,10,5,4,-1,6,-6,-7,9,-15,-2,7,-12,-10,5,-14,13,-6,-9,6,7,7,-6,-2,-3,-9,0,-5,7,5,-4,-5,-7,-13,14,7,8,-15,7,-5,-15,-10,9};
//	int[] nums ={-2,0,1,1,2};
	new ThreeSum().threeSum2(nums);
}
}
