package leeCode;

import java.util.Arrays;

import util.ArrayUtils;

public class FindPeakElement {
public int findPeakElement(int[] nums) {
    int max = 0;
    int index = 0;
    for(int i=1;i<nums.length;i++){
    	if (nums[i]>nums[i-1]) {
			max = nums[i];
			index = i;
		}
    }
	return index; 

    }
}
