package leeCode;

import java.util.Arrays;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
 * @author lh
 *
 */
public class LongestConsecutive {
public int longestConsecutive(int[] nums) {
    if (nums==null || nums.length==0) {
		return 0;
	} 
	Arrays.sort(nums);
     int len_max = 1;
     int len_temp = 1;
     int p = 0;
     int q = 0;
    
     while(p<nums.length && q <nums.length){
    	if(nums[p] == nums[q]){
    		q++;
    		p = q-1;
    	}
    	else if(nums[q] == nums[p] +1 ){
    		 len_temp++;
    		 p++;
    		 q++;
    	 }
    	else {
    		p = q-1;
    		len_max = Math.max(len_max, len_temp);
    		if (nums[q] == nums[p]+1 ) {
    		len_temp++;
       		 p++;
       		 q++;
			}
    		else {
				p++;
				q++;
				len_temp=1;
			}
		}
    	 
    	 
     }
     len_max = Math.max(len_max, len_temp);
	return len_max;
    }

public static void main(String[] args){
	int[] nums = {4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
	System.out.println(new LongestConsecutive().longestConsecutive(nums));
}
}
