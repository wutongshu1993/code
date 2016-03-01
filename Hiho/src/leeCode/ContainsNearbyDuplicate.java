package leeCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers and an integer k, find out 
 * whether there are two distinct indices i and j in the array 
 * such that nums[i] = nums[j] 
 * and the difference between i and j is at most k.
 * @author lh
 *
 */
public class ContainsNearbyDuplicate {
public boolean containsNearbyDuplicate(int[] nums, int k){
	/*o(kn) time exceed
	 * int len = nums.length;
	for(int i=0;i<len;i++)
	for(int j=i+1;j<i+k && i+k<len;j++)
	{
		if (nums[i]==nums[j]) {
			return true;
		}
	}
	return false;*/
	int start=0,end =0;
	Set<Integer> numSet = new HashSet<>();
		for(int i=0;i<nums.length && end<nums.length ;i++){
			
			if (!numSet.contains(nums[i])) {
				numSet.add(nums[i]);
				end++;
			}
			else {
				return true;
			}
			if ((end-start) > k) {
				numSet.remove(nums[start]);
				start++;
			}
		}
	
	
	return false;
    }



public static void main(String[] args){
	int[] nums = {-1,-1};
	System.out.println(new ContainsNearbyDuplicate().containsNearbyDuplicate(nums, 1));
}
}
